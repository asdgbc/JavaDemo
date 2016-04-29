package security;

import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import common.Utils;

public class SG {

	private static PublicKey publicKey;
	private static PrivateKey privateKey;

	public static void main(String[] args) throws Exception {
		if (publicKey == null || privateKey == null) {
			generaterKeyPair();
		}
		// 使用Signature进行md和加密
		// Signature signature = Signature.getInstance("SHA224withRSA");
		// SecureRandom random = new SecureRandom();
		// signature.initSign(privateKey, random);
		// signature.update("wakaka".getBytes());
		// byte[] sign = signature.sign();
		// System.out.println("Sign:" + Utils.toHexString(sign));
		// signature = Signature.getInstance("SHA224withRSA");
		// signature.initVerify(publicKey);
		// signature.update("wakaka".getBytes());
		// System.out.println(signature.verify(sign));

		// A4DE47858445A5094C0C7A51C0D36DB4999FB905325208A43631F6A39FCCC7E3E5390F6DC0B20FC289A76A3925D29D27CFE7B48569F610C341CDDF23ADEA9607DEB2A6356D2D861F051B27EB0C92CC9E7891270317CD53D3AD0DEE1278C192D3CD17BEB20692530C7762C886129BBB144582DFFAC08E432C09C29DE092FB0F9347D78D3428938551C56B4B75F7703706D5BB7968AE27164B569C2A528A3AF191232CBFC2A04D905C131603EE75EABE4561B9A4AA563FD3CF8D242F3005CB8485E88439587A828C4969B650CFBD1EE7AE3F1EB64E7BC60A5D886A26EF91FCA0B005234E88CB2379127810D392213B49C651EEC0810691E29ACDBF5B665B6651C0

		String msg = "wakaka";

		// 手动md和加密
		// 获得消息摘要
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-224");
		byte[] md = messageDigest.digest(msg.getBytes());
		System.out.println("MDString:\n" + Utils.toHexString(md));

		// 使用私钥加密
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, (RSAPrivateCrtKey) privateKey);
		cipher.update(md);
		byte[] encryptedData1 = cipher.doFinal();
		System.out.println("ENCRYPTED:\n" + Utils.toHexString(encryptedData1));

		// 使用公钥解密
		cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, (RSAPublicKey) publicKey);
		byte[] updated = cipher.update(encryptedData1);
		byte[] decrypt = cipher.doFinal();
		System.out.println(Utils.toHexString(decrypt));
	}

	private static void generaterKeyPair() throws Exception {
		java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		publicKey = keyPair.getPublic();
		privateKey = keyPair.getPrivate();
	}

}
