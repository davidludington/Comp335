package luc.fm.palindrome;

import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class PalindromeProperties {

  // example: all strings of length 1 are palindromes
  
  @Property
  boolean allSingleCharStringsArePalindromes(@ForAll @StringLength(1) final String s) {
    return Palindrome.isPalindrome(s);
  }
  
  
  @Property
  boolean allStringLengthTwoSameChar(@ForAll @StringLength(2) final String s) {
    return Palindrome.isPalindrome(s) == (s.charAt(0) == s.charAt(1));
  }
  
  @Property
  boolean lessThanFive(@ForAll @StringLength(5) final String s){
    if((s.charAt(0) == s.charAt(4) && (s.charAt(1) == s.charAt(3)))){
      return Palindrome.isPalindrome(s);
    }
    return !Palindrome.isPalindrome(s);
  }
  
  @Property
  boolean isPalindromeWorks(@ForAll final String s) {
    return Palindrome.isPalindrome(s) == new StringBuilder(s).reverse().toString().equals(s);
  }
  

  // TODO extra credit: see README
  /*
  @Provide
  Arbitrary<String> nonPalindrone(int length){
    return "";
  }
  */
}
