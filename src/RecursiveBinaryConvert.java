
public class RecursiveBinaryConvert {
	static String result;
	public static void main(String[] args) {
		result = "";
		System.out.println(binaryConvert(243));

	}
	public static String binaryConvert(int n) {
		if(n==0) return result;
		if(n>0) {
			String r = ""+n%2;
			n = n/2;
			return binaryConvert(n)+r;
		}
		return null;
	}
}
