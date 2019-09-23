package Schenyatskiy.bankomat;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int chet[] = vybor_scheta.vybor_scheta();
        tcykol1(chet[0], chet[1]);
    }
    private static void tcykol1(int chet, int m) {
        int c;
        do {
            c = start_menu();
            chet = shag(c, chet, m);
        } while (c != 0);
    }
    private static int snytie(int chet) {
        int d;
        do {
            d = chislo();
            if (d > 30000) {
                System.out.print("Запрещено снятие болеее 30000 за один сеанс!"
                        + "\n" + "Пожалуйста, укажите сумму менее 30000" + "\n");
            }
        }
        while (d > 30_000);
        chet -= d;
        if (chet < 0) {
            System.out.print("Недостаточно средств" + "\n");
            chet += d;
        } else {
            System.out.print("На вашем счету осталось   " + chet + "\n");
        }
        return chet;
    }
    private static int polozit(int chet, int m) {
        int d = chislo();
        chet += d;
        System.out.print("Баланс вашего счета  " + chet + "\n" + "\n");
        if (d > 1000000 && m == 1) {
            int u = debetoviy.chet + 2000;
            System.out.print("\n" + "За пополнение текущего счета более чем на 1 миллион"
                    + "\n" + "Вам дополнительно зачислено 2000 на дебетовый счет"
                    + "\n" + "Баланс вашего дебетового счета  " + u + "\n" + "\n");
        }
        return chet;
    }
    private static int start_menu() {
        System.out.print("\n" + "Выберете действие"
                + "\n" + "1) Снять деньги"
                + "\n" + "2) Внести деньги"
                + "\n" + "3) Баланс"
                + "\n" + "0) Выход"
                + "\n");
        Scanner G = new Scanner(System.in);
        while (!G.hasNextInt()) {
            System.out.print("Выбирите пункт меню:" + "\n");
            G.next();
        }
        return G.nextInt();
    }
    private static int shag(int c, int chet, int m) {
        switch (c) {
            case 1:
                System.out.print("Выбирите сумму которую желаете снять");
                chet = snytie(chet);
                break;
            case 2:
                System.out.print("Вставте деньги в купюро приемник");
                chet = polozit(chet, m);
                break;
            case 3:
                System.out.print("Баланс вашего счета  " + chet + "\n" + "\n");
                break;
        }
        return chet;
    }
    public static int chislo() {
        int d;
        System.out.print("\n" + "Введите сумму:" + "\n");
        Scanner G = new Scanner(System.in);
        while (!G.hasNextInt()) {
            System.out.print("Введите:" + "\n");
            G.next();
        }
        d = G.nextInt();
        return d;
    }
}
