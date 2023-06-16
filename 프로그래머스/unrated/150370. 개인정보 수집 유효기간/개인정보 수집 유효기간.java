import java.util.*;

class Solution {
    int len;
    public int[] solution(String today, String[] terms, String[] privacies) {

        len = privacies.length;
        
        HashMap<String, Integer> terM = new HashMap<>();
        int[] expireT = new int[len];
        
        ArrayList<Integer> list = new ArrayList<>();
        int now = getDays(today);
        for(String x : terms){
            terM.put(x.split(" ")[0], Integer.parseInt(x.split(" ")[1]) * 28);
        }
        
        for(int i =0 ;i < len ;i++){
            int day = getDays(privacies[i].split(" ")[0]);
            String key = privacies[i].split(" ")[1];
            expireT[i] = day + terM.get(key);

            if(expireT[i] <= now){
                list.add(i+1);
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
    public int getDays(String x){
        int y = Integer.parseInt(x.split("\\.")[0]);
        int m = Integer.parseInt(x.split("\\.")[1]);
        int d = Integer.parseInt(x.split("\\.")[2]);
        
        return d + m * 28 + (y-2000) * 12 * 28;
    }
}