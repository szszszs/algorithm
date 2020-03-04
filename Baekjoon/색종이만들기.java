import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int[][] map;
	static int N,wcnt=0,bcnt=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}//end of input
		
		div(0,0,N);
		System.out.println(wcnt);
		System.out.println(bcnt);
	
	}

	public static void div(int x, int y, int N) {
		//먼저 맵에 1으로 가득찼는지 검사
		int count = 0;
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if(map[i][j]==1)count++;
			}
		}
		//갯수가 0 이면 wcnt++
		if(count == 0)wcnt++;
 		//갯수가 1이면 bcnt++
		else if(count == N*N)bcnt++;
		//둘다 아니면 재귀 1,2,3,4 분할하여 재귀
		else {
			div(x,y,N/2);
			div(x,y+N/2,N/2);
			div(x+N/2,y,N/2);
			div(x+N/2,y+N/2,N/2);
		}
		
	}
}
