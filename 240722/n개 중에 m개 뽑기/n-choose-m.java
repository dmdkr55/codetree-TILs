import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        int n = sc.nextInt();
        int m = sc.nextInt();

        //출력
        printResult(0, n, m, "");
    }

    private static void printResult(int n0, int n1, int m, String s) {
        if (m == 0) {
            System.out.println(s);
            return;
        }
        for (int i = n0 + 1; i <= n1; i++) {
            String newS = s + i + " ";
            printResult(i, n1, m - 1, newS);
        }
    }
}