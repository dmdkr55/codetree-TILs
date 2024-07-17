import java.util.Scanner;

public class Main {

    static int n, m, k;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        n = sc.nextInt();
        m = sc.nextInt(); //블록의 크기
        k = sc.nextInt() - 1; //블럭 떨어질 위치
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //블럭 떨어뜨림
        dropBlock(k, m);

        //결과 출력
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void dropBlock(int col, int blockSize) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < blockSize; j++) {
                if (arr[i][col + j] == 1) {
                    for (int l = 0; l < blockSize; l++) {
                        arr[i - 1][col + l] = 1;
                    }
                    return;
                }
            }
        }
    }

}