package bjs.task10;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.setBinary(125.4, 12);
        calc.getSum();
        calc.printResult();

        calc.setUnary(16);
        calc.getSqrt();
        calc.printResult();

        calc.setUnary(Math.PI/2);
        calc.getSin();
        calc.printResult();

        calc.setBinary(145.5, 9);
        calc.getSum();
        calc.printResult();

        calc.setUnary(144);
        calc.getSqrt();
        calc.printResult();

        calc.setUnary(Math.PI/2);
        calc.getSin();
        calc.printResult();

        System.out.println("\nPrint result array:");
        calc.printCalculationResults();

        int array[] = {6, 8, 9, 7, 20, 55, 48, 66, 74};

        if (array != null && array.length > 0) {
            System.out.println("\nMax array value: " + calc.getArrayMax(array));
        }

        /*Output is:

        Result value: 137.4
        Result value: 4.0
        Result value: 1.0
        Result value: 154.5
        Result value: 12.0
        Result value: 1.0

        Print result array:
        SUM: 137.4, 154.5,
        SQRT: 4.0, 12.0,
        SIN: 1.0, 1.0,

        Max array value: 74
        */
    }
}
