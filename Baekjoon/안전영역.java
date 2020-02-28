import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map, dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static int N,count = 0,max =1;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		for (int k = 1; k <= 100; k++) {//높이 1부터 100까지 잠기는 지 
			count = 0;//count 초기화
			
			for (int i = 0; i < N; i++) {//맵 한번 돌 때
				for (int j = 0; j < N; j++) {
					
					if(map[i][j]>k && !visited[i][j]) {
						DFS(i, j, k); //dfs 
						count++;
					}
				}	
			}
			visited = new boolean[N][N];//방문 초기화
			if(max<count) {
				max = count;
			}			
		}
		
	
		System.out.println(max);
	
	}// end of main

	public static void DFS(int x, int y,int k) {
	
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			// 다음 좌표가 범위 안에 있고 다음 좌표가 k보다 크고 방문처리가 안된 부분을 다시 dfs
			if(isInside(nx,ny) && map[nx][ny] > k && !visited[nx][ny]) {
				DFS(nx,ny,k);
			}
		}
		
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}// end of class
