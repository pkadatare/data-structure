package com.practice.datastructure.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 *https://leetcode.com/problems/two-sum/submissions/
 */
class Solution {

  public static void main(String[] args) {
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target)));
    System.out.println(Arrays.toString(twoSum2(nums, target)));
    System.out.println(10%6);
  }


  /**
   * Brute Force
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[]{i, j};
        }
      }
    }

    throw new IllegalArgumentException("No two sum solution");
  }

  /**
   * Two-pass Hash Table
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum2(int[] nums, int target) {

    Map<Integer, Integer> items = IntStream
        .range(0, nums.length).boxed().collect(Collectors.toMap(i -> nums[i], i -> i));
    for (int i = 0; i < items.size(); i++) {
      int complement = target - nums[i];
      if (items.containsKey(complement) && items.get(complement) != i) {
        return new int[]{i, items.get(complement)};
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }


  /**
   * One-pass Hash Table
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum3(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public int getIntValue(ListNode node){
    StringBuffer buffer = new StringBuffer();

    while(node != null){
      buffer.append(node.val);
    }


    return Integer.valueOf(buffer.reverse().toString());
  }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }