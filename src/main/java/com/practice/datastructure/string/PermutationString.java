package com.practice.datastructure.string;

import java.util.Arrays;

public class PermutationString {

  public static int NO_OF_CHAR = 256;

  public static void main(String[] args) {
    System.out.print(arePermutation3("geeksforgeekz", "forgeeksgeek"));
  }

  private static boolean arePermutation(char[] first, char[] second) {
    if(first.length != second.length)
      return false;
    Arrays.sort(first);
    Arrays.sort(second);
    return Arrays.equals(first, second);
  }

  private static boolean arePermutation2(String first, String  second) {
    if(first.length() != second.length())
      return false;
    int[] f = new int[NO_OF_CHAR];
    Arrays.fill(f, 0);
    int[] s = new int[NO_OF_CHAR];
    Arrays.fill(s, 0);
    char[] fArray = first.toCharArray();
    char[] sArray = second.toCharArray();

    for(int i = 0; i <first.length(); i++){
      f[fArray[i]]++;
      s[sArray[i]]++;
    }

    for(int i=0; i<NO_OF_CHAR; i++){
      if(f[i] != s[i])
        return false;
    }
    return true;
  }

  private static boolean arePermutation3(String first, String  second) {
    if(first.length() != second.length())
      return false;
    int[] f = new int[NO_OF_CHAR];
    Arrays.fill(f, 0);
    char[] fArray = first.toCharArray();
    char[] sArray = second.toCharArray();

    for(int i = 0; i <first.length(); i++){
      f[fArray[i]]++;
      f[sArray[i]]--;
    }

    for(int i=0; i<NO_OF_CHAR; i++){
      if(f[i] != 0)
        return false;
    }
    return true;
  }

}
