/*
Reference - 
	Open Web Application Security Project
	https://www.owasp.org/index.php/Hashing_Java

Reference -
	Stack Overflow Answer
	http://stackoverflow.com/questions/18142745/how-do-i-generate-a-salt-in-java-for-salted-hash
*/
package calendar.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;

public class PasswordUtility {

	public static byte[] generateSalt() 
	{
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[32];
		random.nextBytes(salt);
		return salt;
	}
	
	public static byte[] generatePasswordHash(byte[] salt, String password) 
	{
		try 
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.reset();
			md.update(salt);
			byte[] hash = md.digest(stringToBytes(password));
			return hash;
		} 
		catch (NoSuchAlgorithmException e) 
		{
			throw new RuntimeException(e);
		}
	}
	
	public static String ByteToString(byte[] input) 
	{
		return org.apache.commons.codec.binary.Base64.encodeBase64String(input);
	}
	
	public static byte[] stringToBytes(String input) 
	{
		
		//Check to see if the input String is already base-64 encoded instead of the normal UTF-8
		if (Base64.isBase64(input))
		{
			return Base64.decodeBase64(input);
		}
		else
		{
			return Base64.encodeBase64(input.getBytes());
		}
	}
}
