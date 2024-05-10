package com.vitavault.vitavault.service.socialWork;

import com.vitavault.vitavault.model.domain.SocialWork;
import com.vitavault.vitavault.model.input.InputSocialWork;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ISocialWorkService extends IBaseService<SocialWork>, ICreateUpdate<InputSocialWork> {
}
