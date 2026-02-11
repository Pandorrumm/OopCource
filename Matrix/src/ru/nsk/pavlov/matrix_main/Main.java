package ru.nsk.pavlov.matrix_main;

import ru.nsk.pavlov.matrix.Matrix;
import ru.nsk.pavlov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1, 3, 5});
        Vector vector2 = new Vector(new double[]{2, 0, 1, 0, 0});
        Vector vector3 = new Vector(new double[]{1, 1, 1});
        Vector vector4 = new Vector(new double[]{1, 2, 3, 4, 5});
        Vector vector5 = new Vector(new double[]{2, 2, 2, 2, 2});
        Vector vector6 = new Vector(new double[]{5, 7, 4});

        Vector[] vectors1 = {vector1, vector2, vector3};
        Matrix matrix1 = new Matrix(vectors1);

        Vector[] vectors2 = {vector3, vector4, vector5};
        Matrix matrix2 = new Matrix(vectors2);

        Vector[] vectors3 = {vector1, vector3, vector6};
        Matrix matrix3 = new Matrix(vectors3);

        System.out.println("Add " + matrix2 + " to " + matrix1);
        matrix1.add(matrix2);
        System.out.println("Sum: " + matrix1);

        System.out.println();
        System.out.println("Transpose " + matrix1);
        matrix1.transpose();
        System.out.println("Transpose result: " + matrix1);

        System.out.println();
        System.out.println("Multiply matrix " + matrix3 + " by a scalar " + 2);
        matrix3.multiplyByScalar(2);
        System.out.println("The result of multiplying a matrix by a scalar: " + matrix3);

        System.out.println();
        System.out.println("Determinant for " + matrix3 + ": " + matrix3.calculateDeterminant());

        System.out.println();
        System.out.println("Multiply matrix " + matrix3 + " by a vector " + vector1);
        matrix3.multiplyByVector(vector1);
        System.out.println("The result of multiplying a matrix by a vector: " + matrix3);
    }
}
