package Schenyatskiy.bankomat;

import java.util.Scanner;

public class vybor_scheta {
    public static int[] vybor_scheta() throws IllegalStateException {
        System.out.print("\n" + "Вас приветствует программа \"Банкомат\"" + "\n" + "Выберете счет"
                + "\n" + "1) Текущий"
                + "\n" + "2) Дебетовый"
                + "\n" + "3) Кредитный"
                + "\n" + "4) Перевод между счетами"
                + "\n" + "0) Выход"
                + "\n");
        Scanner G = new Scanner(System.in);
        while (!G.hasNextInt()) {
            System.out.print("Выбирите счет:" + "\n");
            G.next();
        }
        int c = G.nextInt();
        if (kreditniy.chet < (-20000) && c == 2) {
            System.out.print("Вам запрещенно работь с дебетовым счетом, " +
                    "по причине задолжности более 20000 на кредитном счете" + "\n" + "\n");
            System.out.print("\n" + "Выберете счет"
                    + "\n" + "1) Текущий"
                    + "\n" + "3) Кредитный"
                    + "\n" + "0) Выход"
                    + "\n");
            Scanner Q = new Scanner(System.in);
            while (!Q.hasNextInt()) {
                System.out.print("Выбирите счет:" + "\n");
                Q.next();
                c = Q.nextInt();
            }
        }
        if (c == 4) {
            perevod.perd();
            System.exit(1);
        }
        if (c == 0) {
            System.exit(1);
        }
        int chet;
        switch (c) {
            case 1:
                System.out.print("Вы выбрали текущий счет" + "\n" + "\n");
                chet = tecushiy.chet;
                break;
            case 2:
                System.out.print("Вы выбрали дебетовый счет" + "\n" + "\n");
                chet = debetoviy.chet;
                break;
            case 3:
                System.out.print("Вы выбрали кредитный счет" + "\n" + "\n");
                chet = kreditniy.chet;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        return new int[]{chet, c};
    }
}
