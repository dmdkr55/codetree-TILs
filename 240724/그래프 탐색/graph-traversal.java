import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, m;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        //DFS
        DFS(1);

        //출력
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < graph[i].size(); j++) {
//                System.out.print(graph[i].get(j) + " ");
//            }
//            System.out.println();
//        }
        System.out.println(count-1);
    }

    static void DFS(int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            int currV = graph[vertex].get(i);
            if (!visited[currV]) {
                count++;
                visited[currV] = true;
                DFS(currV);
            }
        }
    }

}