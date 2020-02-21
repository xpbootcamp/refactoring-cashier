package cc.xpbootcamp.refactor;

import java.util.List;

public class Order {

    private List<LineItem> lineItems;
    private Customer customer;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        customer = new Customer(customerName, customerAddress);
        this.lineItems = lineItems;
    }

    public double calculateTotalSalesTax() {
        return lineItems.stream().mapToDouble(LineItem::calculateSalesTax).sum();
    }

    public double calculateTotalAmountWithTax() {
        return lineItems.stream().mapToDouble(LineItem::calculateTotalAmountWithTax).sum();
    }

    private String stateTotalAmountWithTax() {
        StringBuilder result = new StringBuilder();
        result.append("Total Amount").append('\t').append(calculateTotalAmountWithTax());
        return result.toString();
    }

    private String stateLineItems() {
        StringBuilder result = new StringBuilder();
        for (LineItem lineItem : lineItems) {
            result.append(lineItem.state());
        }
        return result.toString();
    }

    private String stateCustomer() {
        StringBuilder result = new StringBuilder();
        result.append(customer.getName());
        result.append(customer.getAddress());
        return result.toString();
    }

    private String stateStateTax() {
        StringBuilder result = new StringBuilder();
        result.append("Sales Tax").append('\t').append(calculateTotalSalesTax());
        return result.toString();
    }

    public String generateReceipt() {
        StringBuilder result = new StringBuilder();
        result.append(stateCustomer());
        result.append(stateLineItems());
        result.append(stateStateTax());
        result.append(stateTotalAmountWithTax());
        return result.toString();
    }
}
