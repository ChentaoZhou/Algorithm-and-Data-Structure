
public class BinaryConvert {
	static String result ;
	public static void main(String[] args) {
		result = "";
		System.out.println(binaryConvert(243));
	}
	
	public static String binaryConvert(int n) {
		while(n>0) {
			String r = ""+n%2;
			result = r+result;
			n = n/2;
		}
		return result;
	}
}
