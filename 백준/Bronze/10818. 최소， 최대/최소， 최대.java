import java.io.*;
import java.util.Arrays;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String z = br.readLine(); // 첫번째 입력 받고 안쓸거임
        String sr = br.readLine(); // 문자 입력
        
        String[] arr = sr.split(" "); // 공백 기준으로 문자열을 분리하여 문자형 배열에 선언
        int[] intArr = new int[arr.length]; // arr 길이만큼의 정수형 배열 생성
        
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]); // arr 배열의 값을 정수형으로 변환하여 intArr에 선언
        }
        
        int min = Arrays.stream(intArr).min().getAsInt(); // intArr에서 가장 큰 값 호출
        int max = Arrays.stream(intArr).max().getAsInt(); // intArr에서 가장 작은 값 호출

        bw.write(min + " " + max); // min, max 출력
        bw.close(); // buffered 닫기
    }
}