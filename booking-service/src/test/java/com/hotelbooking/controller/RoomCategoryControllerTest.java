package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.request.RoomCategoryRequest;
import com.hotelbooking.service.RoomCategoryService;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoomCategoryController.class)
@Import(SecurityConfig.class)
public class RoomCategoryControllerTest{

    private final String ROOM_CATEGORIES_URL = "/api/roomCategories";
    private final int ROOM_CATEGORY_ONE_ID = 1;
    private final int ROOM_CATEGORY_TWO_ID = 2;
    private final int ROOM_CATEGORY_THREE_ID = 3;

    @MockBean
    private RoomCategoryService service;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllRoomCategories() throws Exception {

        // given
        List<RoomCategory> roomCategories = new ArrayList<>();
        roomCategories.add(new RoomCategory(ROOM_CATEGORY_ONE_ID, "Room category one name",
                "Room category one description"));
        roomCategories.add(new RoomCategory(ROOM_CATEGORY_TWO_ID, "Room category two name",
                "Room category two description"));
        roomCategories.add(new RoomCategory(ROOM_CATEGORY_THREE_ID, "Room category three name",
                "Room category three description"));
        given(service.getAllRoomCategories()).willReturn(roomCategories);

        // when
        String result = mockMvc.perform(get(ROOM_CATEGORIES_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(roomCategories);
        verify(service).getAllRoomCategories();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void saveRoomCategory() throws Exception {

        // given
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ONE_ID, "Room category name",
                "Room category description" );
        RoomCategoryRequest request = new RoomCategoryRequest(ROOM_CATEGORY_ONE_ID, "Room category name",
                "Room category description");
        given(service.saveRoomCategory(request)).willReturn(roomCategory);
        String requestJson =
                "{\"id\":\"1\",\"name\":\"Room category name\",\"description\":\"Room category description\"}";

        // when
        String result = mockMvc.perform(post(ROOM_CATEGORIES_URL)
                .content(requestJson)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(roomCategory);
        verify(service).saveRoomCategory(request);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getRoomCategory() throws Exception {

        // given
        RoomCategory roomCategory = new RoomCategory(ROOM_CATEGORY_ONE_ID, "Room category name",
                "Room category description" );
        given(service.getRoomCategory(ROOM_CATEGORY_ONE_ID)).willReturn(roomCategory);

        // when
        String result = mockMvc.perform(get(ROOM_CATEGORIES_URL.concat("/").concat("1"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(roomCategory);
        verify(service).getRoomCategory(ROOM_CATEGORY_ONE_ID);
        verifyNoMoreInteractions(service);
    }
}