/**
 * 	순열 Permutation
 * 
 *
 */
public class 순열 {
	public static int[] arr = {6,7,8};
	
	public static void main(String[] args) {
		
		int n = arr.length;
		int r = 3;//네개중 두개 뽑고싶으면 2
		perm(r,0);//r이 될때까지 반복해라 , n은 고정
		
	}//end of main
	/** r: 뽑을 개수, k: 현재단계*/
	public static void perm(int r, int k) {
		if(r == k) {//종료 파트
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}else {//재귀파트
			//k 이전은 확정 k단계부터 
			for (int i = k; i < arr.length; i++) {//0~(k-1)확정, 미선택수 k~끝
				//arr[i] <-> arr[k] swap
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(r,k+1);
				////arr[i] <-> arr[k] swap,다음 작업을 위해서 원상 복귀
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
			
		}
		
	}

}//end of class
