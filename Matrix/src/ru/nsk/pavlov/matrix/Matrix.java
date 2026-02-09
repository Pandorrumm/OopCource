package ru.nsk.pavlov.matrix;

//import ru.nsk.pavlov.vector.Vector;

import java.util.Vector;

public class Matrix {
    private Vector[] rows;
    private int rowsNumber;
    private int columnsNumber;

    public Matrix(int rowsNumber, int columnsNumber) {
        if (rowsNumber <= 0 || columnsNumber <= 0) {
            throw new IllegalArgumentException("The number of rows and the number of columns must be greater than 0. " +
                    "Number of rows: " + rowsNumber + ", Number of columns: " + columnsNumber);
        }

        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;

        rows = new Vector[rowsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            rows[i] = new Vector(columnsNumber);
        }
    }
}
