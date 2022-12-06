import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        char[] arr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    }

    //O(1)
    public static void printBoard (char[] arr) {
        int count = 1;

        do {
            for (int i = 1; i <= 3; i++) {
                System.out.print(arr[count - 1] + " ");
                count++;
            }
            System.out.println();
        } while (count <= 9);

    }

    //O(1)
    public static boolean isAvailable (char[] arr, int num) {
        boolean check = false;
        if (arr[num] != 'X' || arr[num] != 'O') {
            check = true;
        }
        return check;
    }

    //O(n)
    public static void getPositionFromUser (char[] arr) {
        Scanner scanner = new Scanner(System.in);
        int position;

        System.out.println("Enter the grid position you wish to use (1-9)");
        position = scanner.nextInt();

        if (position < 1 || position > 9) {
            do {
                System.out.println("Invalid placement, try again.");
                position = scanner.nextInt();
            } while (position < 1 || position > 9);
        }

        if (!isAvailable(arr, position)) {
            do {
                System.out.println("This position is taken, try again.");
                position = scanner.nextInt();
            } while (!isAvailable(arr, position));
        }
    }

    //O(n)
    public static char checkWinner (char[] arr) {
        char winner;
        int count = 0;

        winner = 'X';
        for (int i = 0; i < arr.length; i += 3) {
            if (arr[i] == winner) {
                if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) {
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {

        }
        return winner;
    }
}
