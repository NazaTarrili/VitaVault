package com.vitavault.vitavault.util;

import java.util.ArrayList;
import java.util.List;

public class EventTypeNotification {
    public static String outOfStock = "Out of stock";
    public static String less = "Less units";
    public static String general = "General";

    public static List<String> AllTypes(){
        ArrayList<String> list = new ArrayList<>();
        list.add(outOfStock);
        list.add(less);
        list.add(general);
        return list;
    }
}
