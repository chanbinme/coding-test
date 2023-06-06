import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];
        HashMap<Character, Integer> match = new HashMap<>();

        for ( int i = 'A' ; i <= 'A'+25 ; i++){

            int min = 101;
            for ( int j = 0 ; j < keymap.length ; j++){
                int idx = index((char)i, keymap[j]);
                if ( min > idx && idx != -1 ){
                    min = idx;
                }
            }
            if ( min != 101)
                match.put((char)i, min);
        }

        for ( int i = 0 ; i < targets.length; i++ ){
            int sum = 0;
            for ( int j = 0 ; j < targets[i].length() ;j++){
                char c = targets[i].charAt(j);

                if ( match.containsKey(c) ){
                    sum += match.get(c);   
                }
                else{
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;   
        }

        return answer;
    }
    public int index(char c , String s ){
        for ( int i = 0 ; i < s.length() ;i++){
            if ( s.charAt(i) == c ) return i+1;
        }
        return -1;
    }
}