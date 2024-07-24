import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}; //상좌하우, 반시계방향
    static int[] dy = {0, -1, 0, 1};
    static int[][] beads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            M = Integer.parseInt(st.nextToken());
            beads = new int[M][3]; //x,y,dir
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                beads[j][0] = Integer.parseInt(st.nextToken()) - 1;
                beads[j][1] = Integer.parseInt(st.nextToken()) - 1;
                char d = st.nextToken().charAt(0);
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
//            sb.append(count).append("\n");
            System.out.println(count);
        }

//        System.out.print(sb);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static int getDirection(char d) {
        if (d == 'U') return 0;
        else if (d == 'L') return 1;
        else if (d == 'D') return 2;
        else if (d == 'R') return 3;
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