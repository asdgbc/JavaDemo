package security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

import common.Utils;

public class Chiper {
	public static PublicKey publicKey;
	public static PrivateKey privateKey;

	public static void main(String[] args) throws Exception {
		if (publicKey == null || privateKey == null) {
			generateKeyPair();
		}
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		String rawString = "wakaka";
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		System.out.println("Begin ENCRYPT");
		byte[] encryptedData = cipher.update(rawString.getBytes());
		byte[] encryptedData1 = cipher.doFinal();
		byte[] finalEncrpytedData = concateTwoBuffers(encryptedData, encryptedData1);
		byte[] iv = cipher.getIV();
		System.out.println(Utils.toHexString(finalEncrpytedData));

		System.out.println("Begin DECRYPT");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		cipher.update(finalEncrpytedData);
		String deString = new String(cipher.doFinal());
		System.out.println(deString);
	}

	public static byte[] concateTwoBuffers(byte[] first, byte[] second) {
		byte[] fin = new byte[first.length + second.length];
		for (int i = 0; i < fin.length; i++) {
			if (i < first.length) {
				fin[i] = first[i];
			} else {
				fin[i] = second[i - first.length];
			}
		}
		return fin;
	}

	public static void generateKeyPair() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		publicKey = keyPair.getPublic();
		privateKey = keyPair.getPrivate();
	}

}
