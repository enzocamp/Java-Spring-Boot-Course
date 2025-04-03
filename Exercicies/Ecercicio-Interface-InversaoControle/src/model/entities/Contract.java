package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private Integer number;
	private LocalDate date;
	private Double totaValue;
	private List<Installment> installments = new ArrayList<>();

	public Contract(Integer number, LocalDate date, Double value) {
		super();
		this.number = number;
		this.date = date;
		this.totaValue = value;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValue() {
		return totaValue;
	}

	public void setValue(Double value) {
		this.totaValue = value;
	}

	public List<Installment> getInstallment() {
		return installments;
	}

	
}
