import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n];

        int max = getMaxValue(n, 0, 0);

        System.out.println(max);
    }

    static int getMaxValue(int count, int row, int result) {
        if (count == 0) {
            return result;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            int temp = getMaxValue(count - 1, row + 1, result + arr[row][i]);
            visited[i] = false;
            max = Math.max(max, temp);
        }
        return max;
    }

}