import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = 0, y = 0;
        int[] dx = new int[]{0, 1, 0, -1}; //N, E, S, W
        int[] dy = new int[]{1, 0, -1, 0}; //N, E, S, W
        int dir = 0;

        for (int i = 0; i < n; i++) {
            String d = sc.next();
            int a = sc.nextInt();
            
            if (d.charAt(0) == 'N') dir = 0;
            else if (d.charAt(0) == 'E') dir = 1;
            else if (d.charAt(0) == 'S') dir = 2;
            else if (d.charAt(0) == 'W') dir = 3;

            x += a * dx[dir];
            y += a * dy[dir];
        }

        System.out.println(x + " " + y);
    }
}