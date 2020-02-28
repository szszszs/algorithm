import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색{
	static int N,M;
	static int[][] map,dir= {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean[][] visited;
	static Queue<Pair> q = new LinkedList();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				
				map[i][j] = s.charAt(j)-48;
			}
		}//end of input
		
		bfs();
		System.out.println(map[N-1][M-1]);//좌표 값을 배열의 범위로
		
	}//end of main
	
	public static void bfs() {
		q.offer(new Pair(0, 0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dir[k][0];
				int ny = p.y + dir[k][1];
				
				if(isInside(nx,ny) && map[nx][ny]==1 && !visited[nx][ny]) {
					q.offer(new Pair(nx,ny));
					visited[nx][ny] = true;
					map[nx][ny] = map[p.x][p.y] + 1;//이동 거리 
					
				}
			}
			
		}
		
	}

	public static boolean isInside(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
}//end of class
class Pair{
	int x;
	int y;
	
	Pair(int x ,int y){
		this.x = x;
		this.y = y;
	}
} 
