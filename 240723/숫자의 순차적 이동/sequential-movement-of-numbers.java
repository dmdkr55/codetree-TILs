import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //m번 이동.
        for (int i = 0; i < m; i++) {
            move();
        }

        //출력
        for (int[] a : arr) {
            for (int v : a) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static int[] findMaxValuePosition(int x, int y) {
        int[] xy = new int[2];
        int maxX = 0, maxY = 0;
        int max = 0;
        if (inRange(x - 1, y - 1) && arr[x - 1][y - 1] > max) {
            max = arr[x - 1][y - 1];
            maxX = x - 1;
            maxY = y - 1;
        }
        if (inRange(x, y - 1) && arr[x][y - 1] > max) {
            max = arr[x][y - 1];
            maxX = x;
            maxY = y - 1;
        }
        if (inRange(x + 1, y - 1) && arr[x + 1][y - 1] > max) {
            max = arr[x + 1][y - 1];
            maxX = x + 1;
            maxY = y - 1;
        }
        if (inRange(x - 1, y) && arr[x - 1][y] > max) {
            max = arr[x - 1][y];
            maxX = x - 1;
            maxY = y;
        }
        if (inRange(x + 1, y) && arr[x + 1][y] > max) {
            max = arr[x + 1][y];
            maxX = x + 1;
            maxY = y;
        }
        if (inRange(x - 1, y + 1) && arr[x - 1][y + 1] > max) {
            max = arr[x - 1][y + 1];
            maxX = x - 1;
            maxY = y + 1;
        }
        if (inRange(x, y + 1) && arr[x][y + 1] > max) {
            max = arr[x][y + 1];
            maxX = x;
            maxY = y + 1;
        }
        if (inRange(x + 1, y + 1) && arr[x + 1][y + 1] > max) {
            max = arr[x + 1][y + 1];
            maxX = x + 1;
            maxY = y + 1;
        }
        xy[0] = maxX;
        xy[1] = maxY;
        return xy;
    }

    private static int[] findTarget(int target) {
        int[] xy = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == target) {
                    xy[0] = i;
                    xy[1] = j;
                    return xy;
                }
            }
        }
        return null;
    }

    private static void move() {
        for (int target = 1; target <= n * n; target++) {
            int[] xy = findTarget(target);
            int x = xy[0];
            int y = xy[1];

            int[] maxXY = findMaxValuePosition(x, y);
            int maxX = maxXY[0];
            int maxY = maxXY[1];

            int temp = arr[x][y];
            arr[x][y] = arr[maxX][maxY];
            arr[maxX][maxY] = temp;
        }
    }

}