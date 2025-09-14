package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Handles loading of transformed product data to CSV files.
 * Encapsulates file writing logic.
 */
public class CSVLoader {
    
    /**
     * Writes products to the specified CSV file.
     *
     * @param products the products to write
     * @param outputPath the path to the output CSV file
     * @throws IOException if file cannot be written
     */
    public void load(List<Product> products, String outputPath) throws IOException {
        ensureOutputDirectoryExists(outputPath);
        
        try (FileWriter writer = new FileWriter(outputPath)) {
            writeHeader(writer);
            writeProducts(writer, products);
        }
    }
    
    private void ensureOutputDirectoryExists(String outputPath) {
        File outputFile = new File(outputPath);
        outputFile.getParentFile().mkdirs();
    }
    
    private void writeHeader(FileWriter writer) throws IOException {
        writer.write("ProductID,Name,Price,Category,PriceRange\n");
    }
    
    private void writeProducts(FileWriter writer, List<Product> products) throws IOException {
        for (Product product : products) {
            writer.write(product.toString() + "\n");
        }
    }
}