package java8Code;

import java.sql.Time;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args) {
        //practiceMap();
        practiceList();
    }

    private static void practiceList() {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(6, "linode.com", 100000)); // new line

        Map<String, Long> map = list.stream().filter(distinctByKey(Hosting::getName)).filter(p->p.getId()>2).collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (newKey, oldKey) -> oldKey));
        System.out.println(map);

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        List<String> result=G7.stream().map(String::toUpperCase).filter(p->p.length()>5).collect(Collectors.toList());
        System.out.println(G7);

        System.out.println(result);
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private static void practiceMap() {
        HashMap<String, CustomClass> hashMap = new HashMap<>();
        hashMap.put("test", new CustomClass(1, "'test"));
        hashMap.put("test1", new CustomClass(2, "'test1"));
        hashMap.put("test2", new CustomClass(3, "'test2"));
        hashMap.put("test3", new CustomClass(4, "'test3"));
        sortByKey(hashMap);
        System.out.println(hashMap);
    }

    private static void sortByKey(HashMap<String, CustomClass> hashMap) {
        //hashMap.entrySet().stream().sorted(Comparator.comparing(p -> p.getValue().name));

        hashMap.entrySet().stream().sorted(Entry.comparingByKey()).collect(LinkedHashMap::new, (m, v) -> m.put(v.getKey(), v.getValue()), LinkedHashMap::putAll);

        LinkedHashMap<String, CustomClass> resultSet =
                hashMap.entrySet().stream()
                        .sorted(Map.Entry.<String, CustomClass>comparingByValue()
                                .thenComparing(Map.Entry.comparingByKey()))
                        .collect(LinkedHashMap::new, (m, v) -> m.put(v.getKey(), v.getValue()), LinkedHashMap::putAll);

        hashMap.entrySet().stream().sorted(Entry.<String, CustomClass>comparingByValue().thenComparing(Entry.comparingByKey())).collect(LinkedHashMap::new, (m, v) -> m.put(v.getKey(), v.getValue()), LinkedHashMap::putAll);
    }
}

class CustomClass implements Comparable<CustomClass> {
    int id;
    String name;

    public CustomClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(CustomClass o) {
        return 0;
    }
}


class Hosting {

    private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        return "Hosting{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", websites=" + websites +
                '}';
    }
}