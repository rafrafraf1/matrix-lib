
public class Matrix_Showcase {
    public static void main(String[] args) {


        // examples of pretty print addition and subtraction
        System.out.println("\n============================= examples of pretty print addition and subtraction");
        I(4).add(I(4).add(I(4)), true);
        Matrix rand1 = rand_matrix(3, 2);
        Matrix rand2 = rand_matrix(3, 2);
        rand1.sub(rand2, true);

        // examples of pretty print with different decimal places output
        /*System.out.println("\n============================= examples of pretty print with different decimal places output");
        System.out.println(rand1.toString(0));
        System.out.println(rand1.toString(1));
        System.out.println(rand1.toString(5));*/

        // examples of pretty print multiplication
        System.out.println("\n============================= examples of pretty print examples of pretty print addition and subtraction");
        Matrix m1 = rand_matrix(3, 4);
        Matrix m2 = rand_matrix(4, 3);
        m1.dot(m2, true);

        I(4).dot(m2, true);

    }

    // returns nxn identity matrix
    public static Square_Matrix I(int n) {
        double[][] id = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                id[i][j] = i==j ? 1:0;
            }
        }
        return new Square_Matrix(id);
    }

    public static Matrix rand_matrix(int rows, int cols) {
        double[][] ra = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ra[i][j] = Math.round(Math.random() * 99_000) / 1000.0;
            }
        }
        return new Matrix(ra);
    }
}