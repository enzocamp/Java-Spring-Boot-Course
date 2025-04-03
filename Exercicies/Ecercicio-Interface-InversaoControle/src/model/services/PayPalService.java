package model.services;

public class PayPalService implements IOnlinePaymentService{
	
	public static final double monthlyFee = 0.01;
	public static final double paymentfee = 0.02;

	@Override
	public Double paymentFee(double amount) {
		return amount * paymentfee;
	}

	@Override
	public Double interest(double amount, int months) {
		return amount * monthlyFee * months; 
	}

}
