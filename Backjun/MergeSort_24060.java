package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort_24060 {

    static int[] arr; // 입력받은 배열
    static int[] temp; // 정렬 후 저장 할 배열
    static int count = 0; // 누적 저장 횟수
    static int k; // 저장 횟수
    static int result = -1; //결과 저장(실패 시 -1)

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열의 크기
        k = Integer.parseInt(st.nextToken()); // 저장 횟수

        arr = new int[n];
        temp = new int[n];

        st = new StringTokenizer(reader.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergesort(0, n-1);
        System.out.println(result);
        

    }

    private static void mergesort(int start, int end) {
        if(count > k) return;
        if(start < end){
            int middle = (end + start) / 2 ;
            mergesort(start, middle);
            mergesort(middle+1, end);
            mergesort(start, middle, end);

        }
    }

    private static void mergesort(int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int t = 0;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= middle) {
            temp[t++] = arr[i++];
        }

        while (j <= end) {
            temp[t++] = arr[j++];
        }

        t = 0;
        i = start;

        while (i <= end) {
            count++;
            if (count == k) {
                result = temp[t];
                break;
            }
            arr[i++] = temp[t++];
        }
    }
}
