class Solution {
    public boolean solution(String s) {        
        // 문자열 길이가 4 혹은 6인지 체크
        if(!isLengthFourOrSix(s)) {
            return false;
        }
        
        // 문자열이 숫자로만 구성돼있는지 체크
        if(!isOnlyNumbers(s)) {
            return false;
        };
        
        return true;
    }
    
    boolean isLengthFourOrSix(String s) {
        return s.length() == 4 || s.length() == 6;
    }
    
    boolean isOnlyNumbers(String s) {
        try {
            Integer.valueOf(s);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}