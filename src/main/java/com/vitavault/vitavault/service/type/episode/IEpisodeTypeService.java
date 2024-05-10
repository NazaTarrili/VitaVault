package com.vitavault.vitavault.service.type.episode;

import com.vitavault.vitavault.model.domain.EpisodeType;
import com.vitavault.vitavault.model.input.InputEpisodeType;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IEpisodeTypeService extends IBaseService<EpisodeType>, ICreateUpdate<InputEpisodeType> {
}
