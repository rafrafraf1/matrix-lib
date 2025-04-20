
public class Matrix_Test {
    public static void main(String[] args) {

        Square_Matrix i4 = identity(4);
        System.out.println(i4);

        Matrix rand1 = rand_matrix(4, 5);
        Matrix rand2 = rand_matrix(4, 5);
        rand1.add(rand2, true);

        Matrix res = i4.add(i4.add(i4), true);

        System.out.println(rand1.toString(0));
        System.out.println(rand1.toString(1));
        System.out.println(rand1.toString(2));
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