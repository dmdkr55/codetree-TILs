import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int n, m;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        dp = new int[m + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0원을 만드는 데 필요한 동전 수는 0개

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        //출력
        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }
}