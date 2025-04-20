# MatrixLib

**MatrixLib** is a self-contained Java library for creating, manipulating, and printing matrices with clean formatting. It supports arithmetic operations, formatted output, and symbolic pretty-printing of operations — making it useful both for educational purposes and as a custom math utility.

---

## ✨ Features

### 🔢 Matrix Creation
- Construct matrices from dimensions or 2D arrays (`double[][]`)
- Create square matrices via `Square_Matrix` subclass
- Generate identity matrices:
  ```java
  Square_Matrix I = Matrix_Showcase.I(n);
  ```

- Generate random matrices:
  ```java
  Matrix A = Matrix_Showcase.rand_matrix(rows, cols);
  ```

---

### ➕ Arithmetic Operations
- **Addition** with optional pretty print
  ```java
  Matrix result = A.add(B);
  A.add(B, true);  // prints A + B = result
  ```

- **Subtraction** (implemented via additive inverse)
  ```java
  A.sub(B);
  A.sub(B, true);  // prints A - B = result
  ```

- **Matrix Multiplication**
  ```java
  A.dot(B);
  A.dot(B, true);  // prints A × B = result
  ```

> All operations include dimension validation with clear error messages.

---

### 🧾 Pretty Printing
- Matrices are boxed with Unicode borders (e.g., `┌`, `┐`, `└`, `┘`)
- Operators (`+`, `-`, `×`, `=`) are center-aligned when printing compound expressions
- Output aligned across rows and columns
- Decimal control via:
  ```java
  matrix.toString();         // uses default (2) decimal places
  matrix.toString(0);        // no decimals
  matrix.toString(5);        // up to 5 decimal places
  ```

---

### 🧠 Utility Methods
- `getRowNo()` and `getColNo()` return matrix dimensions
- `getData()` gives raw `double[][]` values
- Internally used validation for matrix correctness
- Dynamic decimal formatting (e.g., `1.000` prints as `1`)

---

### 🧱 Object-Oriented Structure
- `Matrix` class handles all core logic
- `Square_Matrix` subclass adds:
  - `getSize()` accessor
  - Identity constructor
  - Future support for square-specific operations (e.g., inverse, powers)

---

## 📦 Example Output

```java
Matrix A = new Square_Matrix(new double[][] {
    {1, 2},
    {3, 4}
});

Matrix B = new Square_Matrix(new double[][] {
    {5, 6},
    {7, 8}
});

A.add(B, true);
```

Console output:
```
┌ 1  2┐   ┌ 5  6┐   ┌ 6   8┐
│ 3  4│ + │ 7  8│ = │10  12│
└     ┘   └     ┘   └      ┘
```

---

## 🚧 Planned Features
The code includes placeholders or comments for the following features (coming soon):

- Row/column extraction (`getRow(i)`, `getCol(j)`)
- Transpose
- Determinant calculation
- Reduced Echelon Form
- Inverse computation
- `.isInvertible()` boolean check
- Scalar multiplication

---

## 🛠 Why build this?
MatrixLib is built from scratch as a hands-on way to:
- Learn linear algebra more deeply by implementing core operations
- Practice Java design with real-world OOP structure
- Serve as a reusable mini-library for future ML, graphics, or algorithm projects

---

## 🧪 How to Run

Clone the repo and run `Matrix_Showcase.java` to see output examples for:
- Pretty-print addition, subtraction, multiplication
- Random matrix generation
- Identity matrix chaining

---

## 📄 License
MIT
