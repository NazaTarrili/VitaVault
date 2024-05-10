package com.vitavault.vitavault.service.bank;

import com.vitavault.vitavault.model.domain.Bank;
import com.vitavault.vitavault.model.input.InputBank;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IBankService extends IBaseService<Bank>, ICreateUpdate<InputBank> {
}
