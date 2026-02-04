package ru.nsk.pavlov.vector_main;

import ru.nsk.pavlov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1, 3, 5});
        Vector vector2 = new Vector(new double[]{2, 0, 1, 0, 0});
        Vector vector3 = new Vector(new double[]{1, 1, 1});
        Vector vector4 = new Vector(new double[]{1, 2, 3, 4, 5});

        System.out.println("Vector length " + vector4 + " : " + vector4.getVectorLength());
        System.out.println();
        System.out.println("Adding vectors " + vector1 + " and " + vector2 + ": " + vector1.addingVector(vector2));
        System.out.println("Adding vectors " + vector1 + " and " + vector3 + ": " + Vector.addingTwoVectors(vector1, vector3));
        System.out.println();
        System.out.println("Subtraction vectors " + vector1 + " and " + vector3 + ": " + vector1.subtractionVector(vector2));
        System.out.println("Subtraction vectors " + vector2 + " and " + vector3 + ": " + Vector.subtractionTwoVectors(vector2, vector3));
        System.out.println();
        System.out.println("The product of a vector " + vector1 + " by a scalar " + 2 + ": " + vector1.multiplicationByScalar(2));
        System.out.println("Scalar product of vectors " + vector2 + " and " + vector3 + ": " + Vector.dotProduct(vector2, vector3));
        System.out.println();
        System.out.println("Vector " + vector4 + " reversal: " + vector4.reverseVector());
        System.out.println();
        System.out.println("Getting a component vector " + vector1 + " by index " + 2 + ": " + vector1.getComponentByIndex(2));
        System.out.println();
        System.out.println("Assign a component " + 100 + " to vector " + vector3 + " by index " + 0 + ": ");
        vector3.setComponentByIndex(0, 100);
        System.out.println(vector3);
    }
}
