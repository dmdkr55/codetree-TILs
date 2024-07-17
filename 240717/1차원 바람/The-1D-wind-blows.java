import java.util.Scanner;

public class Main {

    static int n, m, q;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < q; i++) {
            //바람 살랑
            int r = sc.nextInt() - 1;
            String d = sc.nextLine().trim();
            String rd = d.equals("L") ? "R" : "L"; //반대 방향

            //한칸씩 shift
            shift(r, d);

            //전파
            upSpread(r, rd);
            downSpread(r, rd);
        }

        //출력
        for (int[] row : arr) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    private static void shift(int r, String d) {
        if (d.equals("L")) { //왼쪽에서 바람
            int temp = arr[r][m - 1];
            for (int i = m - 1; i > 0; i--) {
                arr[r][i] = arr[r][i - 1];
            }
            arr[r][0] = temp;
        } else { //오른쪽에서 바람
            int temp = arr[r][0];
            for (int i = 0; i < m - 1; i++) {
                arr[r][i] = arr[r][i + 1];
            }
            arr[r][m - 1] = temp;
        }
    }

    private static void upSpread(int r, String d) {
        if (r - 1 >= 0 && check(r, r - 1)) {
            //shift시킴.
            shift(r - 1, d);
            //전파 전달
            String rd = d.equals("L") ? "R" : "L"; //반대 방향
            upSpread(r - 1, rd);
        }
    }

    private static void downSpread(int r, String d) {
        if (r + 1 < n && check(r, r + 1)) {
            //shift시킴.
            shift(r + 1, d);
            //전파 전달
            String rd = d.equals("L") ? "R" : "L"; //반대 방향
            downSpread(r + 1, rd);
        }
    }

    private static boolean check(int r1, int r2) {
        for (int i = 0; i < m; i++) {
            if (arr[r1][i] == arr[r2][i])
                return true;
        }
        return false;
    }

}