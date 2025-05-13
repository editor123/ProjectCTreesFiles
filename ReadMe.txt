# BinarySearchTreeWithDups Implementation

## Overview

This project implements a `BinarySearchTreeWithDups` class in Java, extending the standard `BinarySearchTree` to handle duplicate entries. The implementation includes methods for adding elements, counting occurrences, and efficiently counting elements greater than a specified value. The code is designed to be efficient, leveraging the sorted nature of the binary search tree.

## Class Details

### `BinarySearchTreeWithDups<T extends Comparable<? super T>>`

This class extends `BinarySearchTree<T>` and provides the following key functionalities:

* **`add(T newEntry)`:** Overrides the `add` method to insert elements, handling duplicates by placing them in the left subtree.
* **`addEntryHelperNonRecursive(T newEntry)` (private):** A non-recursive helper method for adding entries, ensuring duplicate handling.
* **`countIterative(T target)`:** Counts the number of times a specific element appears in the tree (non-recursive).
* **`countGreaterRecursive(T target)`:** Counts the number of elements in the tree greater than the target value (recursive).
* **`countGreaterIterative(T target)`:** Counts the number of elements in the tree greater than the target value (non-recursive, using a stack).
* **`countUniqueValues()`:** Counts the number of unique values in the tree (O(n) time complexity).

## Files Included

* **`BinaryNode.java`:** Defines the `BinaryNode` class for tree nodes.
* **`BinaryTree.java`:** Provides the basic binary tree implementation.
* **`BinarySearchTree.java`:** Implements the standard binary search tree.
* **`BinarySearchTreeWithDups.java`:** The core class with duplicate handling and counting methods.
* **`PoliceReport.java`:** Defines the `PoliceReport` class used in the driver program.
* **`ProjectCPartADriver.java`:** Driver program for testing the `BinarySearchTreeWithDups` class.
* **`ProjectCPartBDriver.java`:** Driver program for processing police report data and comparing tree performance.
* **`README.md`:** This file, providing project documentation.
* **`image_c5a152.jpg`:** An image (please describe its purpose if relevant).

## Usage

1. **Compilation:**

   * Compile the Java files using a Java Development Kit (JDK). For example:

     ```bash
     javac *.java
     ```

2. **Running the Driver Programs:**

   * To test the `BinarySearchTreeWithDups` class:

     ```bash
     java ProjectCPartADriver
     ```

   * To process the police report data:

     ```bash
     java ProjectCPartBDriver
     ```

   * **Note:** Ensure the police report data file is in the correct location for `ProjectCPartBDriver` to run successfully.

## Key Implementation Details

* **Duplicate Handling:** The `addEntryHelperNonRecursive` method ensures that duplicate entries are inserted in the left subtree, maintaining the specified behavior.
* **Efficiency:** The `countGreaterIterative` and `countUniqueValues` methods are implemented with efficiency in mind, using a stack for iterative traversal and a `HashSet` for unique value tracking, respectively.
* **Recursion vs. Iteration:** The project demonstrates both recursive (`countGreaterRecursive`) and iterative (`countIterative`, `countGreaterIterative`) solutions to tree traversal and processing.

## Git Instructions for Collaboration

1. **Clone the Repository:**

   ```bash
   git clone <repository_url>
   ```

2. **Pull Latest Changes:**

   ```bash
   git pull origin main
   ```

3. **Make Changes and Commit:**

   ```bash
   git add <modified_files>
   git commit -m "Describe your changes"
   ```

4. **Push Changes:**

   ```bash
   git push origin main
   ```

## Author

* Your Name
* Your Email/Contact Information

## License

* (Optional: Specify any license information)
