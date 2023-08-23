import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press ⌥⏎ with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int[] q1 = {19, 14, 28};
        int[] p1 = ThirdQuestion.solution(5, q1);
        System.out.println(Arrays.toString(p1)); // Output: [21, 15, 29]

        int[] q2 = {7, 3, 5, 1};
        int[] p2 = ThirdQuestion.solution(3, q2);
        System.out.println(Arrays.toString(p2)); // Output: [-1, 7, 6, 3]

    }
}