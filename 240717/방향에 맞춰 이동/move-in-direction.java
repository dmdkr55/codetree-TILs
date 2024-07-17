import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int x = 0, y = 0;
        Map<String, Integer> dx = new HashMap<>();
        Map<String, Integer> dy = new HashMap<>();
        dx.put("N", 0);
        dx.put("E", 1);
        dx.put("S", 0);
        dx.put("W", -1);
        dy.put("N", 1);
        dy.put("E", 0);
        dy.put("S", -1);
        dy.put("W", 0);
        for (int i = 0; i < n; i++) {
            String d = sc.next();
            int a = sc.nextInt();
            x += a * dx.get(d);
            y += a * dy.get(d);
        }

        System.out.println(x + " " + y);
    }
}