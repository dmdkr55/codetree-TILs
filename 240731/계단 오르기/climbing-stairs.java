import java.util.Scanner;

public class Main {

    static final int MOD = 10007;
    static final int MAX_NUM = 1000;
    static int n;
    static int[] dp = new int[MAX_NUM + 1];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % MOD;
        }

        System.out.println(dp[n]);
    }
}