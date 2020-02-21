package cc.xpbootcamp.refactor;

public class LineItem {
	private static final double TAX = .10;
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	double totalAmount() {
        return price * quantity;
    }

	double calculateSalesTax() {
		return totalAmount() * TAX;
	}

	double calculateTotalAmountWithTax() {
		return totalAmount() + calculateSalesTax();
	}

	String state() {
		StringBuilder result = new StringBuilder();
		result.append(description);
		result.append('\t');
		result.append(price);
		result.append('\t');
		result.append(quantity);
		result.append('\t');
		result.append(totalAmount());
		result.append('\n');
		return result.toString();
	}
}