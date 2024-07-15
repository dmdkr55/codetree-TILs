import java.util.Scanner;

public class Main {

    static int n;
    static int[][] arr;
    static int r, c;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt();
        c = sc.nextInt();
        r -= 1;
        c -= 1;

        // 폭탄 터트리기
        int selectedValue = arr[r][c];
        arr[r][c] = 0;
        for (int i = 1; i < selectedValue; i++) {
            bomb(i);
        }

        // 빈칸 밀기
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i][j] == 0) {
                    for (int k = 1; k <= i; k++) {
                        if (arr[i - k][j] != 0) {
                            arr[i][j] = arr[i - k][j];
                            arr[i - k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }

        // 출력
        for (int[] a : arr) {
            for (int v : a) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }

    private static void bomb(int v) {
        if (r - v >= 0) {
            arr[r - v][c] = 0;
        }
        if (r + v < n) {
            arr[r + v][c] = 0;
        }
        if (c - v >= 0) {
            arr[r][c - v] = 0;
        }
        if (c + v < n) {
            arr[r][c + v] = 0;
        }
    }
}