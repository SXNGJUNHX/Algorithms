package Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MemorizingEnglishwordsishard_20920 {

	public static void main(String[] args) throws IOException {
		
		int n = 0; //단어 갯수
		int m = 0; //단어 길이
		String temp[];
		
		BufferedReader reader;
		BufferedWriter writer;
		StringTokenizer st;
		StringBuilder builder;
		List<String> result;
		
		reader = new BufferedReader (new InputStreamReader(System.in));
		writer = new BufferedWriter (new OutputStreamWriter(System.out)); 
		builder = new StringBuilder();
		
		writer.write("입력: ");
		writer.flush();
		
		st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 입력받을 단어의 수
		m = Integer.parseInt(st.nextToken()); // 출력할 단어의 길이
		
		temp = new String[n]; // 단어 저장할 배열
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(reader.readLine());
			temp[i] = st.nextToken();
			
		}
		
		result = calculate(temp);
		
		for(int i=0; i<result.size(); i++) {
			if(result.get(i).length() < m) {
				continue;
			}
			
			builder.append(result.get(i) + "\n");
		}
		
		System.out.print(builder);
		
		
		writer.close();
		reader.close();
	
	}
	
	//조건 1~3을 처리해서 배열을 반환하는 메소드
	private static List<String> calculate(String[] temp) {
		Map<String, Integer> word = new HashMap<>();
		
		for(int i=0; i<temp.length; i++) {
			if(word.containsKey(temp[i])) { // 중복된 Key, Value 1 증가
				word.put(temp[i], word.get(temp[i])+1);
			} else {
				word.put(temp[i], 1); // 처음 나오는 Key
			}
		}
		
		// Key값이 해당 영단어만 뽑은 List
		List<String> wordList = word.keySet().stream().collect(Collectors.toList());
		
		wordList.sort((o1, o2) -> {
			int c1 = word.get(o1); // 빈도수
			int c2 = word.get(o2); // 빈도수
			
			if(c1==c2) { // 조건1 : 빈도가 같다
				if(o1.length() == o2.length()) { // 조건2 : 길이가 같다
					return o1.compareTo(o2); // 3. 사전 순으로 배치
				}
				return o2.length() - o1.length();// 2.해당 단어의 길이가 길수록 앞에 배치
			}
			return c2 - c1; // 1. 자주 나오는 단어 일 수록 앞에 배치
		});
		
		return wordList;
	}
}















