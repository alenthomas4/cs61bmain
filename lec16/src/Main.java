import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String[] text = {"sumomo", "mo", "momo", "mo", "momo", "no", "uchi"};

        for (String s: text) {
        int currentCount = map.getOrDefault(s, 0);
            map.put(s, currentCount + 1);

        }
        System.out.println(map);
    }
}