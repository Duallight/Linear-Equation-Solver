package solver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String inFile = "";
        String outFile = "";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-in" : inFile = args[i + 1];
                case "-out" : outFile = args[i + 1];
            }
        }
        File input = new File(inFile);
        FileWriter output = new FileWriter(outFile);
        PrintWriter printer = new PrintWriter(output);
        Scanner readIn = new Scanner(input);
        int variables = readIn.nextInt() + 1;
        int row = readIn.nextInt();
        double[][] matrix = new double[row][variables];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < variables; j++) {
                matrix[i][j] = readIn.nextDouble();
            }
        }
        Matrix mat = new Matrix(matrix);
        mat.eliminate();
        if (mat.checkSolutions()) { //check if there are no solutions
            printer.println("No solutions");
        } else if (mat.checkInfSolutions()) { //check if there are infinite solutions
            printer.println("Infinitely many solutions");
        } else { //If there is one solution, solve it
            System.out.println("solving the system");
            double[] values = mat.getValues();
            for (double val : values) {
                System.out.println(val);
                printer.println(val);
            }
        }
        printer.close();
    }
}
