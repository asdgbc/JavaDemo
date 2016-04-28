package security;

import java.security.MessageDigest;

import common.Utils;

public class MD {
	public static void main(String[] args) throws Exception {
		
		// MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("wakaka".getBytes());
		byte[] mds = md.digest();
		System.out.println(Utils.toHexString(mds));

		// SHA1
		MessageDigest sha1Digest = MessageDigest.getInstance("SHA1");
		sha1Digest.update("wakaka".getBytes());
		System.out.println(Utils.toHexString(sha1Digest.digest()));

		// SHA-512
		MessageDigest sha512Digest = MessageDigest.getInstance("SHA-512");
		sha512Digest.update("wakaka".getBytes());
		System.out.println(Utils.toHexString(sha512Digest.digest()));
		
	}
}
