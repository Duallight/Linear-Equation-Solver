package solver;

public class Matrix {
    //class variables
    private double[][] matrix;
    private int matrixLength;

    public Matrix (double[][] matrix) {
        this.matrix = matrix;
    }
    void printMatrix() {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }
    void eliminate(){
            this.matrix = gaussElimination(matrix);
    }
    boolean checkSolutions() {
        return checkNoSolutions(matrix);
    }
    boolean checkInfSolutions() {
        return checkInfiniteSolutions(matrix);
    }
    double[] getValues(){
        int numOfValues = matrix[0].length - 1;
        double[] x = new double[numOfValues];
        for (int i = 0; i < numOfValues; i++) {
            x[i] = matrix[i][numOfValues] / matrix[i][i];
        }
        return x;
    }

    private boolean checkNoSolutions(double[][] matrix) { // return true if no solutions
        matrixLength = matrix.length;
        for (double[] i : matrix) {
            int count = 0;
            for (double val : i) {
                if (val == 0) {
                    count++;
                }
            }
            if (count == i.length) {
                matrixLength--;
            }
            if (i[i.length - 1] != 0 && count == i.length - 1) {
                return true;
            }
        }
        return false;
    }
    private boolean checkInfiniteSolutions(double[][] matrix) { // return true if infinite solutions
        return matrix.length - matrixLength > 1 || matrixLength < matrix[0].length - 1;
    }
    private double[][] gaussElimination(double[][] matrix) {
        int numOfRows = matrix.length;
        int numOfCol = matrix[0].length;
        double mult;
        int pivot = 0;
        for (int i = 0; i < numOfCol - 1; i++) {
            int r = pivot;
            int row = r;

            while (row < numOfRows - 1 && matrix[row][i] == 0) {
                row++;
            }
            if (matrix[row][i] != 0) {
                pivot += 1;

                if (r != row) {
                    swapRow(matrix, r, row);
                }

                mult = matrix[r][i];
                if (mult != 1 && mult != 0) {
                    for (int j = 0; j < numOfCol; j++) {
                        matrix[r][j] /= mult;
                    }
                }

                for (int k = r + 1; k < numOfRows; k++) {
                    mult = matrix[k][i] * -1;
                    if (mult != 1 && mult != 0) {
                        for (int l = 0; l < numOfCol; l++) {
                            matrix[k][l] += matrix[r][l] * mult;
                        }
                    }
                }
            }
        }

        for (int i = numOfRows - 2; i > -1; i--) {
            for (int j = i; j > -1; j--) {
                if (matrix[j][i+1] == 0) {
                    continue;
                }
                mult = matrix[j][i+1] * -1;
                for (int k = 0; k < numOfCol; k++) {
                    matrix[j][k] += matrix[i + 1][k] * mult;
                }
            }
        }
        return matrix;
    }
    private double[][] swapRow(double[][] matrix, int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
        return matrix;
    }



}
