package org.howard.edu.lsp.assignment3;

/**
 * Transformation that assigns price range categories based on final price.
 */
public class PriceRangeTransform implements Transformation {
    /**
     * Determines and sets the price range category based on product price.
     *
     * @param product the product to transform
     */
    @Override
    public void apply(Product product) {
        double price = product.getPrice();
        if (price <= 10.00) {
            product.setPriceRange("Low");
        } else if (price <= 100.00) {
            product.setPriceRange("Medium");
        } else if (price <= 500.00) {
            product.setPriceRange("High");
        } else {
            product.setPriceRange("Premium");
        }
    }
}