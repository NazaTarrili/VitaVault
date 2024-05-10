package com.vitavault.vitavault.service.episodeDetail;

import com.vitavault.vitavault.model.domain.EpisodeDetail;
import com.vitavault.vitavault.model.input.InputEpisodeDetail;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IEpisodeDetailService extends IBaseService<EpisodeDetail>, ICreateUpdate<InputEpisodeDetail> {
}
