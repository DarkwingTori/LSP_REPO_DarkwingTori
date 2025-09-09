package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class to create the products.csv data file
 * Run this first to create the input data, then run ETLPipeline
 */
public class DataFileCreator {
    
    /**
     * Main method to create the data file
     */
    public static void main(String[] args) {
        DataFileCreator creator = new DataFileCreator();
        creator.createDataFile();
    }
    
    /**
     * Creates the products.csv file with the specified data
     */
    public void createDataFile() {
        String data = "ProductID,Name,Price,Category\n" +
                     "1,Book,12.99,Education\n" +
                     "2,Laptop,999.99,Electronics\n" +
                     "3,Notebook,2.49,Stationery\n" +
                     "4,Headphones,199.99,Electronics\n" +
                     "5,Pencil,0.99,Stationery\n" +
                     "6,Smartphone,699.49,Electronics\n";
        
        try {
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
                System.out.println("Created data directory: " + dataDir.getAbsolutePath());
            }
            
            File dataFile = new File("data/products.csv");
            try (FileWriter writer = new FileWriter(dataFile)) {
                writer.write(data);
            }
            System.out.println("Successfully created data file: " + dataFile.getAbsolutePath());
            System.out.println("\nFile content:");
            System.out.println(data);
            System.out.println("Now run ETLPipeline.java to process the data.");
            
        } catch (IOException e) {
            System.err.println("Failed to create data file: " + e.getMessage());
            System.exit(1);
        }
    }
}