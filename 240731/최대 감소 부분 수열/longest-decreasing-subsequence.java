import java.util.Scanner;

public class Main {

    static final int INT_MIN = Integer.MIN_VALUE;
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        initialize();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        System.out.println(max);
    }

    static void initialize() {
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
    }

}