import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int[] dx = {-1, 0, 1, 0}; //상좌하우, 반시계방향
    static int[] dy = {0, -1, 0, 1};
    static int[][] beads;
    static HashMap<String, Integer> beadMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(st.nextToken());
            beads = new int[M][3]; //x,y,dir
            beadMap = new HashMap<>();
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                beads[j][0] = Integer.parseInt(st.nextToken()) - 1;
                beads[j][1] = Integer.parseInt(st.nextToken()) - 1;
                char d = st.nextToken().charAt(0);
                beads[j][2] = getDirection(d); //0, 1, 2로 방향을 저장.

                // 현재 구슬 위치를 map에 저장
                String position = beads[j][0] + "," + beads[j][1];
                beadMap.put(position, beadMap.getOrDefault(position, 0) + 1);
            }

            //이동 및 충돌 처리
            boolean hasCollision;
            do {
                hasCollision = move();
            } while (hasCollision);

            //출력
            int count = 0;
            for (int j = 0; j < beads.length; j++) {
                if (beads[j][2] != -1) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
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

    static boolean move() {
        HashMap<String, Integer> newBeadMap = new HashMap<>();
        boolean hasCollision = false;

        for (int i = 0; i < beads.length; i++) {
            if (beads[i][2] != -1) { //방향이 -1이면 없어진 구슬로.
                int x = beads[i][0];
                int y = beads[i][1];
                int dir = beads[i][2];
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                //격자 안인지 확인. 벽이면 반대 방향으로 턴
                if (!inRange(nx, ny)) {
                    dir = (dir + 2) % 4; // 반대 방향으로 턴
                    beads[i][2] = dir;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                beads[i][0] = nx;
                beads[i][1] = ny;
                String position = nx + "," + ny;

                // 새 위치에 구슬 추가
                newBeadMap.put(position, newBeadMap.getOrDefault(position, 0) + 1);
            }
        }

        // 충돌 검사 및 처리
        for (int i = 0; i < beads.length; i++) {
            if (beads[i][2] != -1) {
                String position = beads[i][0] + "," + beads[i][1];
                if (newBeadMap.get(position) > 1) {
                    beads[i][2] = -1; // 충돌로 구슬 제거
                    hasCollision = true;
                }
            }
        }

        beadMap = newBeadMap;
        return hasCollision;
    }
}