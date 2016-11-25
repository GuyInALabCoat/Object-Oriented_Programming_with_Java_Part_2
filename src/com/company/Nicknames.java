package com.company;

import java.util.HashMap;

public class Nicknames {
    public static void main(String[] args){
        HashMap<String, String> nicknames = new HashMap<>();

        nicknames.put("matti", "mage");
        nicknames.put("mikael", "mixu");
        nicknames.put("arto", "arppa");

        System.out.println(nicknames.get("mikael"));
    }
}
