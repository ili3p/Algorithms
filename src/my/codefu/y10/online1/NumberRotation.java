package my.codefu.y10.online1;

public class NumberRotation {
	public static int count(int N) {

		String binary= Integer.toBinaryString(N);
		if(binary.contains("0"))
				return binary.length();
		else
			return 1;
	}

	public static void main(String[] args) {
		System.out.println(count(1000000));
	}
}
