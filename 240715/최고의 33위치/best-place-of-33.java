import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                int temp = 0;
                temp += arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1];
                temp += arr[i][j-1] + arr[i][j] + arr[i][j+1];
                temp += arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];

                if (temp > max){
                    max = temp;
                }
            }
        }
        System.out.println(max);

    }
}