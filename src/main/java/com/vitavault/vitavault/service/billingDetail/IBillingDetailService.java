package com.vitavault.vitavault.service.billingDetail;

import com.vitavault.vitavault.model.domain.BillingDetail;
import com.vitavault.vitavault.model.input.InputBillingDetail;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IBillingDetailService extends IBaseService<BillingDetail>, ICreateUpdate<InputBillingDetail> {
}
