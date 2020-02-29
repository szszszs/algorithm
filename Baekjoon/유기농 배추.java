import java.util.Arrays;
import java.util.Scanner;

public class 유기농배추 {
	static int T, M, N, K, count = 0;
	static int[][] map, dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int k = 0; k < K; k++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			} // end of input 

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {

						dfs(i, j);
						count++;
					}

				}
			}
		
			System.out.println(count);
			visited = new boolean[N][M];
			count=0;
			
		} // end of tc
	}// end of main

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			if (isInside(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {

				dfs(nx, ny);
			}
		}
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
