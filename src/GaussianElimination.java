import java.util.Scanner;

public class GaussianElimination {

    public static double[] gaussElimination(double[][] matrix, double[] b) {
        int n = b.length;

        for (int i = 0; i < n; i++) {
            double pivot = matrix[i][i];
            for (int j = i; j < n; j++) {
                matrix[i][j] /= pivot;
            }
            b[i] /= pivot;

            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i];
                for (int j = i; j < n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
                b[k] -= factor * b[i];
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = b[i];
            for (int j = i + 1; j < n; j++) {
                x[i] -= matrix[i][j] * x[j];
            }
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the 5x5 matrix (row by row):");
        double[][] matrix = new double[5][5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter the elements of the vector of free members:");
        double[] b = new double[5];
        System.out.print("Vector: ");
        for (int i = 0; i < 5; i++) {
            b[i] = scanner.nextDouble();
        }

        double[] solution = gaussElimination(matrix, b);

        System.out.println("Solution of the system of equations:");
        for (int i = 0; i < solution.length; i++) {
            System.out.printf("x[%d] = %.6f%n", i, solution[i]);
        }

        scanner.close();
    }
}

