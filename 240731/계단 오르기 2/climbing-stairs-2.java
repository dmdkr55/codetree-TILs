import java.util.Scanner;

public class Main {

    static final int MAXN = 1001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        int n = sc.nextInt();
        int[] arr = new int[MAXN];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt(); //각 계단에 있는 동전수
        int[][] dp = new int[MAXN][4];

        //초기화
        dp[1][1] = arr[1];
        dp[2][0] = arr[2];
        dp[2][2] = arr[1] + arr[2];

        //dp
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {
                if (dp[i - 2][j] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + arr[i]);
                }
                if (j > 0 && dp[i - 1][j - 1] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + arr[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= 3; i++) {
            if (dp[n][i] > max)
                max = dp[n][i];
        }
        System.out.println(max);

    }
}