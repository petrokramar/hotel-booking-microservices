package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.User;
import com.hotelbooking.entity.request.BookingRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository repository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;

    @Override
    public List<Booking> getAllBooking() {
        List<Booking> booking = (List<Booking>) repository.findAll();
        return booking;
    }

    @Override
    public Booking getBooking(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format("Booking id= %s not found", id)));
    }

    @Override
    public Booking saveBooking(BookingRequest request) {
        String username = request.getUsername();
        User user = userRepository.findById(username)
                .orElseThrow(() -> new DataNotFoundException(String.format("User username= %s not found", username)));
        int roomId = request.getRoomId();
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new DataNotFoundException(String.format("Room id= %s not found", roomId)));
        Booking booking = new Booking(request.getId(), room, user, request.getTotalSum(), request.getPersons(),
                request.getCheckIn(), request.getCheckOut());
        return repository.save(booking);
    }
}
