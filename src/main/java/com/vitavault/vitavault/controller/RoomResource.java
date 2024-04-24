package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Room;
import com.vitavault.vitavault.service.room.RoomServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/room")
@CrossOrigin(origins = "*")
public class RoomResource extends BaseControllerImpl<Room, RoomServiceImpl> {
}
