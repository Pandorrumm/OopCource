package ru.nsk.pavlov.matrix;

import ru.nsk.pavlov.vector.Vector;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("The input data must be greater than 0. Now it is equal to " + rowsCount + ", " + columnsCount);
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < matrix.rows.length; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("The length of the array must be greater than 0. Now it is equal to " + array.length);
        }

        int size = 0;

        for (double[] row : array) {
            size = Math.max(size, row.length);
        }

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(size, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("The length of the array vectors must be greater than 0. Now it is equal to " + vectors.length);
        }

        int size = 0;

        for (Vector vector : vectors) {
            size = Math.max(size, vector.getSize());
        }

        rows = new Vector[vectors.length];

        for (int i = 0; i < vectors.length; i++) {
            rows[i] = new Vector(size, vectors[i].getComponents());
        }
    }

    public int[] getSize() {
        int rowCount = rows.length;
        int columnCount = rows[0].getSize();

        return new int[]{rowCount, columnCount};
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IllegalArgumentException("Index " + index + " is out of bounds. Valid range: from 0 to " + (rows.length - 1));
        }

        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector row) {
        if (index < 0 || index >= rows.length) {
            throw new IllegalArgumentException("Index " + index + " is out of bounds. Valid range: from 0 to " + (rows.length - 1));
        }

        rows[index] = new Vector(row);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= rows[0].getSize()) {
            throw new IllegalArgumentException("Index " + index + " is out of bounds. Valid range: from 0 to " + (rows[0].getSize() - 1));
        }

        double[] column = new double[rows.length];

        for (int i = 0; i < rows.length; i++) {
            column[i] = rows[i].getComponents()[index];
        }

        return new Vector(column);
    }

    public void transpose() {
        int rowCount = rows.length;
        int columnCount = rows[0].getSize();

        Vector[] transposedVectors = new Vector[columnCount];

        for (int i = 0; i < columnCount; i++) {
            double[] columns = new double[rowCount];

            for (int j = 0; j < rowCount; j++) {
                columns[j] = rows[j].getComponents()[i];
            }

            transposedVectors[i] = new Vector(columns);
        }

        rows = transposedVectors;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < rows.length; i++) {
            double[] components = rows[i].getComponents();

            for (int j = 0; j < components.length; j++) {
                components[j] *= scalar;
            }

            rows[i] = new Vector(components);
        }
    }

    public double calculateDeterminant() {
        if (rows.length != rows[0].getSize()) {
            throw new IllegalStateException("The matrix must be square");
        }

        return getDeterminant(this);
    }

    private double getDeterminant(Matrix matrix) {
        if (matrix.rows.length == 1) {
            return getRow(0).getComponentByIndex(0);
        }

        if (matrix.rows.length == 2) {
            return matrix.getRow(0).getComponentByIndex(0) * matrix.getRow(1).getComponentByIndex(1) -
                    matrix.getRow(0).getComponentByIndex(1) * matrix.getRow(1).getComponentByIndex(0);
        }

        double determinant = 0;

        for (int i = 0; i < matrix.rows.length; i++) {
            determinant += Math.pow(-1, i) * matrix.getRow(0).getComponentByIndex(i) * getDeterminant(getMinor(matrix, 0, i));
        }

        return determinant;
    }

    private Matrix getMinor(Matrix matrix, int row, int column) {
        Vector[] minors = new Vector[matrix.rows.length - 1];

        int minorsIndex = 0;

        for (int i = 0; i < matrix.rows.length; i++) {
            if (i == row) {
                continue;
            }

            double[] currentComponents = matrix.getRow(i).getComponents();
            double[] newRowComponents = new double[matrix.rows.length - 1];

            int newColumnIndex = 0;

            for (int j = 0; j < matrix.rows.length; j++) {
                if (j == column) {
                    continue;
                }

                newRowComponents[newColumnIndex++] = currentComponents[j];
            }

            minors[minorsIndex++] = new Vector(newRowComponents);
        }

        return new Matrix(minors);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('{');

        for (int i = 0; i < rows.length; i++) {
            stringBuilder.append(Arrays.toString(rows[i].getComponents()));

            if (i != rows.length - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    public void multiplyByVector(Vector vector) {
        if (vector.getSize() != rows[0].getSize()) {
            throw new IllegalArgumentException("The size of the vector does not match the number of columns. Vector size: " + vector.getSize() + " rows " + rows[0].getSize());
        }

        for (int i = 0; i < rows.length; i++) {
            double sum = 0;

            for (int j = 0; j < rows[i].getComponents().length; j++) {
                sum += rows[i].getComponentByIndex(j) * vector.getComponentByIndex(j);
            }

            rows[i] = new Vector(new double[]{sum});
        }
    }

    public void add(Matrix matrix) {

    }

    public void subtract(Matrix matrix) {

    }
}
