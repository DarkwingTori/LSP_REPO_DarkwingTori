# Reflection: Assignment 2 vs Assignment 3

## Design Differences

**Assignment 2** used a monolithic class structure with a nested Product class and all functionality contained within a single ETLPipeline class. The transformations were implemented as private methods within the main class.

**Assignment 3** employs object-oriented decomposition with:
- Separate class files for each responsibility
- Interface-based transformation system
- Encapsulated file handling classes
- Polymorphic transformation behavior

## Object-Oriented Principles Applied

### Encapsulation
Each class now encapsulates specific functionality:
- `Product` encapsulates product data and behavior
- `CSVExtractor` encapsulates file reading logic
- `CSVLoader` encapsulates file writing logic
- Each transformation encapsulates a single transformation rule

### Polymorphism
The `Transformation` interface enables polymorphic behavior. Different transformation types (`UppercaseTransform`, `DiscountTransform`, etc.) can be treated uniformly through the common interface while providing different implementations.

### Inheritance
While not using class inheritance heavily, the transformation system uses interface inheritance. All transformation classes implement the `Transformation` interface, demonstrating the "program to interface" principle.

### Single Responsibility Principle
Each class has one clear purpose:
- `Product`: Data representation
- `CSVExtractor`: Data extraction
- `CSVLoader`: Data loading
- Transformation classes: Specific data transformations
- `TransformationPipeline`: Transformation coordination

## Testing Verification

To ensure Assignment 3 produces identical results to Assignment 2:

1. **Same Test Cases**: Used the same input files from Assignment 2
2. **Output Comparison**: Compared `transformed_products.csv` files byte-for-byte
3. **Edge Cases**: Tested with:
   - Normal input with multiple products
   - Empty input file (only header)
   - Missing input file (error handling)
   - Various product categories and price ranges

4. **Transformation Order**: Verified the transformation sequence:
   - Uppercase names first
   - Then discount application
   - Then category upgrade
   - Finally price range assignment

The output files were identical, confirming functional equivalence while achieving better object-oriented design.