package Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SanggeunsTrip_9372 {

    public static void main(String[] args) throws Exception {
        int N=0, M=0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(reader.readLine(), " ");
            }
            stringBuilder.append(N-1 + "\n"); // 간선의 갯수 = 정점의 개수 -1
        }
        System.out.print(stringBuilder);
    }
}
