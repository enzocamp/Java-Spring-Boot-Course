package entities;

public class ImportedProduct extends Product {

	protected Double customFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}
	
	@Override
	public final String priceTag() {
		return super.getName()
				+	" $ " 
				+	String.format("%.2f", totalPrice()) 
				+	"CustomFee: "
				+ 	String.format("%.2f",  + customFee);
	}
	
	public Double totalPrice() {
		return super.getPrice() + customFee;
	}
}
