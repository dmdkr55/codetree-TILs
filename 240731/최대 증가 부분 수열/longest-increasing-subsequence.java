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
                if (dp[j] == INT_MIN)
                    continue;

                if (j + arr[j] >= i)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        System.out.println(dp[n - 1]);
    }

    static void initialize() {
        for (int i = 0; i < n; i++) {
            dp[i] = INT_MIN;
        }
        dp[0] = 0;
    }


}