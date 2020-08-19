package com.practice.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNYTest {


  public static void main(String[] args) {

    String createdDate = "2020-06-16 22:25:40";
    /*List<Integer> list = new ArrayList<>();
    list.add(10);    list.add(20);    list.add(5);    list.add(30);    list.add(4);    list.add(20);    list.add(60);
    updateList(list);
    list.size();
    *//*list.add("10 2 5");
    list.add("6 2 2");*//*

    //maximumContainers(list);*/
  }

  public static void maximumContainers(List<String> scenarios) {
    for(String test : scenarios){
      String[] tesArray = test.split(" ");
      int units = Integer.valueOf(tesArray[0]);
      int eachCost = Integer.valueOf(tesArray[1]);
      int returnNumber = Integer.valueOf(tesArray[2]);

      int totalContainers = units/eachCost;

      int sum = totalContainers;
      int mod = 0;
      while(totalContainers >= returnNumber){
        sum = sum +  (totalContainers/returnNumber);
        mod = totalContainers%returnNumber;
        totalContainers = totalContainers/returnNumber;
      }

      sum = sum + mod;

      System.out.println(sum);

    }
  }



  public static String firstRepeatedWord(String sentence) {
    Map<String, String> words = new HashMap<>();

    String[] wordsArray = sentence.trim().split(" ");

    for(String word: wordsArray){
      if(words.containsKey(word)){
        return words.get(word);
      }else{
        words.put(word, word);
      }
    }
    return "";

  }




    public static void updateList(List<Integer> list) {
      List<Integer> removedItemIndex = new ArrayList<>();
      int prev = Integer.MIN_VALUE, next = Integer.MIN_VALUE;
      boolean isRemoved = false;
      for(int i=0; i<list.size();i++){
        if(i == 0 || i == (list.size()-1)){
          continue;
        }
        int number = list.get(i);
        prev = list.get(i-1);
        next = list.get(i+1);
        if(prev > number && next > number){

          list.remove(i);
          i--;
        }
      }

      for(int index : removedItemIndex){
        list.remove(index);
      }

    }


  }
