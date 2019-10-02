package dz.kalkulator;

import java.util.ArrayList;
import java.util.Objects;

public class Pusk {


    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();
        do { kalkulator.vyvodResult(kalkulator.rashet((ArrayList) kalkulator.parsingVyrazeniy(kalkulator.vvodVyrazeniy())));
        }
        while (!Objects.equals(kalkulator.znak, "$"));
    }

}


