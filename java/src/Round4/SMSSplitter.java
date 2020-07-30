package Round4;

import java.util.ArrayList;
import java.util.List;

//This is fucking aweful.YOu cant even do this.This is fucking aweful.YOu cant even do this. This is fucking aweful.YOu cant even do this.
// This is fucking aweful.YOu cant even do this.
public class SMSSplitter {
    public static void main(String[] args) {
        String input = "Insomnia, also known as sleeplessness, is a sleep disorder in which people have trouble sleeping.[1] " +
                "They may have difficulty falling asleep, or staying asleep as long as desired.[9][11] Insomnia is typically followed by " +
                "daytime sleepiness, low energy, irritability, and a depressed mood.[1] It may result in an increased risk of motor vehicle collisions, " +
                "as well as problems focusing and learning.[1] " +
                "Insomnia can be short term, lasting for days or weeks, or long term, lasting more than a month.[1]";
        List<String> result = splitTheSMS(input);
        for (String s : result)
            System.out.println(s);
    }

    private static List<String> splitTheSMS(String input) {
        String[] arr = input.split(" ");
        int numOfPartition = input.length() < 160 ? 1 : (input.length() / 160 + 1);
        List<String> result = new ArrayList<String>();

        if (numOfPartition == 1) {
            result.add(input);
            return result;
        }

        String s = "";
        int page = 0;
        for (int i = 0; i < arr.length; i++) {
            String currentWord = arr[i];
            if ((s + currentWord).length() > 157) {
                page++;
                s = s + page + "/" + numOfPartition;
                result.add(s);
                s = currentWord;

            } else {
                s = s + " " + currentWord;
            }
        }
        if (s.length() > 0) {
            page++;
            s = s + page + "/" + numOfPartition;
            result.add(s);
        }

        return result;
    }
}
