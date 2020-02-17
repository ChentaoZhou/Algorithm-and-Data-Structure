package Exercise3;

public class SuperPalindrome {

	public static boolean sPalindrome(String s) {
		s=s.replaceAll("\\s", "").replaceAll("\\pP", "").toLowerCase();
		return Palindrome.palindrome(s.toCharArray());
	}
	public static void main(String[] args) {
		String s = "Madam, I'm Adam.";
		System.out.println(sPalindrome(s));
	}
}
