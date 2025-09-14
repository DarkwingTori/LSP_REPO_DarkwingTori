package org.howard.edu.lsp.assignment3;

/**
 * Transformation that converts product names to uppercase.
 * Implements the Transformation interface.
 */
public class UppercaseTransform implements Transformation {
    /**
     * Converts the product name to uppercase.
     *
     * @param product the product to transform
     */
    @Override
    public void apply(Product product) {
        product.setName(product.getName().toUpperCase());
    }
}