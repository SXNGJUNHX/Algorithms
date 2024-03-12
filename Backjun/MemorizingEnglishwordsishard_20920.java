package Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class MemorizingEnglishwordsishard_20920 {

	public static void main(String[] args) throws IOException {
		
		int n = 0; //단어 갯수
		int m = 0; //단어 길이
		
		
		BufferedReader reader;
		BufferedWriter writer;
		StringTokenizer st;
		HashMap<String, Integer> list =  new HashMap<>();
		//ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "pineapple", "peach"));
		reader = new BufferedReader (new InputStreamReader(System.in));
		writer = new BufferedWriter (new OutputStreamWriter(System.out));
		
		writer.write("입력: ");
		writer.flush();
		
		st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(reader.readLine());
			list.put(st.nextToken(),i); // 단어를 ArrayList에 저장
			
		}
		
		
		
		
	
	}
}
