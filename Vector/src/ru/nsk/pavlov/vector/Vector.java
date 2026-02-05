package ru.nsk.pavlov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("The size of the vector components must be greater 0");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("The size of the vector components must be greater 0");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("The size of the vector components must be greater 0");
        }

        components = Arrays.copyOf(array, Math.min(size, array.length));
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('{');

        for (int i = 0; i < components.length; i++) {
            stringBuilder.append(components[i]);

            if (i < components.length - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    public void add(Vector vector) {
        addOrSubtract(vector, true);
    }

    public void subtract(Vector vector) {
        addOrSubtract(vector, false);
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * scalar;
        }
    }

    public void reverse() {
        for (int i = 0; i < components.length; i++) {
            components[i] = -components[i];
        }
    }

    public double getVectorLength() {
        double sumOfSquares = 0;

        for (double component : components) {
            sumOfSquares += component * component;
        }

        return Math.sqrt(sumOfSquares);
    }

    public double getComponentByIndex(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Valid range: 0 to " + (components.length - 1));
        }

        return components[index];
    }

    public void setComponentByIndex(int index, double component) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Valid range: 0 to " + (components.length - 1));
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
        return Arrays.hashCode(components);
    }

    public static Vector addTwoVectors(Vector vector1, Vector vector2) {
        return vector1.addOrSubtractTwoVectors(vector2, true);
    }

    public static Vector subtractTwoVectors(Vector vector1, Vector vector2) {
        return vector1.addOrSubtractTwoVectors(vector2, false);
    }

    public static double dotProduct(Vector vector1, Vector vector2) {
        int size = Math.min(vector1.components.length, vector2.components.length);

        double result = 0;

        for (int i = 0; i < size; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }

    private Vector addOrSubtractTwoVectors(Vector vector, boolean isAdd) {
        int size = Math.max(components.length, vector.components.length);
        double[] result = new double[size];

        if (size > components.length) {
            components = Arrays.copyOf(components, size);
        }

        double[] otherComponents = size > vector.components.length ? Arrays.copyOf(vector.components, size) : vector.components;

        for (int i = 0; i < size; i++) {
            result[i] = isAdd ? components[i] + otherComponents[i] : components[i] - otherComponents[i];
        }

        return new Vector(result);
    }

    private void addOrSubtract(Vector vector, boolean isAdd) {
        int size = Math.max(components.length, vector.components.length);

        if (size > components.length) {
            components = Arrays.copyOf(components, size);
        }

        double[] otherComponents = size > vector.components.length ? Arrays.copyOf(vector.components, size) : vector.components;

        for (int i = 0; i < size; i++) {
            components[i] = isAdd ? components[i] + otherComponents[i] : components[i] - otherComponents[i];
        }
    }
}