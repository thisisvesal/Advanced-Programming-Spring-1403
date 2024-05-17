public class Main {
    public static void main(String[] args) {
        try {
            new Matrix(new double[0][0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            new Matrix(new double[2][4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        double[][] array = new double[2][2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = i * 2 + j;
            }
        }

        Matrix matrix = new Matrix(array);
        Matrix matrix2 = new Matrix(array);

        System.out.println("Sum of matrix and matrix2:");
        System.out.println((matrix.sum(matrix2)).toString());

        System.out.println("Sum of matrix's elements: " + matrix.sumValues());

        System.out.println("Product of matrix and matrix2: "+ matrix.mult(matrix2));

        System.out.println("Transposition of matrix:");
        System.out.println((matrix.transpose()).toString());

        System.out.println("Flattened matrix:");
        for (double d : matrix.flatten()) {
            System.out.print(d + " ");
        }
        System.out.println("");

        System.out.println("Equality check: " + matrix.equals(matrix2));

        System.out.println("Scalar mult of matrix in line 0: ");
        for (double d : (Matrix.scalarMult(matrix, 0, 3))) {
            System.out.print(d + " ");
        }

        System.out.println("Switching the rows 0 and 1 in matrix:");
        System.out.println((Matrix.switchRows(matrix, 0, 1)).toString());

        System.out.println("I:");
        System.out.println(Matrix.eye(matrix).toString());

        System.out.println("Determinant of matrix: " + matrix.determinant());

        System.out.println("Inverse of matrix: ");
        System.out.println(matrix.invert().toString());
    }
}
