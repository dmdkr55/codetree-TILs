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

        //모든 K에 대하여 탐색.
        int maxGold = 0;
        for (int i = 0; i <= n; i++) {
            int gold = search(i);
            // 손해보지 않으면서 채굴할 수 있는 가장 많은 금의 개수.
            int cost = (i * i + (i + 1) * (i + 1));
            if (gold * m >= cost && gold > maxGold) {
                maxGold = gold;
            }
        }

        //출력
        System.out.println(maxGold);
    }

    private static int search(int K) {
        int maxGold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int gold = getGold(i, j, K);
                if (gold > maxGold) {
                    maxGold = gold;
                }
            }
        }
        return maxGold;
    }

    private static int getGold(int x, int y, int K) {
        int count = 0;
        boolean[][] visited = new boolean[n][n];

        for (int dx = 0; dx <= K; dx++) {
            for (int dy = 0; dy <= K; dy++) {
                if (dx + dy <= K) {
                    if (x + dx < n && y + dy < n && !visited[x + dx][y + dy]) {
                        count += arr[x + dx][y + dy];
                        visited[x + dx][y + dy] = true;
                    }
                    if (x + dx < n && y - dy >= 0 && !visited[x + dx][y - dy]) {
                        count += arr[x + dx][y - dy];
                        visited[x + dx][y - dy] = true;
                    }
                    if (x - dx >= 0 && y + dy < n && !visited[x - dx][y + dy]) {
                        count += arr[x - dx][y + dy];
                        visited[x - dx][y + dy] = true;
                    }
                    if (x - dx >= 0 && y - dy >= 0 && !visited[x - dx][y - dy]) {
                        count += arr[x - dx][y - dy];
                        visited[x - dx][y - dy] = true;
                    }
                }
            }
        }

        return count;
    }

}