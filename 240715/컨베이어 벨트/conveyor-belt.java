import java.util.Scanner;

public class Main {

    static int n;
    static int t;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();
        arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[1][i] = sc.nextInt();
        }

        while (t > 0) {
            int temp0 = arr[0][n - 1];
            for (int i = n - 1; i > 0; i--) {
                arr[0][i] = arr[0][i - 1];
            }
            int temp1 = arr[1][n - 1];
            for (int i = n - 1; i > 0; i--) {
                arr[1][i] = arr[1][i - 1];
            }
            arr[0][0] = temp1;
            arr[1][0] = temp0;
            t--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[0][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[1][i] + " ");
        }
    }
}