import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, m;
    static ArrayList<Integer> arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // 폭탄 터트리기
        boolean isBombed = true;
        while (isBombed) {
            if (arr.isEmpty()) {
                break;
            }
            isBombed = bomb();
        }

        // 출력
        System.out.println(arr.size());
        for (int a : arr) {
            System.out.println(a);
        }

    }

    private static boolean bomb() {
        int count = 1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) == arr.get(i - 1)) {
                count++;
            } else {
                if (count >= m) {
                    for (int j = 1; j <= count; j++) {
                        arr.remove(i - j);
                    }
                    return true;
                }
                count = 1;
            }
        }

        if (count >= m) {
            int size = arr.size();
            for (int j = 1; j <= count; j++) {
                arr.remove(size - j);
            }
            return true;
        }
        return false;
    }
}