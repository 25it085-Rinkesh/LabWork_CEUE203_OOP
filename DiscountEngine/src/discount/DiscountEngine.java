package discount;

import java.util.List;

public class DiscountEngine {

    public static void applyDiscount(List<Double> prices,
                                     DiscountRule rule) {

        for (double price : prices) {

            double finalPrice = rule.apply(price);

            System.out.printf(
                    "Original: %.2f  ->  Final: %.2f%n",
                    price,
                    finalPrice
            );
        }
    }
}