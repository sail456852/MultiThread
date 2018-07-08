package wk.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupCountsFlexibleCollections {
    public static void main(String[] args) {
        List<Map<String, Integer>> bigList = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        map1.put("offer001", 89);
        map1.put("offer001", 101);
        map1.put("offer001", 90);
        map1.put("offer001", 88);

        map2.put("offer002", 222);
        map2.put("offer002", 11);

        map3.put("offer003", 8888);
        map3.put("offer003", 99);
    }
}
