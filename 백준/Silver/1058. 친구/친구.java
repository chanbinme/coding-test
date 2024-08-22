import java.io.*;
import java.util.*;

public class Main {
	
	public static class Friend {
		int number;
		Set<Integer> one, two;
		
		public Friend(int n, List<Integer> o) {
			number = n;
			
			one = new LinkedHashSet<>(); 
			two = new LinkedHashSet<>(); 
			
			for (int i = 0; i < o.size(); i++) {
				one.add(o.get(i));
			}
		}
	}
	
	static int n;
	static List<Friend> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		
		char[] arr;
		List<Integer> friend;
		list = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			arr = br.readLine().toCharArray();
			
			friend = new LinkedList<>();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == 'Y') {
					friend.add(j);
				}
			}
			
			list.add(new Friend(i, friend));
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			count = Math.max(count, twoFriend(i));
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int twoFriend(int index) {
		for (int n1 : list.get(index).one) {
			for (int n2 : list.get(n1).one) {
				if (n2 != index) {
					list.get(index).two.add(n2);
				}
			}
		}
		
		Set<Integer> sum = new LinkedHashSet<>();
		for (int o : list.get(index).one) {
			sum.add(o);
		}
		
		for (int t : list.get(index).two) {
			sum.add(t);
		}
		
		return sum.size();
	}
}