package com.practice.datastructure.array;


//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.util.HashMap;
import java.util.Map;

public class MinimumSwap {


  public static void main(String[] args) {
    int[] arr = { 2, 3, 1, 4, 5};
    System.out.print(minimumSwap(arr));
  }

  private static int minimumSwap(int[] arr) {
    int numberOfSwaps = 0;
    boolean[] visited = new boolean[arr.length+1];

    Map<Integer, Integer> elements = new HashMap<>();

    for(int i=0; i < arr.length; i++){
      elements.put(i+1, arr[i]);
    }

    for(int i = 1; i<= elements.size(); i++){

      if(!visited[i]){
        visited[i]=true;
        if(i == elements.get(i)){
          continue;
        }else{
          int k = elements.get(i);
          while(!visited[k]){

            if(k != elements.get(k)){
              visited[k] = true;
              k = elements.get(k);
              numberOfSwaps++;
            }

          }


        }
      }
    }

    return numberOfSwaps;

  }


}
