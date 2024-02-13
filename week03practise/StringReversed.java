package week03practise;

public class StringReversed {
    public static void main(String[] args) {
        String string = "Hello World";
        System.out.println(reverse(string));
    }

    static String reverse(String s) {
        String reverse_s = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse_s += s.charAt(i);
        }
        return reverse_s;
    }
}
