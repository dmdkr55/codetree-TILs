import java.util.Scanner;

public class Main {

    static int n;
    static int[][] grid;
    static int[][] dp;
    static int[] dx = {1, 0}; //하우
    static int[] dy = {0, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n][n];
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        initialize();

        for (int i = 1; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j + 1] + grid[i][j]);
            }
        }

        System.out.println(dp[n - 1][0]);
    }

    static void initialize() {
        dp[0][n - 1] = grid[0][n - 1];
        for (int i = 1; i < n; i++) {
            dp[i][n - 1] = dp[i - 1][n - 1] + grid[i][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[0][i] = dp[0][i + 1] + grid[0][i];
        }
    }

}