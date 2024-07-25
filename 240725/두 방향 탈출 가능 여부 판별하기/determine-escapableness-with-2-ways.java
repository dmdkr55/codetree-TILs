import java.util.ArrayList;
import java.util.Scanner;
import java.util.prefs.PreferenceChangeListener;

public class Main {

    static int n, m;
    static boolean[][] visited;
    static int[][] arr;
    static int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1][m + 1];
        arr = new int[n][m];
        answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //DFS
        visited[0][0] = true;
        answer[0][0] = 1;
        DFS(0, 0);

        //출력
        if (answer[n - 1][m - 1] == 1)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false; //격자 밖
        if (visited[x][y] || arr[x][y] == 0) return false; //방문했거나, 뱀이 있을 경우
        return true;
    }

    static void DFS(int x, int y) {
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                answer[nx][ny] = 1;
                DFS(nx, ny);
            }

        }
    }

}