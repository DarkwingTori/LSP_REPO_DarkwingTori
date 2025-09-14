package org.howard.edu.lsp.assignment3;

/**
 * Represents a product with all relevant attributes for ETL processing.
 * Encapsulates product data and provides methods for data manipulation.
 */
public class Product {
    private int productID;
    private String name;
    private double price;
    private String category;
    private String priceRange;
    
    /**
     * Constructs a new Product with specified attributes.
     *
     * @param productID the unique identifier for the product
     * @param name the name of the product
     * @param price the price of the product
     * @param category the category of the product
     */
    public Product(int productID, String name, double price, String category) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    // Getters and setters with Javadocs
    /**
     * @return the product ID
     */
    public int getProductID() { return productID; }
    
    /**
     * @param productID the product ID to set
     */
    public void setProductID(int productID) { this.productID = productID; }
    
    /**
     * @return the product name
     */
    public String getName() { return name; }
    
    /**
     * @param name the product name to set
     */
    public void setName(String name) { this.name = name; }
    
    /**
     * @return the product price
     */
    public double getPrice() { return price; }
    
    /**
     * @param price the product price to set
     */
    public void setPrice(double price) { this.price = price; }
    
    /**
     * @return the product category
     */
    public String getCategory() { return category; }
    
    /**
     * @param category the product category to set
     */
    public void setCategory(String category) { this.category = category; }
    
    /**
     * @return the price range category
     */
    public String getPriceRange() { return priceRange; }
    
    /**
     * @param priceRange the price range category to set
     */
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }
    
    /**
     * Creates a deep copy of this product.
     *
     * @return a new Product instance with the same attribute values
     */
    public Product copy() {
        Product copy = new Product(this.productID, this.name, this.price, this.category);
        copy.setPriceRange(this.priceRange);
        return copy;
    }
    
    /**
     * Returns CSV-formatted string representation of the product.
     *
     * @return CSV string with product attributes
     */
    @Override
    public String toString() {
        return productID + "," + name + "," + String.format("%.2f", price) + 
               "," + category + "," + priceRange;
    }
}