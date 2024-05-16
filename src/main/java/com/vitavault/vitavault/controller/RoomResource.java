package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.Room;
import com.vitavault.vitavault.model.input.InputRoom;
import com.vitavault.vitavault.service.room.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class RoomResource {
    @Autowired
    private IRoomService service;
    
    //Queries
    @QueryMapping
    public List<Room> getAllRoom() {
        return service.getAll();
    }

    @QueryMapping
    public Room getRoom(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createRoom(@Argument InputRoom input) {
        service.create(input);
    }

    @MutationMapping
    public void updateRoom(@Argument UUID id, @Argument InputRoom input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteRoom(@Argument UUID id) {
        service.delete(id);
    }
}
