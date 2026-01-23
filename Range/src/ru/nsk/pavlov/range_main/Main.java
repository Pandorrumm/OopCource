package ru.nsk.pavlov.range_main;

import ru.nsk.pavlov.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(0, 10);
        Range range1 = new Range(5, 10);
        Range range2 = new Range(20, 30);
        Range range3 = new Range(0, 5);
        Range range4 = new Range(0, 20);
        Range range5 = new Range(10, 40);

        System.out.println();
        System.out.println("Testing Intersection");
        testIntersection(range, range1);
        testIntersection(range1, range2);
        testIntersection(range2, range3);
        testIntersection(range, range3);

        System.out.println();
        System.out.println("Testing Unification");
        testUnification(range, range1);
        testUnification(range1, range2);
        testUnification(range2, range3);
        testUnification(range, range3);

        System.out.println();
        System.out.println("Testing Difference");
        testDifference(range, range1);
        testDifference(range, range3);
        testDifference(range1, range4);
        testDifference(range5, range2);
    }

    public static void testIntersection(Range range1, Range range2) {
        Range intersection = range1.getIntersection(range2);
        System.out.println("Intersection" + printRange(range1) + " and" + printRange(range2) + " :" + (intersection != null ? printRange(intersection) : " null"));
    }

    public static void testUnification(Range range1, Range range2) {
        Range[] unification = range1.getUnification(range2);

        if (unification.length == 1) {
            System.out.println("Unification" + printRange(range1) + " and" + printRange(range2) + " - " + "One interval:" + printRange(unification[0]));
        } else if (unification.length == 2) {
            System.out.println("Unification" + printRange(range1) + " and" + printRange(range2) + " - " + "Two intervals:" + printRange(unification[0]) + ", " + printRange(unification[1]));
        }
    }

    public static void testDifference(Range range1, Range range2) {
        Range[] difference = range1.getDifference(range2);

        if (difference.length == 0) {
            System.out.println("Difference" + printRange(range1) + " and" + printRange(range2) + " - " + "There are no intervals");
        } else if (difference.length == 1) {
            System.out.println("Difference" + printRange(range1) + " and" + printRange(range2) + " - " + "One interval:" + printRange(difference[0]));
        } else if (difference.length == 2) {
            System.out.println("Difference" + printRange(range1) + " and" + printRange(range2) + " - " + "Two interval:" + printRange(difference[0]) + ", " + printRange(difference[1]));
        }
    }

    public static String printRange(Range range) {
        return " (" + range.getFrom() + ", " + range.getTo() + ")";
    }
}
