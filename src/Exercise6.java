import java.util.Arrays;
import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a quadratic equation in the format of ax^2+bx+c=0");
        String equation = scanner.nextLine();
        if (!checkEquationFormat(equation)) {
            System.out.println("The input does not match the format.");
        } else {
            printQuadEquationResult(extractAValue(equation), extractBValue(equation), extractCValue(equation));
        }

    }

    //O(1)
    public static boolean checkEquationFormat (String equation) {
        boolean check = false;

        if (equation.endsWith("=0")) {
            String temp = equation.replace('-', '+');
            if (temp.charAt(0) != '+'){
                temp = "+" + temp;
            }
            temp = temp.replace('+', ',');
            String[] tempArr = temp.split(",");

            if (tempArr.length == 4) {
                if (tempArr[1].contains("x^2")) {
                    if (tempArr[2].contains("x") && !tempArr[2].contains("^2")) {
                        if (!tempArr[3].contains("x")) {
                            check = true;
                        }
                    }
                }
            }
        }
        return check;
    }

    //O(1)
    public static int extractAValue (String equation) {
        String temp = equation.substring(0, equation.indexOf('^'));
        int aValue;

        if (temp.contains("-x")) {
            aValue = -1;
        } else {
            if (temp.charAt(0) == 'x') {
                aValue = 1;
            } else {
                temp = temp.substring(0, temp.indexOf('x'));
                aValue = Integer.parseInt(temp);
            }
        }
        return aValue;
    }

    //O(1)
    public static int extractBValue (String equation) {
        String[] tempArr = equation.split("x", 2);
        int bValue;

        if (tempArr[1].contains("-x")) {
            bValue = -1;
        } else {
            if (tempArr[1].contains("+x")) {
                bValue = 1;
            } else {
                tempArr[1] = tempArr[1].substring(tempArr[1].indexOf('^') + 2, tempArr[1].indexOf('x'));
                String temp = tempArr[1];
                bValue = Integer.parseInt(temp);
            }
        }
        return bValue;
    }

    //O(1)
    public static int extractCValue (String equation) {
        String[] tempArr = equation.split("x", 2);
        int cValue;

        String temp = tempArr[1].substring(tempArr[1].indexOf('x') + 1, tempArr[1].indexOf('='));
        cValue = Integer.parseInt(temp);
        return cValue;

    }

    //O(1)
    public static void printQuadEquationResult (int a, int b, int c) {
        int equationCalc;
        int result1;
        int result2;

        equationCalc = (int) Math.sqrt(((b*b) - (4 * a * c)));
        result1 = (-(b) + equationCalc) / 2;
        result2 = (-(b) - equationCalc) / 2;

        if (result1 == result2) {
            System.out.println("The result of the quadratic equation is " + result1);
        } else {
            System.out.println("The results of the quadratic equation are " + result1 + " and " + result2);
        }
    }
}
