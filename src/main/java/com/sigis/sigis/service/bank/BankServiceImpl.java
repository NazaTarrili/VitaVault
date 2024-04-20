package com.sigis.sigis.service.bank;

import com.sigis.sigis.domain.Bank;
import com.sigis.sigis.repository.BankRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BankServiceImpl extends BaseServiceImpl<Bank, BankRepository> implements IBankService {
}
