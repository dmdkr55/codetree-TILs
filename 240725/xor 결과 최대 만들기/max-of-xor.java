import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = getMax(m - 1, i, arr[i]);
            if (temp > max)
                max = temp;
        }

        System.out.println(max);
    }

    static int getMax(int count, int startIndex, int result) {
        if (count == 0) {
            return result;
        }
        int max = 0;
        for (int i = startIndex + 1; i < n; i++) {
            int temp = getMax(count - 1, i, result ^ arr[i]);
            if (temp > max)
                max = temp;
        }
        return max;
    }
}