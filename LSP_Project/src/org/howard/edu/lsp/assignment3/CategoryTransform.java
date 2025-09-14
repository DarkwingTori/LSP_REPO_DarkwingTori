package org.howard.edu.lsp.assignment3;

/**
 * Transformation that upgrades Electronics category to Premium Electronics
 * for products over $500 after discount.
 */
public class CategoryTransform implements Transformation {
    /**
     * Upgrades Electronics to Premium Electronics if price exceeds $500.
     *
     * @param product the product to transform
     */
    @Override
    public void apply(Product product) {
        if ("Electronics".equalsIgnoreCase(product.getCategory()) && product.getPrice() > 500.00) {
            product.setCategory("Premium Electronics");
        }
    }
}