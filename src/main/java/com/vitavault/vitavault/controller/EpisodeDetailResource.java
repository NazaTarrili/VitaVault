package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.EpisodeDetail;
import com.vitavault.vitavault.service.episodeDetail.EpisodeDetailServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/episodeDetail")
@CrossOrigin(origins = "*")
public class EpisodeDetailResource extends BaseControllerImpl<EpisodeDetail, EpisodeDetailServiceImpl> {
}
