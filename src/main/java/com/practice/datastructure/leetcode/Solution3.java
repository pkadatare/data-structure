package com.practice.datastructure.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

  public static void main(String[] args) {

    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbbbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));

  }

  public static int lengthOfLongestSubstring1(String s) {
    char[] str = s.toCharArray();
    int max = 0, subStringLength = 0;
    Map<Character, Integer> map = new HashMap();
    for (int i = 0; i < s.length(); i++) {

      subStringLength = 0;
      map.clear();
      for (int j = i; j < s.length(); j++) {
        char c = str[j];
        if (map.containsKey(c)) {
          break;
        } else {
          subStringLength++;
          map.put(c, j);
        }
        if (max < subStringLength) {
          max = subStringLength;
        }
      }
    }
    return max;
  }

  public static int lengthOfLongestSubstring2(String s) {
    int ans = 0, i = 0, j = 0, n = s.length();
    Set<Character> set = new HashSet();
    while (i < n && j < n) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, set.size());
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }

  public static int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>(); // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return ans;
  }

}
