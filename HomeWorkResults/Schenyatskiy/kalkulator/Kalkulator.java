package dz.kalkulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

import static java.util.regex.Pattern.compile;

class Kalkulator {
    String znak;

    String vvodVyrazeniy() {
        Scanner vyrazenie = new Scanner(System.in);
        System.out.print("\n" + "Введите выражение данного вида \"Цифра  знак  Цифра\""
                + "\n" + "Например: 2+5"
                + "\n");
        return vyrazenie.nextLine();
    }

    List<Integer> parsingVyrazeniy(String vyrazinie) {
        List<Integer> nums = new ArrayList<>();
        try {
            Pattern pZnak = compile("[+\\-*/$]");
            Pattern pChisla = compile("\\b[0-9]\\b");
            Pattern pValidatciy = compile("\\b[0-9]\\b[+\\-*/]\\b[0-9]\\b");

            Matcher mZnak = pZnak.matcher(vyrazinie);
            Matcher mChisla = pChisla.matcher(vyrazinie);
            Matcher mValidatciy = pValidatciy.matcher(vyrazinie);

            while (mChisla.find()) {
                Integer chislo = Integer.valueOf(mChisla.group());
                nums.add(chislo);
            }

            mZnak.find();
            this.znak = String.valueOf(mZnak.group());


            mValidatciy.find();
            System.out.println(mValidatciy.group());


        } catch (IllegalStateException e) {
            System.out.println("Выражение не соответствует \"Цифра знак Цифра\"");
        }
        return nums;
    }


    int rashet(ArrayList nums) {
        try {
            switch (znak) {
                case "-":
                    return (int) nums.get(0) - (int) nums.get(1);
                case "+":
                    return (int) nums.get(0) + (int) nums.get(1);
                case "/":
                    try {
                        return (int) nums.get(0) / (int) nums.get(1);
                    } catch (ArithmeticException e) {
                        System.out.println("Делить на ноль нельзя");
                        return 99;
                    }
                case "*":
                    return (int) nums.get(0) * (int) nums.get(1);
            }
        } catch (Exception e) {
        }
        return 99;
    }

    void vyvodResult(int result) {
        if (result == 99) {
            System.out.println("Результат не может быть посчитан, возникла ошибка");
        } else {
            System.out.println(result);
        }
    }
}
