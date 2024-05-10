package com.vitavault.vitavault.service.socialWork;

import com.vitavault.vitavault.model.domain.SocialWork;
import com.vitavault.vitavault.model.input.InputSocialWork;
import com.vitavault.vitavault.repository.SocialWorkRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SocialWorkServiceImpl extends BaseServiceImpl<SocialWork, SocialWorkRepository> implements ISocialWorkService {
    @Override
    public void create(InputSocialWork input) {

    }

    @Override
    public void update(UUID id, InputSocialWork input) {

    }
}
