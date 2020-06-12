package test3;

public class RemoveRepetitions {
    public static String transform(String input) {
        StringBuffer mResult = new StringBuffer();
        mResult.append(input.charAt(0));
        for (int i=1; i<input.length(); i++) {
            if (input.charAt(i) != input.charAt(i-1)) {
                mResult.append(input.charAt(i));
            }
        }
        return mResult.toString();
    }

    public static void main(String[] args) {
        System.out.println(RemoveRepetitions.transform("abbcbbb"));
    }
}