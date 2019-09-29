package dz.bankomatNew;

import java.util.Scanner;

class Perevod extends Bankomat {
    void perevodMezduChetami() {
        int punktMenu2;
        System.out.print("Перевод между счетами" + "\n" + "\n");
        System.out.print("\n" + "Выберете счет с которого желаете перевести деньги"
                + "\n" + "1) Текущий"
                + "\n" + "2) Дебетовый"
                + "\n" + "3) Кредитный"
                + "\n" + "0) Выход"
                + "\n");
        Scanner vyborPunktaMenu = new Scanner(System.in);
        while (!vyborPunktaMenu.hasNextInt()) {
            System.out.print("Выбирите счет:" + "\n");
            vyborPunktaMenu.next();
        }
        int punktMenu = vyborPunktaMenu.nextInt();
        if (punktMenu == 0) {
            System.exit(1);
        }
        int chet1;
        String tip1;
        switch (punktMenu) {
            case 1:
                System.out.print("Вы выбрали текущий счет" + "\n" + "\n");
                chet1 = tecushiy.chet;
                tip1 = tecushiy.tip;
                break;
            case 2:
                System.out.print("Вы выбрали дебетовый счет" + "\n" + "\n");
                chet1 = debetoviy.chet;
                tip1 = debetoviy.tip;
                break;
            case 3:
                System.out.print("Вы выбрали кредитный счет" + "\n" + "\n");
                chet1 = kreditniy.chet;
                tip1 = kreditniy.tip;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + punktMenu);
        }
        do {
            System.out.print("\n" + "Выберете счет на который будут переведны деньги"
                    + "\n" + "1) Текущий"
                    + "\n" + "2) Дебетовый"
                    + "\n" + "3) Кредитный"
                    + "\n" + "0) Выход"
                    + "\n");
            Scanner J = new Scanner(System.in);
            while (!J.hasNextInt()) {
                System.out.print("Выбирите счет:" + "\n");
                J.next();
            }
            punktMenu2 = J.nextInt();
            if (punktMenu2 == 0) {
                System.exit(1);
            }
        } while (punktMenu2 == punktMenu);
        int chet2;
        String tip2;
        switch (punktMenu2) {
            case 1:
                System.out.print("Перевод будет совершен на текущий счет" + "\n" + "\n");
                chet2 = tecushiy.chet;
                tip2 = tecushiy.tip;
                break;
            case 2:
                System.out.print("Перевод будет совершен на дебетовый счет" + "\n" + "\n");
                chet2 = debetoviy.chet;
                tip2 = debetoviy.tip;
                break;
            case 3:
                System.out.print("Перевод будет совершен на кредитный счет" + "\n" + "\n");
                chet2 = kreditniy.chet;
                tip2 = kreditniy.tip;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + punktMenu2);
        }
        int sr = summaDlyManipulytciy();
        chet2 = chet2 + sr;
        chet1 = chet1 - sr;
        System.out.print(tip1 + " баланс: " + chet1 + "\n" + tip2 + " баланс: " + chet2);

    }
}
