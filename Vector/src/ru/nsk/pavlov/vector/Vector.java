package ru.nsk.pavlov.vector;

import java.util.Arrays;

public class Vector {
    private final double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Dimension of the array must be > 0. Dimension of the array : " + n);
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Dimension of the array must be > 0. Dimension of the array : " + n);
        }

        components = Arrays.copyOf(array, Math.min(n, array.length));
    }

    public double[] getComponents() {
        return components;
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (int i = 0; i < components.length; i++) {
            if (i != components.length - 1) {
                stringBuilder.append(components[i]);
                stringBuilder.append(", ");
            } else {
                stringBuilder.append(components[i]);
            }
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public Vector addingVector(Vector vector) {
        int maxLength = Math.max(components.length, vector.components.length);
        double[] result = new double[maxLength];

        double temp1;
        double temp2;

        for (int i = 0; i < maxLength; i++) {
            temp1 = i < components.length ? components[i] : 0;
            temp2 = i < vector.components.length ? vector.components[i] : 0;

            result[i] = temp1 + temp2;
        }

        return new Vector(result);
    }

    public Vector subtractionVector(Vector vector) {
        int maxLength = Math.max(components.length, vector.components.length);
        double[] result = new double[maxLength];

        double temp1;
        double temp2;

        for (int i = 0; i < maxLength; i++) {
            temp1 = i < components.length ? components[i] : 0;
            temp2 = i < vector.components.length ? vector.components[i] : 0;

            result[i] = temp1 - temp2;
        }

        return new Vector(result);
    }

    public Vector multiplicationByScalar(double scalar) {
        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = components[i] * scalar;
        }

        return new Vector(result);
    }

    public Vector reverseVector() {
        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = components[i] * -1;
        }

        return new Vector(result);
    }

    public double getVectorLength() {
        double result = 0;

        for (double component : components) {
            result += component * component;
        }

        return Math.sqrt(result);
    }

    public double getComponentByIndex(int index) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException("The index goes beyond the array");
        }

        return components[index];
    }

    public void setComponentByIndex(int index, double component) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException("The index goes beyond the array");
        }

        components[index] = component;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        for (double component : components) {
            hash = prime * hash + Double.hashCode(component);
        }

        return hash;
    }

    public static Vector addingTwoVectors(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.components.length, vector2.components.length);
        double[] result = new double[maxLength];

        double temp1;
        double temp2;

        for (int i = 0; i < maxLength; i++) {
            temp1 = i < vector1.components.length ? vector1.components[i] : 0;
            temp2 = i < vector2.components.length ? vector2.components[i] : 0;

            result[i] = temp1 + temp2;
        }

        return new Vector(result);
    }

    public static Vector subtractionTwoVectors(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.components.length, vector2.components.length);
        double[] result = new double[maxLength];

        double temp1;
        double temp2;

        for (int i = 0; i < maxLength; i++) {
            temp1 = i < vector1.components.length ? vector1.components[i] : 0;
            temp2 = i < vector2.components.length ? vector2.components[i] : 0;

            result[i] = temp1 - temp2;
        }

        return new Vector(result);
    }

    public static double dotProduct(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.components.length, vector2.components.length);

        double temp1;
        double temp2;

        double result = 0;

        for (int i = 0; i < maxLength; i++) {
            temp1 = i < vector1.components.length ? vector1.components[i] : 0;
            temp2 = i < vector2.components.length ? vector2.components[i] : 0;

            result += temp1 * temp2;
        }

        return result;
    }
}