import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m;
    static int[][] grid;
    static int[][] step;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<Pair>();
    static int order = 1;
    static int[] dx = {-1, 0, 1, 0}; //상좌하우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //입력 및 초기화
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt(); //이동할 수 없는 곳이 0
            }
        }
        step = new int[n][m];
        visited = new boolean[n][m];

        //실행
        push(0, 0, 0);
        BFS();

        //출력
        if (step[n - 1][m - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(step[n - 1][m - 1]);
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y))
            return false;
        if (visited[x][y] || grid[x][y] == 0) //이미 방문했거나, 이동불가한 곳
            return false;
        return true;
    }

    static void push(int x, int y, int s) {
        step[x][y] = s;
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    static void BFS() {
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canGo(nx, ny)) {
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }
    }

}