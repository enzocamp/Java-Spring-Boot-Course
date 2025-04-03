package model.entities;

import model.exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawlLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdraLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawlLimit = withdraLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getholder() {
		return holder;
	}

	public void setholder(String holder) {
		holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawlLimit;
	}

	public void setWithdrawLimit(Double withdraLimit) {
		this.withdrawlLimit = withdraLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {
			validateWithdraw(amount);
			balance -= amount;
	}
	
	private void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		} 
		if (amount > getBalance()) {
			throw new BusinessException("Erro de saque: Saldo insuficiente");
		}
	}
	
}
