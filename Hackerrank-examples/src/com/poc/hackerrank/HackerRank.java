package com.poc.hackerrank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

class HackerRank {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    	System.out.println(arr.toString());
        
      System.out.println(((arr.stream().collect(Collectors.counting()))/arr.size()));
      
       System.out.println((arr.stream().filter(r -> r<0).collect(Collectors.counting())/arr.size()));
        System.out.println((arr.stream().filter(r -> r==0).collect(Collectors.counting())/arr.size()));

    }

}

