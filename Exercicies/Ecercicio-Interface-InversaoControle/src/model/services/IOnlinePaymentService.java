package model.services;

public interface IOnlinePaymentService {
	Double paymentFee(double amount);
	Double interest(double amount, int months);
}
