package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;
	

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		double sum = 0.0;
		if(super.getAnualIncome() <= 20000.00) {
			sum += super.getAnualIncome() * 0.15 - (healthExpenditures * 0.5);
		}
		else {
			sum += super.getAnualIncome() * 0.25 - (healthExpenditures * 0.5);
		}

		return sum;
	}
	
	
	
}
