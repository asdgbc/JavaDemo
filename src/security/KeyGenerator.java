package security;

import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;

import common.Utils;

public class KeyGenerator {
	public static void main(String[] args) throws Exception {
		receiver(generator());
	}

	private static byte[] generator() throws Exception {
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance("DES");
		kg.init(56);
		SecretKey secretKey = kg.generateKey();
		System.out.println(Utils.toHexString(secretKey.getEncoded()));
		return Base64.getEncoder().encode(secretKey.getEncoded());
	}

	private static void receiver(byte[] keyInBase64) throws Exception {
		byte[] encodedKey = Base64.getDecoder().decode(keyInBase64);
		SecretKeySpec keySpec = new SecretKeySpec(encodedKey, "DES");
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		System.out.println(Utils.toHexString(secretKey.getEncoded()));
	}

}
