public class Exercise2 {
    public static void main(String[] args) {

    }

    //O(1)
    public static String phoneValidation (String phoneNum) {
        String correctedNumber = phoneNum;
        String internationalCode = "972";

        if (phoneNum.substring(0, 3).equals(internationalCode)) {
            correctedNumber = "0" + phoneNum.substring(3);
        }
        if (!phoneNum.contains("-")) {
            correctedNumber = correctedNumber.substring(0, 3) + "-" + correctedNumber.substring(3);
        }

        if (correctedNumber.charAt(0) != '0' && correctedNumber.charAt(0) != '9') {
            correctedNumber = " ";
        }
        if (correctedNumber.length() != 11) {
            correctedNumber = " ";
        }

        return correctedNumber;
    }
}
