package Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SortingNumbers_2751 {
	
	static int temp[];

	public static void main(String[] args) throws IOException {
		
		int arr[]; // 입력받은 숫자 저장
		int num; // 숫자의 갯수
		
		
		BufferedReader reader;
		BufferedWriter writer;
		StringBuilder builder;
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		builder = new StringBuilder();
	
		writer.write("입력: ");
		writer.flush();
		num = Integer.parseInt(reader.readLine());
		
		arr = new int[num]; // 갯수에 따른 배열의 크기
		temp = new int[num];
		
		for(int i=0; i<num; i++) {
			
			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//bubbleSort(arr);
		//sellectionSort(arr);
		//insertSort(arr);
		mergeSort(arr, 0, arr.length-1);
		
		
		for(int i=0; i<arr.length; i++) {
			builder.append(arr[i] + "\n"); //문자열로 저장
		}
		
		System.out.println(builder); //결과 출력
		
		reader.close();
		writer.close();
		
		
		
	}//main
	
	private static void mergeSort(int[] arr, int left, int right) {

		int mid; //배열 중앙
		
		if(left < right) {
			mid = (left+right)/2;
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			mergeSort(arr, left, mid, right);
			
			
		}
		
	}

	private static void mergeSort(int[] arr, int left, int mid, int right) {
		
		int part1 = left;
		int part2 = mid+1;
		int index = left;
		
		while(part1 <= mid && part2<=right) {
			if(arr[part1] <= arr[part2]) {
				temp[index] = arr[part1++];
			} else {
				temp[index] = arr[part2++];
			}
			index++;
		}
		
		if(part1 > mid) {
			for(int i=part2; i<=right; i++, index++) {
				temp[index] = arr[i];
			}
		} else {
			for(int i=part1; i<=mid; i++, index++) {
				temp[index] = arr[i];
			}
		}
		
		for(int i=left; i <= right; i++) {
			arr[i] = temp[i];
		}
			
	}
	

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

















