import java.util.Scanner;

public class Main {

    static int[] arr = new int[5];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        int n = sc.nextInt();

        //아름다운 수의 개수를 구함
        getNumbers(n, "");

        //출력
        System.out.println(count);
    }

    private static boolean isBeautiful(String s) {
        while (s.length() > 0) {
            int first = Integer.parseInt(String.valueOf(s.charAt(0)));
            if (first > s.length()) return false;
            for (int i = 1; i < first; i++) {
                int value = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (first != value) return false;
            }
            s = s.substring(first);
        }
        return true;
    }

    private static void getNumbers(int n, String s) {
        if (n == 0) {
            if (isBeautiful(s)) count++;
            return;
        }
        for (int i = 1; i <= 4; i++) {
            getNumbers(n - 1, s + i);
        }
    }
}