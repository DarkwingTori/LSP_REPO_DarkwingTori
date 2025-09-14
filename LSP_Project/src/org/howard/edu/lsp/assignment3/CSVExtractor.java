package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles extraction of product data from CSV files.
 * Encapsulates file reading and parsing logic.
 */
public class CSVExtractor {
    private int invalidRows;
    
    /**
     * Constructs a new CSVExtractor.
     */
    public CSVExtractor() {
        this.invalidRows = 0;
    }
    
    /**
     * Extracts products from the specified CSV file.
     *
     * @param filePath the path to the CSV file
     * @return list of extracted products
     * @throws IOException if file cannot be read or is invalid
     */
    public List<Product> extract(String filePath) throws IOException {
        File file = new File(filePath);
        
        validateFile(file, filePath);
        
        return readFromFile(file);
    }
    
    private void validateFile(File file, String filePath) throws IOException {
        if (!file.exists()) {
            throw new IOException("Input file '" + filePath + "' not found.");
        }
        
        if (file.length() == 0) {
            throw new IOException("Input file '" + filePath + "' is empty.");
        }
    }
    
    private List<Product> readFromFile(File file) throws IOException {
        List<Product> products = new ArrayList<>();
        invalidRows = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            processHeader(reader.readLine());
            processDataRows(reader, products);
        }
        
        if (invalidRows > 0) {
            System.out.println("Skipped " + invalidRows + " invalid rows during extraction.");
        }
        
        return products;
    }
    
    private void processHeader(String header) throws IOException {
        if (header == null) {
            throw new IOException("Input file is empty.");
        }
    }
    
    private void processDataRows(BufferedReader reader, List<Product> products) throws IOException {
        String line;
        int lineNumber = 1; // Header is line 1
        
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (line.trim().isEmpty()) {
                continue;
            }
            
            processDataLine(line, lineNumber, products);
        }
    }
    
    private void processDataLine(String line, int lineNumber, List<Product> products) {
        String[] fields = line.split(",");
        if (fields.length < 4) {
            invalidRows++;
            return;
        }
        
        try {
            Product product = createProductFromFields(fields);
            products.add(product);
        } catch (NumberFormatException e) {
            invalidRows++;
        }
    }
    
    private Product createProductFromFields(String[] fields) throws NumberFormatException {
        int productID = Integer.parseInt(fields[0].trim());
        String name = fields[1].trim();
        double price = Double.parseDouble(fields[2].trim());
        String category = fields[3].trim();
        
        return new Product(productID, name, price, category);
    }
    
    /**
     * @return the number of invalid rows encountered during last extraction
     */
    public int getInvalidRowsCount() {
        return invalidRows;
    }
}