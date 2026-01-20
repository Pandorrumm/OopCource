package ru.nsk.pavlov.range_main;

import ru.nsk.pavlov.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the beginning number of the range:");
        double from = scanner.nextDouble();

        System.out.println("Enter the ending number of the range:");
        double to = scanner.nextDouble();

        System.out.println("Enter the number:");
        double number = scanner.nextDouble();

        Range range = new Range(from, to);

        System.out.printf("Range length: %.3f%n", range.getLength());

        printIsInsideNumberInfo(range, number);

        System.out.println("Enter the new beginning number of the range:");
        double newFrom = scanner.nextDouble();

        System.out.println("Enter the new ending number of the range:");
        double newTo = scanner.nextDouble();

        range.setFrom(newFrom);
        range.setTo(newTo);

        System.out.println("The range has been redefined!");
        System.out.printf("New range length: %.3f%n", range.getLength());

        printIsInsideNumberInfo(range, number);
    }

    public static void printIsInsideNumberInfo(Range range, double number) {
        if (range.isInside(number)) {
            System.out.println("Your number is in the range from " + range.getFrom() + " to " + range.getTo());
        } else {
            System.out.println("Your number is out of range from " + range.getFrom() + " to " + range.getTo());
        }
    }
}
