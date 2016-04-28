package security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import common.Utils;

public class KStore {

	public static String keyStorePath = "/home/cxx/dev/java/workspace/JavaDemo/src/my.ks";
	public static String keyStorePasswd = "keyStorePwd";
	public static String secretKeyAlias = "keyAlias";
	public static String secretKeyPasswd = "keyAlias";

	public static void main(String[] args) throws Exception {
		generateKeyStore();
		SecretKey secretKey = readSecretKeyFromKeyStore();
		System.out.println(Utils.toHexString(secretKey.getEncoded()));
	}

	public static SecretKey readSecretKeyFromKeyStore() throws Exception {
		File f = new File(keyStorePath);
		if (!f.exists()) {
			System.out.println("keystore file not exist");
		}
		KeyStore ks = KeyStore.getInstance("JCEKS");
		ks.load(new FileInputStream(f), keyStorePasswd.toCharArray());
		SecretKeyEntry secretKeyEntry = (SecretKeyEntry) ks.getEntry(secretKeyAlias,
				new KeyStore.PasswordProtection(secretKeyPasswd.toCharArray()));
		return secretKeyEntry.getSecretKey();
	}

	public static void generateKeyStore() throws Exception {
		File f = new File(keyStorePath);
		if (f.exists()) {
			return;
		}
		// JKS类型的KeyStore只支持存储非对称加密的秘钥，JCEKS支持对称加密秘钥
		KeyStore ks = KeyStore.getInstance("JCEKS");
		ks.load(null, null);
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(keyGenerator.generateKey());
		KeyStore.PasswordProtection passwordProtection = new KeyStore.PasswordProtection(secretKeyPasswd.toCharArray());
		ks.setEntry(secretKeyAlias, secretKeyEntry, passwordProtection);
		ks.store(new FileOutputStream(f), keyStorePasswd.toCharArray());
	}

}
