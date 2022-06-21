package com.GreedyAlgorithm;

import java.util.*;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        List<String> allAreas = new ArrayList<>();
        HashSet<String> selects = new HashSet<>();
        HashSet<String> tempt = new HashSet<>();
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        String maxKey = null;
        while (allAreas.size() != 0){
            maxKey = null;
            for (String regStr1 : broadcasts.keySet()) {
                tempt.addAll(broadcasts.get(regStr1));
                tempt.retainAll(allAreas);
                if(maxKey == null || (tempt.size() > ((broadcasts.get(maxKey).retainAll(allAreas)) == true ? broadcasts.size() : 0)))
                    maxKey = regStr1;

            }

            if(maxKey != null){
                allAreas.remove(broadcasts.get(maxKey));
                selects.add(maxKey);
            }
        }
    }


}
