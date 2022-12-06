import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean victory = false;
        int[] password = generateCode();

        System.out.println("A 4 digit code has been generated.");
        System.out.println("Select the difficulty:");
        System.out.println("1. Easy (20 attempts)");
        System.out.println("2. Medium (15 attempts)");
        System.out.println("3. Hard (10 attempts)");
        System.out.println("4. Challenge Mode (Random amount of attempts between 5 and 25, attempt count after each guess will not be shown.)");

        int difficulty = scanner.nextInt();
        if (difficulty > 4 || difficulty < 1) {
            do {
                System.out.println("Invalid selection, try again.");
                difficulty = scanner.nextInt();
            } while (difficulty > 4 || difficulty < 1);
        }
        int attempts = selectDifficulty(difficulty);

        do {
            System.out.println("Enter your guess: (4 digits long, numbers 1-6 and no duplicate numbers)");
            int[] userGuess = getInput();

            if(!validInput(userGuess)) {
                System.out.println("Invalid input, -1 attempt penalty.");
                attempts -= 1;
                if (difficulty != 4) {
                    System.out.println(attempts + " attempt(s) remaining.");
                }
                System.out.println();
                continue;
            }

            if (checkInputForDupe(userGuess)) {
                System.out.println("Duplicate numbers in your guess, -2 attempts penalty.");
                attempts -= 2;
                if (difficulty != 4) {
                    System.out.println(attempts + " attempt(s) remaining.");
                }
                System.out.println();
                continue;
            }
            if (checkInputAndPrintHint(userGuess, password)) {
                victory = true;
                break;
            }
            attempts -= 1;
            if (difficulty != 4) {
                System.out.println("You have " + attempts + " attempt(s) remaining.");
            }
            System.out.println();
        } while (attempts > 0);

        if (!victory) {
            System.out.println("You have failed to guess the code, You lose.");
            System.out.println("The correct code was " + password[0] + password[1] + password[2] + password[3]);
        } else {
            System.out.println("You have guessed the code, You win!");
        }
    }

    public static int[] generateCode () {
        Random random = new Random();
        boolean dupe = false;
        int[] code = new int[4];

            for (int i = 0; i < code.length; i++) {
                code[i] = random.nextInt(5) + 1;
            }
            if (checkInputForDupe(code)) {
                do {
                    for (int i = 0; i < code.length; i++) {
                        code[i] = random.nextInt(5) + 1;
                    }
                } while (checkInputForDupe(code));
            }
        return code;
    }

    public static int selectDifficulty (int num) {
        Random random = new Random();
        int attemptCount = 0;

        if (num == 1) {
            attemptCount = 20;
        }
        if (num == 2) {
            attemptCount = 15;
        }
        if (num == 3) {
            attemptCount = 10;
        }
        if (num == 4) {
            attemptCount = random.nextInt(5, 25);
        }
        return attemptCount;
    }

    public static int[] getInput () {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;

        int temp = input;
        do {
            temp = temp / 10;
            count++;
        } while (temp > 0);

        int[] userGuess = new int[count];
        for (int i = (userGuess.length) - 1; i >= 0; i--) {
            userGuess[i] = input % 10;
            input = input / 10;
        }
        return userGuess;
    }

    public static boolean checkInputForDupe (int[] input) {
        boolean dupe = false;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    dupe = true;
                    break;
                }
            }
            if (dupe) {
                break;
            }
        }
        return dupe;
    }

    public static boolean validInput (int[] input) {
        boolean valid = true;

        if (input.length > 4) {
            valid = false;
        } else {
            for (int i = 0; i < input.length; i++) {
                if (input[i] < 1 || input[i] > 6) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
    public static boolean checkInputAndPrintHint (int[] input, int[] code) {
        boolean victory = false;
        int correctGuess = 0;
        int partialGuess = 0;

        for (int i = 0; i < code.length; i++) {
            if (input[i] == code[i]) {
                correctGuess++;
            } else {
                for (int j = 0; j < code.length; j++) {
                    if (input[i] == code[j]) {
                        partialGuess++;
                        break;
                    }
                }
            }
        }

        if (correctGuess == 0 && partialGuess == 0) {
            System.out.println("You have not guessed any number.");
        } else {
            if (correctGuess == 4) {
                victory = true;
            } else {
                System.out.println("You have " + correctGuess + " correct guess(es) and " + partialGuess + " partially correct guess(es).");
            }
        }
        return victory;
    }
}
