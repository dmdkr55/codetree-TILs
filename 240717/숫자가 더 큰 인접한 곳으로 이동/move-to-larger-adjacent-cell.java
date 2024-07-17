import java.util.Scanner;

public class Main {

    static int n;
    static int r, c;
    static int[][] arr;
    static String result = "";

    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        move(r, c);

        System.out.println(result);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static void move(int x, int y) {
        result += arr[x][y] + " ";

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (inRange(nx, ny) && arr[nx][ny] > arr[x][y]) {
                move(nx, ny);
                return;
            }
        }
    }

}