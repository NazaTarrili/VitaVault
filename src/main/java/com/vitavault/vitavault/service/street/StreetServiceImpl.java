package com.vitavault.vitavault.service.street;

import com.vitavault.vitavault.model.domain.Street;
import com.vitavault.vitavault.model.input.InputStreet;
import com.vitavault.vitavault.repository.StreetRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class StreetServiceImpl extends BaseServiceImpl<Street, StreetRepository> implements IStreetService {
    @Override
    public void create(InputStreet input) {

    }

    @Override
    public void update(UUID id, InputStreet input) {

    }
}
