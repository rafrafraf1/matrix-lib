/*
    matrix object with operations and pretty prints

    methods to add:
    - to echelon form
    - is invertible
    - get i'th row
    - get j'th column
    - get determinant
    - transpose
*/

public class Matrix {

    protected final int rows;
    protected final int cols;
    protected double[][] data;

    protected int decimal_points = 2; // shows decimal places for matrix in print **No effect on actual data**

    public Matrix(int rows, int cols) {
        if (!isValidMatrix(rows, cols)) {
            throw new IllegalArgumentException("Invalid matrix rows or columns");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // receives 2d double array as matrix
    public Matrix(double[][] matrix) {
        if (!isValidMatrix(matrix)) {
            throw new IllegalArgumentException("Invalid matrix");
        }
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.data = matrix;
    }

    public int getRowNo() {
        return rows;
    }
    public int getColNo() {
        return cols;
    }
    // returns matrix data in 2d boolean array
    public double[][] getData() {
        return this.data;
    }

    // matrix addition
    public Matrix add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("rows and cols do not match");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }
    // print=true ==> pretty prints the addition of the matrix with the solution
    public Matrix add(Matrix other, boolean print) {
        Matrix result = this.add(other);

        if (print) {
            Matrix.prettyPrintOperation(this, "+", other, result);
        }

        return result;
    }

    // matrix subtraction
    public Matrix sub(Matrix other) {
        return sub(other, false);
    }
    public Matrix sub(Matrix other, boolean print) {
        Matrix result = add(getAdditiveInverse(other));

        if (print) {
            Matrix.prettyPrintOperation(this, "-", other, result);
        }

        return result;
    }

    // matrix multiplication
    public Matrix dot(Matrix other, boolean print) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("rows and cols of matrices are invalid for multiplication");
        }
        double[][] result_data = new double[this.rows][other.cols];
        double sum = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result_data[i][j] = sum;
                sum = 0;
            }
        }
        Matrix result = new Matrix(result_data);

        if (print) {
            Matrix.prettyPrintOperation(this, "×", other, result);
        }

        return result;
    }
    public Matrix dot(Matrix other) {
        return dot(other, false);
    }


    // ========================================= helpers

    private Matrix getAdditiveInverse(Matrix matrix) {
        double[][] result = new double[matrix.getRowNo()][matrix.getColNo()];

        for (int i = 0; i < matrix.getRowNo(); i++) {
            for (int j = 0; j < matrix.getColNo(); j++) {
                result[i][j] = -matrix.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // true if valid row/height for matrix
    private boolean isValidMatrix(int rows, int cols) {
        return rows > 0 && cols > 0;
    }
    // true if input is a valid matrix (all matrix values are double type nums)
    private boolean isValidMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return false;
        }
        for (double[] row : matrix) {
            for (Double value : row) {
                if (value == null || Double.isNaN(value) || Double.isInfinite(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    // pretty print helper
    public static void prettyPrintOperation(Matrix left, String op, Matrix right, Matrix result) {
        String[] lLines = left.toString().split("\n");
        String[] rLines = right.toString().split("\n");
        String[] sumLines = result.toString().split("\n");

        int height = Math.max(Math.max(lLines.length, rLines.length), sumLines.length);
        int middle = (height % 2 == 0) ? height / 2 : height / 2;

        lLines = padLines(lLines, height);
        rLines = padLines(rLines, height);
        sumLines = padLines(sumLines, height);

        for (int i = 0; i < height; i++) {
            String opText = (i == middle) ? " " + op + " " : "   ";
            String eqText = (i == middle) ? " = " : "   ";
            System.out.println(lLines[i] + opText + rLines[i] + eqText + sumLines[i]);
        }
    }
    private static String[] padLines(String[] lines, int targetHeight) {
        String[] padded = new String[targetHeight];
        int offset = (targetHeight - lines.length) / 2;
        String empty = " ".repeat(lines[0].length());

        for (int i = 0; i < targetHeight; i++) {
            if (i >= offset && i < offset + lines.length) {
                padded[i] = lines[i - offset];
            } else {
                padded[i] = empty;
            }
        }

        return padded;
    }

    // pretty prints matrix with values shown to "decimals" number of decimal places
    public String toString(int decimals) {
        if (decimals < 0) {
            throw new IllegalArgumentException("Invalid decimals");
        }

        String[][] formatted = new String[rows][cols];
        int cellWidth = 0;
        String formatStr = "%." + decimals + "f";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double val = this.data[i][j];

                // Round to specified decimals, but drop .0 if whole
                String s = String.format(formatStr, val);
                if (s.matches("[-]?\\d+\\.0+")) {
                    s = s.substring(0, s.indexOf('.'));
                }

                formatted[i][j] = s;
                cellWidth = Math.max(cellWidth, s.length());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Borders
                if (j == 0) {
                    if (i == 0) sb.append("┌");
                    else if (i == rows - 1) sb.append("└");
                    else sb.append("│");
                }

                sb.append(" ");
                sb.append(String.format("%" + cellWidth + "s", formatted[i][j]));
                sb.append(" ");

                if (j == cols - 1) {
                    if (i == 0) sb.append("┐");
                    else if (i == rows - 1) sb.append("┘");
                    else sb.append("│");
                }
            }

            if (i < rows - 1) sb.append("\n");
        }

        return sb.toString();
    }
    @Override
    public String toString() {
        return toString(decimal_points); // default decimal places shown
    }
}



