package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.RoomType;
import com.vitavault.vitavault.service.type.room.RoomTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/type/room")
@CrossOrigin(origins = "*")
public class RoomTypeResource extends BaseControllerImpl<RoomType, RoomTypeServiceImpl> {
}
