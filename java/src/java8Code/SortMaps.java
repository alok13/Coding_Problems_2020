package java8Code;

import java.util.*;

public class SortMaps {

    public static void main(String[] args) {
        Map<String, Integer> unsortMap = new HashMap<String, Integer>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        Map<String, Integer> result = sortByValueStream(unsortMap);
        System.out.println(result);

        Map<String, Integer> result1 = sortByKeyStream(unsortMap);
        System.out.println(result1);

        Map<String, Integer> result3 = sortByValueStreamOldWay(unsortMap);
        System.out.println(result3);

        Map<String, Integer> result4 = sortByKeyStreamOldWay(unsortMap);
        System.out.println(result4);
    }

    private static Map<String, Integer> sortByKeyStreamOldWay(Map<String, Integer> unsortMap) {
        Map<String,Integer> treeMap=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        treeMap.putAll(unsortMap);
        return treeMap;
    }

    private static Map<String, Integer> sortByValueStreamOldWay(Map<String, Integer> unsortMap) {
        List<Map.Entry<String,Integer>> list =new ArrayList<>(unsortMap.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    private static Map<String, Integer> sortByKeyStream(Map<String, Integer> unsortMap) {
        return unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(LinkedHashMap::new,(m,v)->m.put(v.getKey(),v.getValue()),LinkedHashMap:: putAll);
    }

    private static Map<String, Integer> sortByValueStream(Map<String, Integer> unsortMap) {
        return unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(LinkedHashMap::new, (k, v) -> k.put(v.getKey(), v.getValue()), LinkedHashMap::putAll);
    }


}
