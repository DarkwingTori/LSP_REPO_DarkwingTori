package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Transformation that applies a 10% discount to Electronics products.
 * Uses half-up rounding to two decimal places.
 */
public class DiscountTransform implements Transformation {
    /**
     * Applies 10% discount to Electronics products and rounds the price.
     *
     * @param product the product to transform
     */
    @Override
    public void apply(Product product) {
        if ("Electronics".equalsIgnoreCase(product.getCategory())) {
            double discountedPrice = product.getPrice() * 0.9;
            BigDecimal bd = new BigDecimal(discountedPrice);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            product.setPrice(bd.doubleValue());
        }
    }
}