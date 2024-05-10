package com.vitavault.vitavault.service.episode;

import com.vitavault.vitavault.model.domain.Episode;
import com.vitavault.vitavault.model.input.InputEpisode;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IEpisodeService extends IBaseService<Episode>, ICreateUpdate<InputEpisode> {
}
