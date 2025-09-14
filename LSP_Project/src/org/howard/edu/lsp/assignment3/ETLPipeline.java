package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main ETL Pipeline coordinator class that orchestrates the extraction,
 * transformation, and loading processes. Demonstrates object-oriented
 * decomposition by delegating responsibilities to specialized classes.
 */
public class ETLPipeline {
    
    /**
     * Main method that initiates the ETL process.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        ETLPipeline pipeline = new ETLPipeline();
        pipeline.run();
    }
    
    /**
     * Executes the complete ETL process with error handling.
     */
    public void run() {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";
        
        printStartupMessage(inputPath, outputPath);
        
        try {
            executeETLProcess(inputPath, outputPath);
        } catch (IOException e) {
            handleIOException(e);
        }
    }
    
    private void printStartupMessage(String inputPath, String outputPath) {
        System.out.println("Starting ETL Pipeline...");
        System.out.println("Input file: " + inputPath);
        System.out.println("Output file: " + outputPath);
    }
    
    private void executeETLProcess(String inputPath, String outputPath) throws IOException {
        // Extract data using CSVExtractor
        CSVExtractor extractor = new CSVExtractor();
        List<Product> products = extractor.extract(inputPath);
        
        if (products.isEmpty()) {
            handleEmptyInput();
            return;
        }
        
        // Transform data using TransformationPipeline
        List<Product> transformedProducts = transformProducts(products);
        
        // Load data using CSVLoader
        CSVLoader loader = new CSVLoader();
        loader.load(transformedProducts, outputPath);
        
        // Print summary
        printSummary(products.size(), transformedProducts.size(), outputPath);
    }
    
    private List<Product> transformProducts(List<Product> products) {
        TransformationPipeline transformer = new TransformationPipeline();
        List<Product> transformed = new ArrayList<>();
        
        for (Product product : products) {
            Product productCopy = product.copy();
            transformer.applyAll(productCopy);
            transformed.add(productCopy);
        }
        
        return transformed;
    }
    
    private void handleEmptyInput() {
        System.out.println("Warning: Input file exists but contains no data rows (only header)");
        System.out.println("ETL process completed with 0 rows processed.");
    }
    
    private void handleIOException(IOException e) {
        System.err.println("\nERROR: " + e.getMessage());
        System.err.println("\nPlease ensure:");
        System.err.println("1. The 'data' directory exists");
        System.err.println("2. The 'data/products.csv' file exists with proper content");
        System.err.println("3. The file has the correct format: ProductID,Name,Price,Category");
        System.exit(1);
    }
    
    private void printSummary(int rowsRead, int rowsTransformed, String outputPath) {
        System.out.println("\nETL Process Summary:");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Output written to: " + outputPath);
    }
}
