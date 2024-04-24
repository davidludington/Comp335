package luc.fm.palindrome;

import java.util.function.Predicate;

public class Main {

  public static void main(final String[] args) {
    final var arg = String.join(" ", args);
    System.out.println("checking " + arg);
    printResult(arg, Palindrome::isPalindrome, "a palindrome");
    printResult(arg, Palindrome::isPalindromeIgnoreCase, "a case-insensitive palindrome");
    printResult(arg, Palindrome::isPalindromeIgnoreCaseAndSpaces, "a case-intensitive palindrome when ignoring spaces");
  }

  private static void printResult(final String arg, final Predicate<String> pred, final String what) {
    System.out.print(arg);
    System.out.print(pred.test(arg) ? " is " : " is not ");
    System.out.print(what);
    System.out.println(".");
  }
}
