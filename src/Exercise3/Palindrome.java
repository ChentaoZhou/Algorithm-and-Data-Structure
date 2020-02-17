package Exercise3;

public class Palindrome {
	
	public static void main(String[] args) {
		char[] c = {'s','s', 'a','d','a','s','s'};
		System.out.println(palindrome(c));
	}
	
	public static boolean palindrome(char c[]) {
		int checkNum = c.length % 2;
		int midPoint = c.length /2;
		if(checkNum == 1) {
			int left = midPoint -1;
			int right = midPoint +1;
			
			while(left>=0 && right <c.length) {
				if(c[left] == c[right]) {
					left--;
					right++;
				}else return false;
			}
			return true;
		}
		if(checkNum ==0) {
			int left = midPoint-1;
			int right = midPoint;
			while(left>=0 && right <c.length) {
				if(c[left] == c[right]) {
					left--;
					right++;
				}else return false;
			}
			return true;
		}
		return false;
	}
}
