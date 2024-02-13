package week03practise;

public class StringReversed {
    public static void main(String[] args) {
        String string = "Hello World";
        System.out.println(reverse(string));
    }

    static String reverse(String string) {
        String reverse_s = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reverse_s += string.charAt(i);
        }
        return reverse_s;
    }
}
