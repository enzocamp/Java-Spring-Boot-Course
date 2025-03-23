package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
	
	public static final DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate manufactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate date) {
		super(name, price);
		this.manufactureDate = date;
	}

	public LocalDate getDate() {
		return manufactureDate;
	}

	public void setDate(LocalDate date) {
		this.manufactureDate = date;
	}
	
	@Override
	public final String priceTag() {
		return super.getName()
				+ " (used) "
				+	" $ " 
				+	String.format("%.2f", super.getPrice()) 
				+	"(Manufacturedate: "
				+	fmt.format(manufactureDate)
				+ 	")";
	
	}
}
