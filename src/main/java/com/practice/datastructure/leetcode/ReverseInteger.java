package com.practice.datastructure.leetcode;

import java.util.Arrays;
import java.util.BitSet;

public class ReverseInteger {

  public static void main(String[] args) {
    //System.out.println(removeDuplicates(input));
//    int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int[] input = { 1, 1, 2};
    //System.out.println(removeDuplicates(input));

    int[] numbers = new int[100];

    for(int i=0; i< 100; i++){
      numbers[i] = i==49 ? 0 : i+1;
    }

    //System.out.println(findMissingNumber(numbers));

    printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

    // two missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

    // three missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
  }

  private static int findMissingNumber(int[] numbers) {
    int expectedSum =  numbers.length/2 * (numbers[0] + numbers[numbers.length-1]);
    int actualSum = Arrays.stream(numbers).sum();
    return 5050-actualSum;
  }

  public static int reverse(int x) {
    int a = 0, n = 0;
    while (x != 0) {
      Integer.bitCount(x);
      a = x % 10;
      n = (n * 10) + a;
      x = x / 10;
    }

    return n;
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int a = 0, n = 0;
    while (x != 0) {
      Integer.bitCount(x);
      a = x % 10;
      n = (n * 10) + a;
      x = x / 10;
    }

    return n == x;

  }

  public static int removeDuplicates(int[] nums) {
    int i=0, j=0;
    for (; i < nums.length && j < nums.length;j++) {
      if(nums[i] != nums[j]){
        nums[i+1]=nums[j];
        i++;
      }
    }

    return i+1;
  }

  private static void printMissingNumber(int[] numbers, int count) {
    int missingCount = count - numbers.length;
    BitSet bitSet = new BitSet(count);

    for (int number : numbers) {
      bitSet.set(number - 1);
    }

    System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
        Arrays.toString(numbers), count);
    int lastMissingIndex = 0;

    for (int i = 0; i < missingCount; i++) {
      lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
      System.out.println(++lastMissingIndex);
    }

  }


}
