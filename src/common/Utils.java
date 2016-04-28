package common;

public class Utils {

	public static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String toHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(HEX[bytes[i] & 0x0f]).append(HEX[(bytes[i] >> 4) & 0x0f]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(toHexString("wakaka".getBytes()));
		// byte i = 0x10;
		// System.out.println(i);
		// System.out.println(i>>4);
	}
}
