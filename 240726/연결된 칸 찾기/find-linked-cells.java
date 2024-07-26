import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static int n;
    static boolean[][] visited;
    static int[][] arr;
    static ArrayList<Integer> counts = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0}; //상좌하우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        n = sc.nextInt();

        visited = new boolean[n + 1][n + 1];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //DFS
        visited[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    counts.add(dfs(i, j, 1));
                }
            }
        }

        //출력
        System.out.println(counts.size());
        counts.sort(Comparator.naturalOrder());
        for (int cnt : counts) {
            System.out.println(cnt);
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false; //격자 밖
        if (visited[x][y] || arr[x][y] == 0) return false; //방문했거나, 뱀이 있을 경우
        return true;
    }

    static int dfs(int x, int y, int count) {
        arr[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                count = dfs(nx, ny, count + 1);
            }
        }

        return count;
    }
}