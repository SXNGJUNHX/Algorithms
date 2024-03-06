package backjun.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11656 {

	public static void main(String[] args) {
		
		String input;
		StringBuffer temp;
		String[] arr;
		//System.out.print("입력: ");
		Scanner scan = new Scanner(System.in);
		
		
		input = scan.nextLine(); // 입력
		arr = new String[input.length()]; // 입력받은 문자열 크기의 배열 생성
		
		for(int i=0; i<input.length(); i++) {
			arr[i] = input.substring(i, input.length()); // 문자열 나눠서 배열에 저장
		}
		
		Arrays.sort(arr); // 배열 정렬
		temp = new StringBuffer();
		
		for(int i=0; i<input.length(); i++) {
			temp.append(arr[i] + "\n"); // 문자열 출력
		}
		
		System.out.print(temp);
	}
}
