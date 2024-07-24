import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int T, N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}; //상좌하우, 반시계방향
    static int[] dy = {0, -1, 0, 1};
    static int[][] beads;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            arr = new int[N][N];

            M = sc.nextInt();
            beads = new int[M][3]; //x,y,dir
            for (int j = 0; j < M; j++) {
                beads[j][0] = sc.nextInt() - 1;
                beads[j][1] = sc.nextInt() - 1;
                char d = sc.next().charAt(0);
                beads[j][2] = getDirection(d); //0, 1, 2로 방향을 저장.
            }

            //이동
            for (int j = 0; j < 2 * N; j++) {
                move();
            }

            //출력
            int count = 0;
            for (int j = 0; j < beads.length; j++) {
                if (beads[j][2] != -1) count++;
            }
            System.out.println(count);
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static int getDirection(int d) {
        if (d == 'U') return 0;
        else if (d == 'L') return 1;
        else if (d == 'D') return 2;
        else if (d == 'R') return 3;
        else if (d == 0) return 'U';
        else if (d == 1) return 'L';
        else if (d == 2) return 'D';
        else if (d == 3) return 'R';

        return -1;
    }

    static void move() {
        for (int i = 0; i < beads.length; i++) {
            if (beads[i][2] != -1) { //방향이 -1이면 없어진 구슬로.
                int x = beads[i][0];
                int y = beads[i][1];
                int dir = beads[i][2];
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                //격자 안인지 확인. 벽이면 반대 방향으로 턴
                if (!inRange(nx, ny)) {
                    dir = (dir + 2) % 4; //ex) 0, 1, 2
                    beads[i][2] = dir;
                } else {
                    beads[i][0] = nx;
                    beads[i][1] = ny;
                }
            }
        }
        //부딛히면 제거
        for (int i = 0; i < beads.length; i++) {
            boolean isRemoved = false;
            for (int j = i + 1; j < beads.length; j++) {
                if (beads[i][2] != -1 && beads[j][2] != -1 && beads[i][0] == beads[j][0] && beads[i][1] == beads[j][1]) {
                    isRemoved = true;
                    beads[j][2] = -1;// 겹치는 거 제거
                }
            }
            if (isRemoved) beads[i][2] = -1;
        }
    }

}