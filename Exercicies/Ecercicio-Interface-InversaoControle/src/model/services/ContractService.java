package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private IOnlinePaymentService _onlinePaymentService;

	public ContractService(IOnlinePaymentService _onlinePaymentService) {
		this._onlinePaymentService = _onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		
		for(int i = 1; i <= months; i++) {
			double sum = 0.0;
			double valueParcel = contract.getValue() / months;
			sum += _onlinePaymentService.interest(valueParcel, i);
			sum += _onlinePaymentService.paymentFee(valueParcel + sum);
			sum += valueParcel;
			contract.getInstallment().add(new Installment(contract.getDate().plusMonths(i), sum));
		}
	}
}
