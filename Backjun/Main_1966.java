package backjun.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966 {

	static int t; // 테스트 케이스 수
	static int n; // 문서의 개수
	static int m; // 궁금한 문서의 초기 위치 
	static Queue<Integer> queue; // 문서의 중요도
	static Queue<Integer> index; // 문서의 인덱스
		
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		BufferedReader reader;
		
		//System.out.print("입력: ");
		reader = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(reader.readLine());
		
		for(int i=0; i<t; i++) {
			
			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			queue = new LinkedList<>();
			index = new LinkedList<>();
			
			st = new StringTokenizer(reader.readLine());
			
			for(int j=0; j<n ; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
				index.offer(j);
			}
			
			print();
		}
	}
	
	public static void print() {
		
		int max; // 현재 최우선 문서
		int cur; // 현재 문서
		int curindex; // 현재 인덱스
		int count = 1;
		
		while(!queue.isEmpty()) {
			
			max = Collections.max(queue);
			cur = queue.poll();
			curindex = index.poll();
			
			if(max == cur) {
				if(curindex == m) {
					System.out.println(count);
					break;
				}
				count++;
				
			} else {
				
				queue.offer(cur);
				index.offer(curindex);
			}
		}
		
	}
}

















