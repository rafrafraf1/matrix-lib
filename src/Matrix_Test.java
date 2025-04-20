
public class Matrix_Test {
    public static void main(String[] args) {

        // examples of pretty print on identity matrices
        Square_Matrix i4 = identity(4);
        i4.add(i4.add(i4), true);


        // examples of pretty print addition and subtraction
        Matrix rand1 = rand_matrix(3, 2);
        Matrix rand2 = rand_matrix(3, 2);
        rand1.add(rand2, true);
        rand1.sub(rand2, true);


        // examples of pretty print with different decimal places output
        System.out.println(rand1.toString(0));
        System.out.println(rand1.toString(1));
        System.out.println(rand1.toString(5));



    }

    public static Square_Matrix identity(int n) {
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