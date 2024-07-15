import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();

        ArrayList<Integer> temp = new ArrayList<>();
        arr = getIntegers(arr, s1, e1, temp);
        temp = new ArrayList<>();

        arr = getIntegers(arr, s2, e2, temp);

        System.out.println(arr.size());
        for (int v : arr) {
            System.out.println(v);
        }

    }

    private static ArrayList<Integer> getIntegers(ArrayList<Integer> arr, int s2, int e2, ArrayList<Integer> temp) {
        for (int i = 0; i < arr.size(); i++) {
            if (i >= s2 - 1 && i <= e2 - 1) {
                continue;
            }
            temp.add(arr.get(i));
        }
        arr = temp;
        return arr;
    }
}