package practice3;

import java.math.BigDecimal;

public class PriceCaculator {

    private Order order;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal grandTotal;

    public PriceCaculator(Order order) {
        this.order = order;
    }

    public BigDecimal compute() {
        subTotal = new BigDecimal(0);

        // Total up line items---Extract Method
        subTotal = computeSum();

        // Subtract discounts---Extract Method
        subTotal = subtractDiscount();

        // calculate tax
        tax = subTotal.multiply(order.getTax());

        // calculate GrandTotal
        grandTotal = subTotal.add(tax);

        return grandTotal;
    }

    private BigDecimal subtractDiscount() {
        for (BigDecimal discount : order.getDiscounts()) {
            subTotal = subTotal.subtract(discount);
        }
        return subTotal;
    }

    private BigDecimal computeSum() {
        for (OrderLineItem lineItem : order.getOrderLineItemList()) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
        return subTotal;
    }
}
