package com.practice.datastructure.string;

//https://leetcode.com/discuss/interview-question/542597/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewProblem {

  public static void main(String[] args) {

    //First test
    int k = 2;
    String[] keywords = {"anacell", "cetracular", "betacellular"};
    String[] reviews = {
        "Anacell provides the best services in the city",
        "betacellular has awesome services",
        "Best services provided by anacell, everyone should use anacell"
    };
    System.out.println(getTopKeywords(Arrays.asList(reviews), Arrays.asList(keywords), k));

    //Second test
    k = 2;
    String[] keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
    String[]  reviews2 = {
        "I love anacell Best services; Best services provided by anacell",
        "betacellular has great services",
        "deltacellular provides much better services than betacellular",
        "cetracular is worse than anacell",
        "Betacellular is better than deltacellular."};
    System.out.println(getTopKeywords(Arrays.asList(reviews2), Arrays.asList(keywords2), k));

  }

  public static List<String> getTopKeywords(List<String> reviews, List<String> keywords, int k) {
    return keywords.stream()
        .map(keyword -> getKeywordCount(keyword, reviews))
        .sorted(
            Comparator.comparing(KeywordCount::getCount).reversed().thenComparing(KeywordCount::getKeyword))
        .limit(k)
        .map(KeywordCount::getKeyword)
        .collect(Collectors.toList());
  }

  private static KeywordCount getKeywordCount(String keyword, List<String> reviews) {
    Long count = reviews.stream()
        .filter(review -> review.toLowerCase().contains(keyword.toLowerCase()))
        .count();
    return new KeywordCount(keyword, count);
  }


  public static class KeywordCount {

    String keyword;
    Long count;

    public KeywordCount(String keyword, Long count) {
      this.keyword = keyword;
      this.count = count;
    }

    public String getKeyword() {
      return keyword;
    }

    public Long getCount() {
      return count;
    }
  }
}
