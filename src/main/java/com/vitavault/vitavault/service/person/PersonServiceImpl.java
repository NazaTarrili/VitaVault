package com.vitavault.vitavault.service.person;

import com.vitavault.vitavault.model.domain.Person;
import com.vitavault.vitavault.model.input.InputPerson;
import com.vitavault.vitavault.repository.PersonRepository;
import com.vitavault.vitavault.service.address.IAddressService;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.type.document.IDocumentTypeService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepository> implements IPersonService {
    private final String className = Person.class.getName();

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IDocumentTypeService documentTypeService;

    @Override
    public void create(InputPerson input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);
        requestValidator.invalidRequest(new Property("lastname", input.lastname()), className);
        requestValidator.invalidRequest(new Property("document", input.document()), className);
        requestValidator.invalidRequest(new Property("phone number", input.phoneNumber()), className);
        requestValidator.invalidRequest(new Property("email", input.email()), className);
        requestValidator.invalidRequest(new Property("gender", input.gender()), className);
        requestValidator.invalidRequest(new Property("birthdate", input.birthdate()), className);
        requestValidator.invalidRequest(new Property("address", input.address()), className);
        requestValidator.invalidRequest(new Property("document type", input.documentType()), className);

        repository.save(
                Person.builder()
                        .name(input.name())
                        .lastname(input.lastname())
                        .document(input.document())
                        .phoneNumber(input.phoneNumber())
                        .email(input.email())
                        .gender(input.gender())
                        .birthdate(input.birthdate())
                        .registrationDate(LocalDateTime.now())
                        .address(addressService.getByID(input.address()))
                        .documentType(documentTypeService.getByID(input.documentType()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputPerson input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Person person = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            person.setName(input.name());

        if (validate.isNonEmptyString(input.lastname()))
            person.setLastname(input.lastname());

        if (validate.isNonEmptyString(input.document()))
            person.setDocument(input.document());

        if (validate.isNonEmptyString(input.phoneNumber()))
            person.setPhoneNumber(input.phoneNumber());

        if (validate.isNonEmptyString(input.email()))
            person.setEmail(input.email());

        if (validate.isGender(input.gender()))
            person.setGender(input.gender());

        if (validate.isLocalDateTime(input.birthdate()))
            person.setBirthdate(input.birthdate());

        if (validate.isUUID(input.address()))
            person.setAddress(addressService.getByID(input.address()));

        if (validate.isUUID(input.documentType()))
            person.setDocumentType(documentTypeService.getByID(input.documentType()));

        repository.save(person);
    }
}
