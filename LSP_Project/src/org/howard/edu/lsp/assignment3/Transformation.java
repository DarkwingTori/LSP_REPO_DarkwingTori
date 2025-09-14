package org.howard.edu.lsp.assignment3;

/**
 * Interface defining the contract for product transformations.
 * Enables polymorphic behavior for different transformation types.
 */
public interface Transformation {
    /**
     * Applies a transformation to the given product.
     *
     * @param product the product to transform
     */
    void apply(Product product);
}