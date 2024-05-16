package com.vitavault.vitavault.service.socialWork;

import com.vitavault.vitavault.model.domain.SocialWork;
import com.vitavault.vitavault.model.input.InputSocialWork;
import com.vitavault.vitavault.repository.SocialWorkRepository;
import com.vitavault.vitavault.service.address.IAddressService;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SocialWorkServiceImpl extends BaseServiceImpl<SocialWork, SocialWorkRepository> implements ISocialWorkService {
    private final String className = SocialWork.class.getName();

    @Autowired
    private IAddressService addressService;

    @Override
    public void create(InputSocialWork input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("address", input.address()), className);

        repository.save(
                SocialWork.builder()
                        .name(input.name())
                        .address(addressService.getByID(input.address()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputSocialWork input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        SocialWork socialWork = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            socialWork.setName(input.name());

        if (validate.isUUID(input.address()))
            socialWork.setAddress(addressService.getByID(input.address()));

        repository.save(socialWork);
    }
}
