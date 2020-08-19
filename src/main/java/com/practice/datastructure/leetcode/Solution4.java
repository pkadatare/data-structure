package com.practice.datastructure.leetcode;

public class Solution4 {

  public static void main(String[] args) {
    /*int[] nums1 = {1, 3};
    int[] nums2 = {2};*/

    int[] nums1 = {1, 2};
    int[] nums2 = {3, 2};

    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int a = 0, b = 0, c = 0;
    int n = nums1.length + nums2.length;
    int[] num3 = new int[n];

    while (c < n) {

      if (a < nums1.length && b < nums2.length) {
        if (nums1[a] > nums2[b]) {
          num3[c++] = nums2[b++];
        } else {
          num3[c++] = nums1[a++];
        }
      } else if (a < nums1.length) {
        num3[c++] = nums1[a++];
      } else if (b < nums2.length) {
        num3[c++] = nums2[b++];

      }

    }
    return n % 2 == 0 ? ((double)(num3[(n-1)/2]+ num3[n/2])/2): num3[(n / 2)];

  }

}
