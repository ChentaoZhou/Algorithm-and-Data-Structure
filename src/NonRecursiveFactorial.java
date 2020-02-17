
public class NonRecursiveFactorial {
	public static void main(String[] args) {
		int n = 5;
		int result = n;
		
		while(n>1) {
			result *=n-1;
			n--;
		}
		System.out.println(result);
	}
}
