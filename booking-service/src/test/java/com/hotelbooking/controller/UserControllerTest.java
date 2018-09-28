package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.Authority;
import com.hotelbooking.entity.User;
import com.hotelbooking.service.UserService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
public class UserControllerTest {

    private final String USERS_URL = "/api/users";
    private final int ROLE_ONE_ID = 1;
    private final int ROLE_TWO_ID = 2;
    private final int ROLE_THREE_ID = 3;
    private final boolean USER_ENABLED = true;
    private final boolean USER_NOT_ENABLED = false;

    @MockBean
    private UserService service;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllUsers() throws Exception {

        // given
        List<User> expectedUsers = new ArrayList<>();

        Set<Authority> rolesUserOne = new HashSet<>();
        Authority roleOne = new Authority(ROLE_ONE_ID, "userOne", "ROLE_ADMIN");
        rolesUserOne.add(roleOne);
        User userOne = new User("userOne", "password userOne", USER_ENABLED,
                "First name userOne","Last name userOne", rolesUserOne);
        expectedUsers.add(userOne);

        Set<Authority> rolesUserTwo = new HashSet<>();
        Authority roleTwo = new Authority(ROLE_TWO_ID, "userTwo", "ROLE_USER");
        rolesUserTwo.add(roleTwo);
        User userTwo = new User("userTwo", "password userTwo", USER_ENABLED,
                "First name userTwo","Last name userTwo", rolesUserTwo);
        expectedUsers.add(userTwo);

        Set<Authority> rolesUserThree = new HashSet<>();
        Authority roleThree = new Authority(ROLE_THREE_ID, "userThree", "ROLE_USER");
        rolesUserThree.add(roleThree);
        User userThree = new User("userThree", "password userThree", USER_NOT_ENABLED,
                "First name userThree","Last name userThree", rolesUserThree);
        expectedUsers.add(userThree);
        given(service.getAllUsers()).willReturn(expectedUsers);

        // when
        String result = mockMvc.perform(get(USERS_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(expectedUsers);
        verify(service).getAllUsers();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getUser() throws Exception {

        // given
        Set<Authority> roles = new HashSet<>();
        Authority roleOne = new Authority(ROLE_ONE_ID, "username", "ROLE_ADMIN");
        roles.add(roleOne);
        Authority roleTwo = new Authority(ROLE_ONE_ID, "username", "ROLE_USER");
        roles.add(roleTwo);
        User user = new User("username", "password", USER_ENABLED,
                "First name","Last name", roles);
        given(service.getUser("username")).willReturn(user);

        // when
        String result = mockMvc.perform(get(USERS_URL.concat("/").concat("username"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(user);
        verify(service).getUser("username");
        verifyNoMoreInteractions(service);
    }
}