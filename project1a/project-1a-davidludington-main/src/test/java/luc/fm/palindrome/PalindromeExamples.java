package luc.fm.palindrome;

import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class PalindromeExamples {

  @Example //1
  boolean testRadar() {
    return Palindrome.isPalindrome("radar");
  }

  @Example //2
  boolean testRadarC() {
    return Palindrome.isPalindromeIgnoreCase("Radar");
  }

  @Example //3
  boolean testRadarSp() {
    return Palindrome.isPalindromeIgnoreCaseAndSpaces("Rad a r");
  }

  @Example //4
  void testLidar() {
    assertFalse(Palindrome.isPalindrome("lidar"));
  }

  @Example //5
  void testLidarC() {
    assertFalse(Palindrome.isPalindromeIgnoreCase("LidAr"));
  }

  @Example //6
  void testLidarSp() {
    assertFalse(Palindrome.isPalindromeIgnoreCaseAndSpaces("li dar"));
  }

  @Example //7
  void testAbba(){
    assertTrue(Palindrome.isPalindrome("abba"));
  }

  @Example //8
  void testAbbaC(){
    assertTrue(Palindrome.isPalindromeIgnoreCase("aBbA"));
  }

  @Example //9
  void testAbbaSp(){
    assertTrue(Palindrome.isPalindromeIgnoreCaseAndSpaces("aB b A"));
  }

  @Example //10
  void testAppl() {
    assertFalse(Palindrome.isPalindrome("appl"));
  }

  @Example //11
  void testApplC() {
    assertFalse(Palindrome.isPalindromeIgnoreCase("APpl"));
  }

  @Example //12
  void testApplSp(){
    assertFalse(Palindrome.isPalindromeIgnoreCaseAndSpaces("A p pl"));
  }

  @Example //13
  void testRacecar() {
    assertTrue(Palindrome.isPalindrome("racecar"));
  }

  @Example //14
  void testRacecarC() {
    assertTrue(Palindrome.isPalindromeIgnoreCase("RaCecAr"));
  }

  @Example //15
  void testRacecarSp(){
    assertTrue(Palindrome.isPalindromeIgnoreCaseAndSpaces("Ra c e C aR"));
  }

  @Example //16
  void testHannah() {
    assertTrue(Palindrome.isPalindrome("hannah"));
  }

  @Example //17
  void testHannahC() {
    assertTrue(Palindrome.isPalindromeIgnoreCase("HanNAh"));
  }

  @Example //18
  void testHannahSp(){
    assertTrue(Palindrome.isPalindromeIgnoreCaseAndSpaces("Han N aH"));
  }

  @Example //19
  void testFoo() {
    assertFalse(Palindrome.isPalindrome("foo"));
  }

  @Example //20
  void testFooC() {
    assertFalse(Palindrome.isPalindromeIgnoreCase("FOo"));
  }

  @Example //21
  void testFooSp(){
    assertFalse(Palindrome.isPalindromeIgnoreCaseAndSpaces("F Oo"));
  }
}
