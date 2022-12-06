public class Exercise3 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,2,3};
        int[] test = removeDuplicates(arr);
    }

    //O(n^2)
    public static int[] removeDuplicates (int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
        }

        int[] newArray = new int[arr.length - count];
        for (int i = 0, j = 0; i < newArray.length; i++) {
            int num = arr[j];
            if (arr[i] != num) {
                newArray[j] = arr[i];
                j++;
            }

        }
        return newArray;
    }
}
