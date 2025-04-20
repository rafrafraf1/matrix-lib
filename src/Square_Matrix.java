public class Square_Matrix extends Matrix {

    protected final int n;

    public Square_Matrix(int n) {
        super(n,n);
        this.n = n;
    }

    public Square_Matrix(double[][] matrix) {
        super(matrix);
        this.n = matrix.length;
    }

    public int getSize() {
        return n;
    }


}
