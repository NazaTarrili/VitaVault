package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.controller.base.BaseControllerImpl;
import com.vitavault.vitavault.domain.RoomType;
import com.vitavault.vitavault.service.type.room.RoomTypeServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/type/room", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class RoomTypeResource extends BaseControllerImpl<RoomType, RoomTypeServiceImpl> {
}
