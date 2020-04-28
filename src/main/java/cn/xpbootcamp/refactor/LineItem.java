package cn.xpbootcamp.refactor;

public class LineItem {
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
		return totalAmount() * .10;
	}

	double calculateTotalAmountWithTax() {
		return totalAmount() + calculateSalesTax();
	}

	public String state() {
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