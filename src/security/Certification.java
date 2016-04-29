package security;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import common.Utils;


public class Certification {
	public static void main(String[] args) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("JKS");
		File storeFile = new File("/home/cxx/dev/java/workspace/JavaDemo/src/mykeystore.jks");
		if (!storeFile.exists()) {
			return ;
		}
		keyStore.load(new FileInputStream(storeFile), null);
		PrivateKey privateKey = (PrivateKey)keyStore.getKey("cxx", "123456".toCharArray());
		System.out.println(Utils.toHexString(privateKey.getEncoded()));
		Certificate[] chain = keyStore.getCertificateChain("cxx");
		X509Certificate certificate = (X509Certificate)chain[0];
		PublicKey publicKey = certificate.getPublicKey();
		System.out.println(Utils.toHexString(publicKey.getEncoded()));
	}

}
