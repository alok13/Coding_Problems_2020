package Round1;

import java.util.*;

public class TopNWords {
    public static void main(String[] args) {

        int numToys = 6;
        int topToys = 2;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = {
                "Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year",
                "Elsa and Elmo are the toys I'll be buying for my kids",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"};
        List<String> result = returnTopToys(numToys, topToys, toys, numQuotes, quotes);
        System.out.println(result.toString());
    }

    private static List<String> returnTopToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        PriorityQueue<Toys> toyQueue = new PriorityQueue<>();
        Map<String, Integer> toyMap = new HashMap<String, Integer>();

        List<String> toyList = Arrays.asList(toys);

        for (int i = 0; i < numQuotes; i++) {
            String[] wordArray = quotes[i].split(" ");
            for (String s : wordArray) {
                s = s.replace("!", "");
                s = s.toLowerCase();
                if (toyList.contains(s)) {
                    if (toyMap.containsKey(s)) {
                        Integer count = toyMap.get(s);
                        toyMap.put(s, count + 1);
                    } else {
                        toyMap.put(s, 1);
                    }
                }
            }
        }
        List<String> result = toyMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(topToys).collect(ArrayList::new, (m, e) -> m.add(e.getKey()), List::addAll);
        return result;

    }
}

class Toys {
    String toyName;
    int count;

    public Toys(String toyName, int count) {
        this.toyName = toyName;
        this.count = count;
    }

}
