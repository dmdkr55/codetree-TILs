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
        ArrayList<Integer> temp = new ArrayList<>();

        boolean isChanged = false;
        int count = 1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) == arr.get(i - 1)) {
                count++;
            } else {
                if (count >= m) { // count가 m이상이면 temp에 추가 안함.
                    isChanged = true;
                } else {
                    for (int j = 1; j <= count; j++) {
                        temp.add(arr.get(i - j));
                    }
                }
                count = 1;
            }
        }

        if (count >= m) {
            isChanged = true;
        } else {
            for (int i = 0; i < count; i++) {
                temp.add(arr.get(arr.size() - 1));
            }
        }
        arr = temp;

        return isChanged;
    }
}