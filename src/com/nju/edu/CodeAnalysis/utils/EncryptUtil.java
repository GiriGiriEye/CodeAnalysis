package com.nju.edu.CodeAnalysis.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
	private static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
	
	public static String encodeByMD5(String in) {
		String out = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] results = md.digest(in.getBytes()); 
			out = byteArrayToHexString(results);
			return out;
		}catch(NoSuchAlgorithmException nae) {
			nae.printStackTrace();
		}
		return out;
	}
	
	private static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }
	
	private static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
