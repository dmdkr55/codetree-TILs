import java.util.Scanner;

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

        initialize();

        int maxCoin = coins[n - 1];
        for (int i = maxCoin + 1; i < m + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (dp[i - coins[j]] == 0)
                    continue;
                
                if (dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }

        //출력
        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }

    static void initialize() {
        for (int i = 0; i < n; i++) {
            dp[coins[i]] = 1;
        }
    }

}