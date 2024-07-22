import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n;
    static boolean[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n + 1];

        choose(1);
    }

    private static void printAnswer() {
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

    private static void choose(int currNum) {
        if (currNum == n + 1) {
            printAnswer();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            answer.add(i);

            choose(currNum + 1);

            answer.remove(answer.size() - 1);
            visited[i] = false;
        }
    }
}