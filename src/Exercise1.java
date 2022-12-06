import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
    printGreaterThanAverage();
    }

    //O(1)
    public static void printGreaterThanAverage () {
        Scanner scanner = new Scanner(System.in);
        int average = 0;
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            average += arr[i];
        }
        average = average / 10;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
