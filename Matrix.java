package solver;

public class Matrix {
    private double[][] matrix;
    public Matrix (double[][] matrix) {
        this.matrix = matrix;
    }
    public void printMatrix() {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }
    void eliminate(){
        gaussElimination(matrix);
    }


    private void gaussElimination(double[][] matrix) {
        int size = matrix.length;
        int c;
        for (int i = 0; i < size; i++) {
            if (matrix[i][i] == 0) {
                c = 1;

                while ((i + c) < size && matrix[i + c][i] == 0) {
                    c++;
                }
                if ((i + c) == size) {
                    break;
                }

                for (int k = 0; k <= size; k++) {
                    double temp = matrix[i][k];
                    matrix[i][k] = matrix[i + c][k];
                    matrix[i + c][k] = temp;
                }
            }
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    double p = matrix[j][i] / matrix[i][i];
                    for (int k = 0; k <= size; k++) {
                        matrix[j][k] = matrix[j][k] - matrix[i][k] * p;
                    }
                }
            }
        }
    }

    double[] getValues(){
        double[] x = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            x[i] = matrix[i][matrix.length] / matrix[i][i];
        }
        return x;
    }

}
