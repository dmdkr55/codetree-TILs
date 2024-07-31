import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, k;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<Pair>();
    static int order = 1;
    static int[] dx = {-1, 0, 1, 0}; //상좌하우
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //입력 및 초기화
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt(); //이동할 수 없는 곳이 1
            }
        }
        visited = new boolean[n][n];

        //실행
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            if (!visited[x][y]) {
                push(x, y);
                BFS();
            }
        }

        //출력
        System.out.println(count);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y))
            return false;
        if (visited[x][y] || grid[x][y] == 1) //이미 방문했거나, 이동불가한 곳
            return false;
        return true;
    }

    static void push(int x, int y) {
        count++;
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
                    push(nx, ny);
                }
            }
        }
    }

}