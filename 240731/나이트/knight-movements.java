import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, r1, c1, r2, c2;
    static int[][] grid;
    static int[][] step;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<Pair>();
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //입력 및 초기화
        n = sc.nextInt();
        grid = new int[n][n];
        step = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                step[i][j] = -1;
            }
        }
        visited = new boolean[n][n];
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        //실행
        push(r1, c1, 0);
        BFS();

        //출력
        System.out.println(step[r2][c2]);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y))
            return false;
        if (visited[x][y]) //이미 방문한 곳
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

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canGo(nx, ny)) {
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }
    }

}