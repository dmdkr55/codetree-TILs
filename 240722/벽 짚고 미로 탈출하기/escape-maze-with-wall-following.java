import java.util.Scanner;

public class Main {

    static int n, currX, currY, t = 0;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1}; //우, 상, 좌, 하
    static int[] dy = {1, 0, -1, 0};
    static int dir = 0;
    static boolean isEscaped = false;
    static int countTurn = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        n = sc.nextInt();
        arr = new int[n][n];
        currX = sc.nextInt() - 1;
        currY = sc.nextInt() - 1;
        arr[currX][currY] = 1; //현위치는 1
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '#') arr[i][j] = -1; //벽은 -1
            }
        }

        //미로를 탈출할 때까지 이동.
        while (!isEscaped) {
            if (t > n * n) break;
            t++;
            move();
        }
        //출력
        if (isEscaped) System.out.println(t);
        else System.out.println(-1);
    }

    private static void turn() {
        if (countTurn>4){
            return;
        }
        countTurn++;
        dir = (dir + 1) % 4; //반시계 회전
        int nx = currX + dx[dir];
        int ny = currY + dy[dir];
        if (inRange(nx, ny) && arr[nx][ny] == -1) turn(); //다시 턴
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static void move() {
        int nx = currX + dx[dir];
        int ny = currY + dy[dir];
        //앞이 벽이면 반시계 회전
        if (inRange(nx, ny) && arr[nx][ny] == -1) {
            turn();
            nx = currX + dx[dir];
            ny = currY + dy[dir];
        }
        if (inRange(nx, ny) && arr[nx][ny] == -1) {
            return;
        }
        //앞이 격자 밖이라면 탈출
        if (!inRange(nx, ny)) {
            isEscaped = true;
            return;
        }
        //해당 방향으로 이동가능 시
        if (arr[nx][ny] == 0) {
            int right = (dir == 0) ? 3 : dir - 1; //오른쪽 좌표 방향
            int rx = nx + dx[right];
            int ry = ny + dy[right];
            //이동한 위치 기준 오른쪽에 벽이 없으면 방향을 시계방향 회전
            if (arr[rx][ry] != -1) {
                dir = right;
            }
            //이동한 위치 기준 오른쪽에 벽이 존재한다면 전진
            arr[currX][currY] = 0;
            currX = nx;
            currY = ny;
            arr[currX][currY] = 1;
        }
    }

}