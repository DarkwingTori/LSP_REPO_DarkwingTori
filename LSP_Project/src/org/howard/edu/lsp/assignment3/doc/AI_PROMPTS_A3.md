# AI Usage Transcript for Assignment 3

## Prompt 1: Giving the AI Context
**Prompt**: "Today we’re going to work on a Java programming assignment in the Eclipse IDE. Called Assignment 3: Object-Oriented Redesign of Your ETL Pipeline, which will build off the previous assignment, Assignment 2, that I’m attaching to the prompt."

**AI Response Excerpt**: "Based on the requirements, the current ETL pipeline should have: 
Extract: Reads CSV from data/products.csv
Transform: Applies multiple transformations (uppercase, discount, recategorization, price range)
Load: Writes to data/transformed_products.csv
Error handling: Missing files and empty input
Relative paths: Uses project-relative paths "

## Prompt 2: Object-Oriented Design Suggestions
**Prompt**: "How can I refactor a Java ETL pipeline with CSV processing to be more object-oriented? The current implementation has a main class with nested Product class and private methods for extraction, transformation, and loading."

**AI Response Excerpt**: "Consider these object-oriented improvements: 1) Separate Product into its own class with proper encapsulation (private fields with getters/setters), 2) Create interface for transformations with different implementation classes, 3) Separate CSV reading/writing into dedicated classes, 4) Use composition over inheritance for the transformation pipeline..."

**Usage**: Used this advice to create the Transformation interface and separate class structure, but adapted the implementation to match our specific transformation requirements.

## Prompt 3: Transformation Interface Design
**Prompt**: "What's the best way to design a transformation interface for an ETL system where transformations need to be applied in specific order?"

**AI Response Excerpt**: "Create a Transformation interface with an apply() method. Implement concrete classes for each transformation type. Use a TransformationPipeline class that maintains an ordered list of transformations and applies them sequentially..."

**Usage**: Followed this pattern exactly with the Transformation interface and TransformationPipeline class that maintains transformation order.

## Prompt 4: File Handling Encapsulation
**Prompt**: "How should I structure file reading and writing classes in Java for better separation of concerns?"

**AI Response Excerpt**: "Create separate Reader and Writer classes that encapsulate file I/O logic. The Reader should handle validation, parsing, and error handling for input files. The Writer should handle output formatting and directory creation..."

**Usage**: Created CSVExtractor and CSVLoader classes that encapsulate all file I/O concerns separately from the main business logic.

## Prompt 5: Deep Copy Implementation
**Prompt**: "What's the best practice for creating deep copies of objects in Java when I need to preserve original data during transformations?"

**AI Response Excerpt**: "Implement a copy() method in your data class that creates a new instance with the same field values. For complex objects, you may need to copy nested objects recursively..."

**Usage**: Added a copy() method to the Product class to ensure original data isn't modified during transformations.