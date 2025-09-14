package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a sequence of transformations to be applied to products.
 * Encapsulates the transformation order and execution.
 */
public class TransformationPipeline {
    private List<Transformation> transformations;
    
    /**
     * Constructs a TransformationPipeline with the default transformation sequence.
     */
    public TransformationPipeline() {
        transformations = new ArrayList<>();
        initializeDefaultTransformations();
    }
    
    private void initializeDefaultTransformations() {
        transformations.add(new UppercaseTransform());
        transformations.add(new DiscountTransform());
        transformations.add(new CategoryTransform());
        transformations.add(new PriceRangeTransform());
    }
    
    /**
     * Applies all transformations in sequence to the given product.
     *
     * @param product the product to transform
     */
    public void applyAll(Product product) {
        for (Transformation transformation : transformations) {
            transformation.apply(product);
        }
    }
    
    /**
     * Adds a transformation to the pipeline.
     *
     * @param transformation the transformation to add
     */
    public void addTransformation(Transformation transformation) {
        transformations.add(transformation);
    }
    
    /**
     * Clears all transformations from the pipeline.
     */
    public void clearTransformations() {
        transformations.clear();
    }
    
    /**
     * @return the number of transformations in the pipeline
     */
    public int getTransformationCount() {
        return transformations.size();
    }
}