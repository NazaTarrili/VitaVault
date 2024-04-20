package com.vitavault.vitavault.service.episode;

import com.vitavault.vitavault.domain.Episode;
import com.vitavault.vitavault.repository.EpisodeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EpisodeServiceImpl extends BaseServiceImpl<Episode, EpisodeRepository> implements IEpisodeService {
}
