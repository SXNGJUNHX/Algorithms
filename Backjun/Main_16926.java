package backjun.java;

import java.util.Scanner;

public class Main_16926 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n, m, r; // n, m : 배열크기, r: 횟수
		int count;	 // 돌아가는 라인 갯수
		
		//System.out.print("입력");
		n = scan.nextInt();
		m = scan.nextInt();
		r = scan.nextInt();
		
		count = n > m ?  m/2 : n/2;
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {	// 배열 입력
			for(int j=0; j<m ; j++) {
				
				int temp = scan.nextInt();
				arr[i][j] = temp;
				
			}
		}
		
		for(int i=0; i<r; i++) {	// 배열 회전
			for(int j=0; j<count; j++) {
				int temp = arr[j][j];
				
				for(int k=j+1; k<m-j; k++) { // 왼쪽으로 이동
					arr[j][k-1] = arr[j][k];
				}
				
				for(int k=j+1; k<n-j; k++) { // 위쪽으로 이동
					arr[k-1][m-1-j] = arr[k][m-1-j];
				}
				
				for(int k=m-2-j; k>=j; k--){ // 오른쪽으로 이동
					arr[n-1-j][k+1] = arr[n-1-j][k];
				}
				
				for(int k=n-2-j; k>=j; k--) { // 아래쪽으로 이동
					arr[k+1][j] = arr[k][j];
				}
				
				arr[j+1][j] = temp;
			}
		}
		
		for(int i=0; i<n; i++) {	// 배열 출력
			for(int j=0; j<m ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}	
	}
}


























