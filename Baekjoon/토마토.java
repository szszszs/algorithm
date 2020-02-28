import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class 토마토 {
	static int M, N, DAY = 0;
	static int[][] map, dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static Queue<Pair> queue = new LinkedList();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					queue.add(new Pair(i, j));
				}
			}
		}

		BFS();

		if (!check()) {
			System.out.println("-1");
			return;
		} else
			System.out.println(DAY - 1);

	}// end of main

	public static void BFS() {
		while (!queue.isEmpty()) {//false
			int len = queue.size();
			DAY++;

			for (int j = 0; j < len; j++) {
				Pair p = queue.poll();
				visited[p.x][p.y] = true;
				for (int i = 0; i < 4; i++) {

					int nx = p.x + dir[i][0];
					int ny = p.y + dir[i][1];
					
					if (isInside(nx, ny) && !visited[nx][ny] == true && map[nx][ny] == 0) {
						map[nx][ny] = 1;
						queue.offer(new Pair(nx,ny));
					
					}
				}
			}
		}

	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}// end of class


//2차원 배열 - isInside
//4방
//최소 일수- BFS ,Queue
