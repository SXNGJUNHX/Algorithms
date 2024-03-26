package Backjun;

import java.io.*;
import java.util.StringTokenizer;

public class Resignation_14501 {

    public static void main(String[] args) throws IOException {
        
        int count=0;
        int t[];
        int p[];
        int dp[];

        BufferedReader reader;
        BufferedWriter writer;
        StringTokenizer st;

        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        count = Integer.parseInt(reader.readLine());

        t = new int[count];
        p = new int[count];



        for(int i=0; i<count; i++){
            st = new StringTokenizer(reader.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[count+1];

        for(int i=0; i<count; i++){
            if(i+t[i] <= count){
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[count]);
    }
}












