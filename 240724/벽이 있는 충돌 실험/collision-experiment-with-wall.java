import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}; //상좌하우, 반시계방향
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<int[]> beads;

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
            beads = new ArrayList<>(); //x,y,dir
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int d = getDirection(st.nextToken().charAt(0)); //0, 1, 2로 방향을 저장.
                int[] temp = {x, y, d};
                beads.add(temp);
            }

            //이동
            for (int j = 0; j < 2 * N; j++) {
                move();
            }

            //출력
            sb.append(beads.size()).append("\n");
        }

        System.out.print(sb);
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
        for (int i = 0; i < beads.size(); i++) {
            int x = beads.get(i)[0];
            int y = beads.get(i)[1];
            int dir = beads.get(i)[2];
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //격자 안인지 확인. 벽이면 반대 방향으로 턴
            if (!inRange(nx, ny)) {
                dir = (dir + 2) % 4; //ex) 0, 1, 2
                beads.get(i)[2] = dir;
            } else {
                beads.get(i)[0] = nx;
                beads.get(i)[1] = ny;
            }
        }
        //부딛히면 제거
        ArrayList<Integer> removeIndex = new ArrayList<>();
        for (int i = 0; i < beads.size(); i++) {
            boolean isRemoved = false;
            for (int j = i + 1; j < beads.size(); j++) {
                if (Objects.equals(beads.get(i)[0], beads.get(j)[0]) && Objects.equals(beads.get(i)[1], beads.get(j)[1])) {
                    isRemoved = true;
                    removeIndex.add(j);
                }
            }
            if (isRemoved)
                removeIndex.add(i);
        }

        removeIndex.sort(Comparator.reverseOrder());
        for (int i = 0; i < removeIndex.size(); i++) {
            int index = removeIndex.get(i);
            beads.remove(index);
        }
    }
}