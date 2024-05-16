package com.vitavault.vitavault.model.input;

import com.vitavault.vitavault.model.input.base.BaseInput;

import java.util.UUID;

public record InputBillingDetail(
    String taxIdentifier,
    String email,
    String accountNumber,
    String reference,
    String iban,
    String phoneNumber,
    UUID bank,
    UUID person,
    UUID address
) implements BaseInput {
    @Override
    public boolean hasData() {
        return taxIdentifier != null ||
                email != null ||
                accountNumber != null ||
                reference != null ||
                iban != null ||
                phoneNumber != null ||
                bank != null ||
                person != null ||
                address != null;
    }
}
