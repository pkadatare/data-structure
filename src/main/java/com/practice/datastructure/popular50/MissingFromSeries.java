package com.practice.datastructure.popular50;

import java.util.Arrays;
import java.util.BitSet;

public class MissingFromSeries {

  public static void main(String[] args) {

    // one missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

    // two missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 10}, 10);

    // three missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

    // four missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

    // Only one missing number in array
    int[] iArray = new int[]{1, 2, 3, 5};
    int missing = getMissingNumber(iArray, 5);
    System.out.printf("Missing number in array %s is %d %n",
        Arrays.toString(iArray), missing);

  }



  private static void printMissingNumber(int[] numbers, int count) {
    int missingCount = count - numbers.length;

    BitSet bitSet = new BitSet(count);

    for(int number : numbers){
      bitSet.set(number-1);
    }
    int missingNumber = 0;
    for(int i =0; i <missingCount; i++){
      missingNumber = bitSet.nextClearBit(missingNumber);
      System.out.print(++missingNumber);
    }
  }

  private static int getMissingNumber(int[] numbers, int totalCount) {
    int expectedSum = (totalCount *(numbers[0] + totalCount))/2;
    int totalSum = Arrays.stream(numbers).sum();
    return expectedSum - totalSum;

  }
}




