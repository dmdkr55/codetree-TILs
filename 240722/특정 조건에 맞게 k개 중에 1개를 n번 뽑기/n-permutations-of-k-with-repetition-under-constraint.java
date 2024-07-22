import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        int k = sc.nextInt();
        int n = sc.nextInt();

        //출력
        printResult(k, n, "", 0);
    }

    private static void printResult(int k, int n, String s, int count) {
        if (n == 0) {
            System.out.println(s);
            return;
        }
        for (int i = 1; i <= k; i++) {
            String newS = s + i + " ";
            int length = newS.length();
            if (length >= 6 && newS.charAt(length - 2) == newS.charAt(length - 4) && newS.charAt(length - 6) == newS.charAt(length - 4))
                continue;
            printResult(k, n - 1, newS, count);
        }
    }
}