package luc.fm.palindrome;

public enum Palindrome {;


  public static boolean isPalindrome(final String arg) {
    if (arg.length() <= 1) {
      return true;
    }
    
    int i = 0, j = arg.length() - 1;

    while(i < j){
      if(arg.charAt(i) != arg.charAt(j)) return false;

      i++;
      j--;
    }
    return true;

  }

  public static boolean isPalindromeIgnoreCase(final String arg) {
    return isPalindrome(arg.toLowerCase());
  }

  public static boolean isPalindromeIgnoreCaseAndSpaces(final String arg) {
    return isPalindrome(arg.toLowerCase().replaceAll("\\s", ""));
  }
}
