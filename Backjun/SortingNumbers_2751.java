package Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SortingNumbers_2751 {

	public static void main(String[] args) throws IOException {
		
		int arr[]; // 입력받은 숫자 저장
		int num; // 숫자의 갯수
		String result = "";
		BufferedReader reader;
		BufferedWriter writer;
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
		writer.write("입력: ");
		writer.flush();
		num = Integer.parseInt(reader.readLine());
		
		arr = new int[num]; // 갯수에 따른 배열의 크기
		
		for(int i=0; i<num; i++) {
			
			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//bubbleSort(arr);
		//sellectionSort(arr);
		insertSort(arr);
		
		
		for(int i=0; i<arr.length; i++) {
			result += arr[i] + "\n"; //문자열로 저장
		}
		
		writer.write(result); //결과 출력
		
		reader.close();
		writer.close();
		
		
		
	}//main
	
	public static void insertSort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}//insertSort
	
	public static void bubbleSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}//bubbleSort
	
	public static void sellectionSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			int midIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[midIndex]) 
					midIndex = j;
			}
			swap(arr, i, midIndex);
		}
	}//sellectionSort
	
	public static void swap(int[] arr, int index1, int index2) {
		
		int temp = 0;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		
	}//swap
	
}//end of class

















