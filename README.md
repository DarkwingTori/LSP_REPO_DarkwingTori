# ETL Pipeline Assignment, Assignment 2

## Design Notes
- The program follows a clear ETL structure with separate methods for extraction, transformation, and loading
- Used a Product class to represent each record for better organization
- Implemented proper error handling for missing files and invalid data
- Used BigDecimal for precise rounding with HALF_UP rounding mode
- The transformation order follows the specified sequence: uppercase → discount → recategorization → price range

## Assumptions
- CSV fields do not contain commas or quotes as specified
- Input file has exactly 4 columns in the specified order
- Numeric fields (ProductID, Price) contain valid numeric values
- Category values are case-insensitive for "Electronics" matching

## How to Run
1. Compile the program: `javac -d . src/org/howard/edu/lsp/assignment2/ETLPipeline.java`
2. Run from project root: `java org.howard.edu.lsp.assignment2.ETLPipeline`
3. Ensure the `data/` directory exists with `products.csv` file

## Testing Strategy
- Tested with normal input containing various product types
- Tested with empty input file (only header)
- Tested with missing input file to verify error handling
- Verified transformation logic with edge cases (exactly $500, boundary values)
- Compared output with provided golden files

## AI Usage Summary
I used ChatGPT to help with the BigDecimal rounding implementation and file path handling.

### AI Transcript Excerpt
**Prompt**: "What's the best way to round a double to 2 decimal places in Java using half-up rounding?"

**Response**: "For precise rounding in Java, use BigDecimal with RoundingMode.HALF_UP. Example: 
BigDecimal bd = new BigDecimal(value); 
bd = bd.setScale(2, RoundingMode.HALF_UP); 
double result = bd.doubleValue();"

**Usage**: I implemented this approach in the `roundPrice()` method exactly as suggested for precise rounding.

## External Sources
- Oracle Java Documentation: Used for File I/O classes and exception handling
- Stack Overflow: Referenced for BufferedReader best practices in try-with-resources
