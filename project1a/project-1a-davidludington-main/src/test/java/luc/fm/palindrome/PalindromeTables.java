package luc.fm.palindrome;

import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class PalindromeTables {

  @Data
  Iterable<Tuple.Tuple2<String, Boolean>> palindromeExamples() {
    return Table.of(
      Tuple.of("a", true),
      Tuple.of("aa", true),
      Tuple.of("ab", false),
      Tuple.of("mom", true),
      Tuple.of("dad", true),
      Tuple.of("kid", false),
      Tuple.of("abba", true),
      Tuple.of("appl", false),
      Tuple.of("uncle", false),
      Tuple.of("radar", true),
      Tuple.of("lidar", false),
      Tuple.of("hannah", true)
    );
  }

  @Data
  Iterable<Tuple.Tuple2<String, Boolean>> palindromeExamplesCaseInsensitive() {
    return Table.of(
      Tuple.of("a", true),
      Tuple.of("Aa", true),
      Tuple.of("aB", false),
      Tuple.of("mOM", true),
      Tuple.of("Dad", true),
      Tuple.of("Kid", false),
      Tuple.of("aBbA", true),
      Tuple.of("aPpL", false),
      Tuple.of("uNcLe", false),
      Tuple.of("rAdAr", true),
      Tuple.of("lIdAr", false),
      Tuple.of("haNnaH", true)
    );
  }

  @Data
  Iterable<Tuple.Tuple2<String, Boolean>> palindromeExamplesCaseInsensitiveSpacesIgnored() {
    return Table.of(
      Tuple.of("a ", true),
      Tuple.of("A a", true),
      Tuple.of("Ab", false),
      Tuple.of("m O m", true),
      Tuple.of("da D", true),
      Tuple.of("K id", false),
      Tuple.of("ab B a", true),
      Tuple.of("aP pl", false),
      Tuple.of("u N cle", false),
      Tuple.of("r A dar", true),
      Tuple.of("lid  Ar", false),
      Tuple.of("haNNah", true)
    );
  }

  @Property
  @FromData("palindromeExamples")
  boolean isPalindromeWorks(@ForAll final String arg, @ForAll final boolean result) {
    return Palindrome.isPalindrome(arg) == result;
  }

  
  @Property
  @FromData("palindromeExamples")
  boolean isPalindromeIgnCaseWorks(@ForAll final String arg, @ForAll final boolean result) {
    return Palindrome.isPalindromeIgnoreCase(arg) == result;
  }

  @Property
  @FromData("palindromeExamples")
  boolean isPalindromeIgnCaseAndSpacesWorks(@ForAll final String arg, @ForAll final boolean result) {
    return Palindrome.isPalindromeIgnoreCaseAndSpaces(arg) == result;
  }

  
  @Property
  @FromData("palindromeExamplesCaseInsensitive")
  boolean isPalindromeIgnCaseWorks2(@ForAll final String arg, @ForAll final boolean result) {
    return Palindrome.isPalindromeIgnoreCase(arg) == result;
  }

  @Property
  @FromData("palindromeExamplesCaseInsensitive")
  boolean isPalindromeIgnCaseAndSpacesWorks2(@ForAll final String arg, @ForAll final boolean result) {
    return Palindrome.isPalindromeIgnoreCaseAndSpaces(arg) == result;
  }

  
  @Property
  @FromData("palindromeExamplesCaseInsensitiveSpacesIgnored")
  boolean isPalindromeIgnCaseAndSpacesWorks3(@ForAll final String arg, @ForAll final boolean result) {
    return Palindrome.isPalindromeIgnoreCaseAndSpaces(arg) == result;
  }
}
