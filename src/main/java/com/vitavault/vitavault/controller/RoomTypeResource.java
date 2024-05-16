package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.RoomType;
import com.vitavault.vitavault.model.input.InputRoomType;
import com.vitavault.vitavault.service.type.room.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class RoomTypeResource {
    @Autowired
    private IRoomTypeService service;
    
    //Queries
    @QueryMapping
    public List<RoomType> getAllRoomType() {
        return service.getAll();
    }

    @QueryMapping
    public RoomType getRoomType(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createRoomType(@Argument InputRoomType input) {
        service.create(input);
    }

    @MutationMapping
    public void updateRoomType(@Argument UUID id, @Argument InputRoomType input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteRoomType(@Argument UUID id) {
        service.delete(id);
    }
}
