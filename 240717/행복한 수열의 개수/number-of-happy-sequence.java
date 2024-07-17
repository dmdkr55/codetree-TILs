import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (getRowN(i) >= m) {
                count++;
            }
            if (getColN(i) >= m) {
                count++;
            }
        }
        System.out.println(count);
    }

    static int getRowN(int row) {
        int finalResult = 1;
        int prevValue;
        int count = 1;
        for (int i = 1; i < n; i++) {
            prevValue = arr[row][i-1];
            if (arr[row][i] != prevValue && count > finalResult) {
                finalResult = count;
                count = 1;
            } else if (arr[row][i] == prevValue) {
                count++;
            }
        }

        if (count > finalResult){
            finalResult = count;
        }
        return finalResult;
    }

    static int getColN(int col) {
        int finalResult = 1;
        int prevValue;
        int count = 1;
        for (int i = 1; i < n; i++) {
            prevValue = arr[i-1][col];
            if (arr[i][col] != prevValue && count > finalResult) {
                finalResult = count;
                count = 1;
            } else if (arr[i][col] == prevValue) {
                count++;
            }
        }

        if (count > finalResult){
            finalResult = count;
        }
        return finalResult;
    }
}