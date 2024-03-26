package Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Blackjack_2798 {
	
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		int n; // 카드의 갯수
		int m; // 최대값
		int result; //배열의 위치
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		//writer.write("입력: ");
		//writer.flush();
		st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(reader.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		result = search(n, m);
		writer.write(result);
		writer.flush();

		writer.close();
		reader.close();

	}

	private static int search(int n, int m) {
		int result=0;
		int temp;
		
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					temp = arr[i]+arr[j]+arr[k];

					if(m==temp){
						return temp;
					}

					if(temp > result && temp < m){
						result = temp;
					}

				}
			}
		}
		return result;
	}
}
