
package StringMethods;

import java.util.Arrays;
import java.util.Base64;
import java.util.Stack;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length())
			return s1;
		else
			return s2;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		String c = "";
		if(s.contains("underscores")) {
			for(int i=0;i<s.length();i++) {
				if((s.charAt(i)+"").equals(" "))
					c+="_";
				else
					c+=s.charAt(i);
					
			}
		} else {
			c=s;
		}
		return c;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		
		String f1=getLastName(s1).toLowerCase();
		String f2=getLastName(s2).toLowerCase();
		String f3=getLastName(s3).toLowerCase();
		
		
		while(f1.length()>0 && f2.length()>0 && f3.length()>0) {
			if(f1.compareTo(f2)<0 && f1.compareTo(f3)<0) {
				
				return format(s1);
			} else if(f2.compareTo(f1)<0 && f2.compareTo(f3)<0){
				
				return format(s2);
			} else if(f3.compareTo(f1)<0 && f3.compareTo(f1)<0) {
				
				return format(s3);
			}
		}
		return format(s1);
	}
	
	public static String getLastName(String s) {
		int x;
		x=0;
		while(s.charAt(x)==' ') x++;
		s=s.substring(x);
		
		x=0;
		while(s.charAt(x)!=' ') x++;
		return s.charAt(x+1)+"";
	}
	public static String format(String s) {
		int x;
		x=0;
		while(s.charAt(x)==' ') x++;
		s=s.substring(x);
		
		String t = "";
		for(int i=s.length()-1;i>=0;i--) {
			t+=s.charAt(i);
		}
		s=t;
		
		x=0;
		while(s.charAt(x)==' ') x++;
		s=s.substring(x);
		
		t = "";
		for(int i=s.length()-1;i>=0;i--) {
			t+=s.charAt(i);
		}
		s=t;
		
		return s;
	}
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>=49 && s.charAt(i)<=57)
				sum+=Integer.parseInt(s.charAt(i)+"");
		}
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int c = 0;
		while(s.indexOf(substring)!=-1) {
			c++;
			s=s.substring(s.indexOf(substring)+substring.length());
		}
		return c;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte)key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte)key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		String[] a = s.split(" ");
		int c=0;
		for(int i=0;i<a.length;i++) {
			a[i]=removePunct(a[i]);
			a[i]=reverse(reverse(a[i]).substring(0,a[i].indexOf(substring)+1));
			if(a[i].contains(substring)) {
				if(a[i].length()-substring.length()==a[i].indexOf(substring)) {
					
					c++;
				}
			}
		}
		return c;
	}
	public static String removePunct(String s) {
		String snew = "";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='.' &&s.charAt(i)!='–'&&s.charAt(i)!=','&&s.charAt(i)!='?'&&s.charAt(i)!='!'&&s.charAt(i)!=';'&&s.charAt(i)!=' '&&s.charAt(i)!=':')
				snew+=s.charAt(i);
		}
		return snew;
	}
	public static String reverse(String s) {
		
		Stack<Character> ack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='.' &&s.charAt(i)!='–'&&s.charAt(i)!=','&&s.charAt(i)!='?'&&s.charAt(i)!='!'&&s.charAt(i)!=';'&&s.charAt(i)!=' '&&s.charAt(i)!=':') {
				ack.push(s.charAt(i));
				
			}	
		}
		String t = "";
		while(ack.size()!=0)
		t+=ack.pop();
		return t;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int c = 0;
		int i = s.indexOf(substring)+substring.length();
		while(true) {
			if(s.charAt(i)== substring.charAt(0) && !s.substring(i+substring.length()).contains(substring))
				break;
			i++;
			c++;
			
		}
		return c;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		Stack<Character> ack = new Stack<Character>();
		String snew="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='.' &&s.charAt(i)!='–'&&s.charAt(i)!=','&&s.charAt(i)!='?'&&s.charAt(i)!='!'&&s.charAt(i)!=';'&&s.charAt(i)!=' '&&s.charAt(i)!=':') {
				ack.push(s.charAt(i));
				snew+=s.charAt(i);
			}	
		}
		String t = "";
		while(ack.size()!=0)
		t+=ack.pop();
		return snew.toLowerCase().equals(t.toLowerCase());
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
