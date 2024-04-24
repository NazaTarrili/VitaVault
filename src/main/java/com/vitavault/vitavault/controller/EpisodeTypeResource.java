package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.EpisodeType;
import com.vitavault.vitavault.service.type.episode.EpisodeTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/type/episode")
@CrossOrigin(origins = "*")
public class EpisodeTypeResource extends BaseControllerImpl<EpisodeType, EpisodeTypeServiceImpl> {
}
