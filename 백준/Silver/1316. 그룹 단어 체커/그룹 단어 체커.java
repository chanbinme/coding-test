import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count  = 0;

        for(int  i = 0; i  < N; i++){
            if(checkStr(br.readLine())){
                count++;
            }
        }
        br.close();
        System.out.println(count);
    }

    static boolean checkStr(String str){
        //boolean형 배열에 초기값을 주지 않으면 모두 false로 들어간다.

        boolean[] checkAlpha = new boolean[26]; //입력받은 값이 영어임으로 영어의 개수만큼 배열 생성
        int prev = -1; //이전 문자의 인덱스값을 저장하는 변수

        for(int i = 0; i < str.length(); i++){
            int now = str.charAt(i); //현재의 문자의 아스키 코드값을 저장

            if(prev != now){ //이전 문자와 i번째 문자가 같지 않다면
                if(checkAlpha[now-97] == false){ //false라는 것은 문자가 처음 나온 문자라는 것!
                    checkAlpha[now-97] = true;
                    prev = now; 
                }else{
                    return false; 
                }
            }else{ //만약 이전 문자와 지금의 문자가 같다면 => 연속된 문자이므로 그냥 계속 반복문을 진행
                continue;
            }
        }
        return true; 
    }
}