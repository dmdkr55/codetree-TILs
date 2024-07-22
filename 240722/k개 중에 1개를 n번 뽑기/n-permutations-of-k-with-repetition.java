import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        int k = sc.nextInt();
        int n = sc.nextInt();

        //출력
        printResult(k, n, "");
    }

    private static void printResult(int k, int n, String s) {
        if (n == 0) {
            System.out.println(s);
            return;
        }
        for (int i = 1; i <= k; i++) {
            String newS = s + i + " ";
            printResult(k, n - 1, newS);
        }
    }
}