package dz.Utechka;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utechka {
    private static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        long l = new Random().nextLong();
        int p = 0;
        int i;
        for (i = 0; i != -1; i++) {
            list.add(l);
            long y = list.get(p) * 2 * 123123000 + p;
            list.add(y);
            p++;
        }

    }
}


