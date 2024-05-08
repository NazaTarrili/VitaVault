package com.vitavault.vitavault.model.input;

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
) {}
