package solver;
import java.io.*;
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
        int rows = readIn.nextInt();
        double[][] matrix = new double[rows][rows + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= rows; j++) {
                matrix[i][j] = readIn.nextDouble();
            }
        }
        Matrix mat = new Matrix(matrix);
        mat.eliminate();
        double[] values = mat.getValues();
        for (double val : values) {
            System.out.println(val);
            printer.println(val);
        }
        printer.close();
    }
}
