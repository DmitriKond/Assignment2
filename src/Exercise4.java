public class Exercise4 {
    public static void main(String[] args) {

    }

    //O(n)
    public static int ascendingDescendingArray (int[] arr) {
        int result = -1;
        int highestNum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highestNum) {
                highestNum = arr[i];
                result = i;
            }
        }

        for (int i = 0; i < result; i++) {
            if (arr[i] > arr[i + 1]) {
                result = -1;
                break;
            }
        }

        if (result != -1) {
            for (int i = result; i < arr.length; i++) {
                if (arr[i] > arr[i + 1]) {
                    result = -1;
                    break;
                }
            }
        }
        return result;
    }
}
