package security;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import common.Utils;

public class KeyPairGenerator {		
	
	
	public static void main(String[] args) throws Exception {
		receiver(generator());
	}

	public static BigInteger[] generator() throws Exception {
		java.security.KeyPairGenerator keyGenerator = java.security.KeyPairGenerator.getInstance("RSA");
		keyGenerator.initialize(1024);
		KeyPair keyPair = keyGenerator.generateKeyPair();
		System.out.println("PrivateKey:" + Utils.toHexString(keyPair.getPrivate().getEncoded()));
		System.out.println("PublicKey:" + Utils.toHexString(keyPair.getPublic().getEncoded()));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		Class spec = Class.forName("java.security.spec.RSAPublicKeySpec");
		RSAPublicKeySpec publicKeySpec = (RSAPublicKeySpec) keyFactory.getKeySpec(keyPair.getPublic(), spec);
		BigInteger modulus = publicKeySpec.getModulus();
		BigInteger exponent = publicKeySpec.getPublicExponent();
		System.out.println("Modulus:" + modulus);
		System.out.println("Exponent:" + exponent);
		return new BigInteger[] { modulus, exponent };
	}

	public static void receiver(BigInteger[] spec) throws Exception{
		RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(spec[0], spec[1]);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
		System.out.println("PublicKey:" + Utils.toHexString(publicKey.getEncoded()));
	}
	
}
