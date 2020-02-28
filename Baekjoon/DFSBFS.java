import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, V;
	static boolean[] visited;
	static int[][] arr;
	static Queue<Integer> queue = new LinkedList();
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		arr = new int[N + 1][N + 1];
		visited = new boolean[arr.length];

		for (int i = 0; i < M; i++) {// 0 1 2 3 4 5
			int x = sc.nextInt(); // 1
			int y = sc.nextInt();// 2

			arr[x][y] = 1;
			arr[y][x] = 1;

		}

		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		int v = V;
		DFS(v);
		System.out.println();
		visited = new boolean[arr.length];
		BFS(v);
	}// eom

	public static void DFS(int v) {
		System.out.print(v+" ");
		visited[v] = true;//방문 true
		for (int i = 0; i < arr[v].length; i++) {
			if(arr[v][i]==1 && !visited[i]) {
				DFS(i);
			}
		}
	}

	public static void BFS(int v) {
		queue.add(v);
		visited[v] = true;
	
		while(!queue.isEmpty()) {
			int nv = queue.poll();
			System.out.print(nv+" ");
			
			for (int i = 0; i < arr[nv].length; i++) {
				if(arr[nv][i]==1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
