import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; //상좌하우
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Integer> peoples;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //입력 및 초기화
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n][n];
        peoples = new ArrayList<>();

        //사람수 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    int result = countPeople(i, j, 1);
                    peoples.add(result);
                }
            }
        }

        //출력
        peoples.sort(Comparator.naturalOrder());
        System.out.println(peoples.size());
        for (int num : peoples) {
            System.out.println(num);
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static int countPeople(int x, int y, int count) {
        int result = 1;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny) && arr[nx][ny] != 0 && !visited[nx][ny]) {
                result += countPeople(nx, ny, count + 1);
            }
        }
        return result;
    }


}