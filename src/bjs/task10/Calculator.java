package bjs.task10;

import java.lang.Math;

/**
 * Created by YM on 09.11.2015.
 */
public class Calculator {
    //Number of the operation which class performs
    private static final int OPERATION_NUM = 3;

    //Operation type constants
    private static final String SUM = "SUM";
    private static final String SQRT = "SQRT";
    private static final String SIN = "SIN";

    //For unary operation only leftOperand will be used
    double leftOperand, rightOperand, resultValue;

    //Contains string representation of the results
    String[][] calculationResults;

    Calculator() {
        calculationResults = new String[OPERATION_NUM][1];
    }

    void printCalculationResults() {
        for (int i = 0; i < OPERATION_NUM; i++) {
            System.out.print(calculationResults[i][0] + ": ");

            for (int j = 1; j < calculationResults[i].length; j++) {
                String resultStr = calculationResults[i][j];
                if (j > 0)
                    resultStr += ", ";

                System.out.print(resultStr);
            }

            System.out.print("\n");
        }
    }

    void appendResult(String resultType) {
        int typeIndex = getNumericResultType(resultType);

        if (typeIndex >= 0) {
            calculationResults[typeIndex][0] = resultType;
            int resultNum = calculationResults[typeIndex].length + 1;

            //This is the code from the java.util.Arrays.copyOf()
            String[] copyArray = new String[resultNum];
            System.arraycopy(calculationResults[typeIndex], 0, copyArray, 0,
                    Math.min(calculationResults[typeIndex].length, resultNum));

            copyArray[resultNum - 1] = Double.toString(resultValue);
            calculationResults[typeIndex] = copyArray;
        }
    }

    int getNumericResultType(String resultType) {
        int result = -1;

        switch (resultType) {
            case SUM:
                result = 0;
                break;
            case SQRT:
                result = 1;
                break;
            case SIN:
                result = 2;
                break;
        }

        return result;
    }

    void setBinary(double leftOperand, double rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    void setUnary(double leftOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = 0;
    }

    double getSum() {
        resultValue = leftOperand + rightOperand;
        appendResult(SUM);

        return resultValue;
    }

    double getSqrt() {
        //If the argument is NaN (not a number), then the result is NaN.
        resultValue = Math.sqrt(leftOperand);
        appendResult(SQRT);

        return resultValue;
    }

    double getSin() {
        resultValue = Math.sin(leftOperand);
        appendResult(SIN);

        return resultValue;
    }

    int getArrayMax(int array[]) {
        int returnValue = array[0];

        for (int element: array) {
            if (element>returnValue)
                returnValue = element;
        }

        return returnValue;
    }

    void printResult() {
        System.out.println("Result value: " + resultValue);
    }
}
