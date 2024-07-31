import java.util.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[46];
        dp[1] = 1;
        dp[2] = 1;

        int result = 0;
        if (n <= 2) {
            result = dp[n];
        } else {
            result = fibo(n);
        }

        System.out.println(result);
    }

    static int fibo(int n) {
        if (dp[n] != 0)
            return dp[n];
        return fibo(n - 1) + fibo(n - 2);
    }

}