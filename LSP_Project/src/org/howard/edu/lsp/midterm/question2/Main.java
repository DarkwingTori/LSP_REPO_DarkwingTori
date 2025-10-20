package org.howard.edu.lsp.midterm.question2;

/**
 * Demonstrates the AreaCalculator class with overloaded methods.
 */
public class Main {
    public static void main(String[] args) {
        // Test all overloaded area methods
        System.out.println("Circle radius 3.0 → area = " + AreaCalculator.area(3.0));
        System.out.println("Rectangle 5.0 x 2.0 → area = " + AreaCalculator.area(5.0, 2.0));
        System.out.println("Triangle base 10, height 6 → area = " + AreaCalculator.area(10, 6));
        System.out.println("Square side 4 → area = " + AreaCalculator.area(4));
        
        // Demonstrate exception handling
        try {
            AreaCalculator.area(-5.0); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /*
     * Overloading is the better design choice here because all methods perform
     * the same fundamental operation (calculating area) but for different shapes.
     * This provides a consistent, intuitive API where users don't need to remember
     * different method names for the same conceptual operation.
     */
}