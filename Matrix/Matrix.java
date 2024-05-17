import Matrix_Exceptions.*;

public class Matrix {
    private double[][] array;
    
    public Matrix(double[][] array) throws RuntimeException {
        if (array.length == 0) {
            throw new EmptyMatrixException();
        }
        if (array.length != array[0].length) {
            throw new NotSquaredException();
        }

        this.array = array;
    }
    
    public Matrix(int[][] array) throws RuntimeException {
        if (array.length == 0) {
            throw new EmptyMatrixException();
        }
        if (array.length != array[0].length) {
            throw new NotSquaredException();
        }
        this.array = new double[array.length][array[0].length];

        // Casting every element from int to double
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                this.array[i][j] = (double)array[i][j];
            }
        }
    }

    public Matrix sum(Matrix other) throws InvalidDimensionsException {
        if (this.array.length != other.array.length) {
            throw new InvalidDimensionsException();
        }

        Matrix sum = new Matrix(new double[array.length][array.length]);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum.array[i][j] += this.array[i][j] + other.array[i][j];
            }
        }

        return sum;
    }

    public double sumValues() {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }

    public double mult(Matrix other) throws InvalidDimensionsException {
        if (this.array.length != other.array.length) {
            throw new InvalidDimensionsException();
        }

        double product = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                product += this.array[i][j] * other.array[j][i];
            }
        }

        return product;
    }

    public Matrix transpose() {
        Matrix newMatrix = new Matrix(new double[this.array.length][this.array.length]);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newMatrix.array[j][i] = this.array[i][j];
            }
        }

        return newMatrix;
    }

    public double[] flatten() {
        double[] flatArray = new double[array.length * array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                flatArray[array.length * i + j] = array[i][j];
            }
        }

        return flatArray;
    }

    @Override
    public boolean equals(Object obj) throws InvalidDimensionsException {
        if (!(obj instanceof Matrix)) {
            return false;
        }
        Matrix matrix = (Matrix)obj;
        if (matrix.array.length != this.array.length) {
            throw new InvalidDimensionsException();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (matrix.array[i][j] != this.array[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        String matrixString = "";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                matrixString += array[i][j] + " ";
            }
            matrixString += "\n";
        }

        return matrixString;
    }

    public static double[] scalarMult(Matrix matrix, int lineIndex, int z) throws OutOfRangeException {
        if (lineIndex >= matrix.array.length) {
            throw new OutOfRangeException();
        }
        double[] multipliedLine = new double[matrix.array.length];

        for (int i = 0; i < multipliedLine.length; i++) {
            multipliedLine[i] = matrix.array[lineIndex][i] * z;
        }

        return multipliedLine;
    }

    public static Matrix switchRows(Matrix matrix, int a, int b) {
        Matrix newMatrix = new Matrix(new double[matrix.array.length][matrix.array.length]);
        
        for (int i = 0; i < matrix.array.length; i++) {
            for (int j = 0; j < matrix.array[i].length; j++) {
                newMatrix.array[i][j] = matrix.array[i][j];
            }
        }

        double hold;
        for (int i = 0; i < matrix.array.length; i++) {
            hold = newMatrix.array[a][i];
            newMatrix.array[a][i] = newMatrix.array[b][i];
            newMatrix.array[b][i] = hold;
        }

        return newMatrix;
    }

    public static Matrix eye(Matrix matrix) {
        Matrix eyeMatrix = new Matrix(new double[matrix.array.length][matrix.array.length]);

        for (int i = 0; i < eyeMatrix.array.length; i++) {
            eyeMatrix.array[i][i] = 1;
        }

        return eyeMatrix;
    }

    public double determinant() throws RuntimeException {
        if (array.length != 2) {
            throw new InvalidDimensionsException();
        }

        double det = (array[0][0] * array[1][1]) - (array[0][1] * array[1][0]);
        if (det == 0) {
            throw new DetIsZeroException();
        }

        return det;
    }

    public Matrix invert() throws RuntimeException {
        double det;
        try {
            det = determinant();
        } catch (DetIsZeroException e) {
            throw new DetIsZeroException();
        } catch (InvalidDimensionsException e) {
            throw new InvalidDimensionsException();
        }

        Matrix inverse = new Matrix(new double[2][2]);
        inverse.array[0][0] = this.array[1][1] / det;
        inverse.array[0][1] = -this.array[0][1] / det;
        inverse.array[1][0] = -this.array[1][0] / det;
        inverse.array[1][1] = this.array[0][0] / det;

        return inverse;
    }

    public double[][] getArray() {
        return array;
    }
}