import java.util.Scanner;

public class Main {

    static final int NUM_DIR = 4;
    static int n, m, t;
    static int[][] arr; //격자판
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int[][] beads; //구슬의 위치 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        n = sc.nextInt();
        m = sc.nextInt(); //구슬의 개수
        t = sc.nextInt(); //시간
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //구슬 위치 설정.
        beads = new int[m][2];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            beads[i][0] = x;
            beads[i][1] = y;
        }

        //1초마다 구슬을 움직임.
        for (int i = 0; i < t; i++) {
            moveBeads();
        }

        //남은 구슬 수 출력
        System.out.println(m);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static void moveBeads() {
        //구슬 근처에 더 큰거를 찾아서 이동.
        for (int i = 0; i < m; i++) {
            int x = beads[i][0], y = beads[i][1];
            if (x == -1) {
                continue;
            }
            int biggerN = arr[x][y];
            for (int dir = 0; dir < NUM_DIR; dir++) {
                int nx = beads[i][0] + dx[dir];
                int ny = beads[i][1] + dy[dir];
                //가장 큰수를 찾음. 같은 수라면 방향 우선순위 순으로
                if (inRange(nx, ny) && arr[nx][ny] > biggerN) {
                    biggerN = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
            }
            beads[i][0] = x;
            beads[i][1] = y;
        }

        //구슬 위치 중복검사
        boolean duplicated = true;
        while (duplicated) {
            duplicated = checkDuplicateBeads();
        }
    }

    private static boolean checkDuplicateBeads() {
        //구슬이 겹치면 파괴. x좌표를 -1로 표기.
        for (int i = 0; i < beads.length; i++) {
            for (int j = i + 1; j < beads.length; j++) {
                if (beads[i][0] != -1 && beads[i][0] == beads[j][0] && beads[i][1] == beads[j][1]) {
                    beads[i][0] = -1;
                    beads[j][0] = -1;
                    //구슬 개수 수정
                    m -= 2;
                    return true;
                }
            }
        }
        return false;
    }

}