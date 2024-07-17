import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int maxGold = 0;

        // 모든 K값에 대하여 탐색
        for (int K = 0; K <= n; K++) {
            int cost = K * K + (K + 1) * (K + 1);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int gold = getGold(i, j, K);
                    if (gold * m >= cost && gold > maxGold) {
                        maxGold = gold;
                    }
                }
            }
        }

        // 출력
        System.out.println(maxGold);
    }

    private static int getGold(int x, int y, int K) {
        int count = 0;

        for (int dx = -K; dx <= K; dx++) {
            for (int dy = -K; dy <= K; dy++) {
                if (Math.abs(dx) + Math.abs(dy) <= K) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        count += arr[nx][ny];
                    }
                }
            }
        }

        return count;
    }
}