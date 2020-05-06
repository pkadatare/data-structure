package com.practice.datastructure.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class UniqueCharacter {

  static int CHAR_MAX = 256;

  public static void main(String[] args) {
    System.out.print(isUniqueCharacters4("YesNo"));
  }

  private static boolean isUniqueCharacters1(String str) {
    return !str.chars().anyMatch(
        e -> Collections.frequency(str.chars().boxed().collect(Collectors.toList()), e) > 1);

  }

  private static boolean isUniqueCharacters2(String str) {
    Map<Integer, Integer> map = new HashMap<>();
    AtomicBoolean isUnique = new AtomicBoolean(true);
    str.chars().forEach(e ->
    {
      if (map.containsKey(e)) {
        isUnique.set(false);
      } else {
        map.merge(e, 0, Integer::sum);
      }
    });
    return isUnique.get();
  }

  private static boolean isUniqueCharacters3(String str) {
    if (str.length() > CHAR_MAX) {
      return false;
    }

    boolean[] isExist = new boolean[CHAR_MAX];
    for (int i = 0; i < str.length(); i++) {
      int index = str.charAt(i);
      if (isExist[index] == true) {
        return false;
      }
      isExist[index] = true;
    }
    return true;
  }

  private static boolean isUniqueCharacters4(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int bitAtIndex = str.charAt(i)-'a';
      if ((checker & (1 << bitAtIndex)) > 0) {
        return false;
      }
      checker = checker | (1 << bitAtIndex);
    }
    return true;
  }


}
