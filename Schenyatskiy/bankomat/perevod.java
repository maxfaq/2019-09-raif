package Schenyatskiy.bankomat;

import java.util.Scanner;

public class perevod {
    public static void perd() {
        int z;
        System.out.print("Перевод между счетами" + "\n" + "\n");
        System.out.print("\n" + "Выберете счет с которого желаете перевести деньги"
                + "\n" + "1) Текущий"
                + "\n" + "2) Дебетовый"
                + "\n" + "3) Кредитный"
                + "\n" + "0) Выход"
                + "\n");
        Scanner R = new Scanner(System.in);
        while (!R.hasNextInt()) {
            System.out.print("Выбирите счет:" + "\n");
            R.next();
        }
        int p = R.nextInt();
        if (p == 0) {
            System.exit(1);
        }
        int chet1;
        String tip1;
        switch (p) {
            case 1:
                System.out.print("Вы выбрали текущий счет" + "\n" + "\n");
                chet1 = tecushiy.chet;
                tip1=tecushiy.F;
                break;
            case 2:
                System.out.print("Вы выбрали дебетовый счет" + "\n" + "\n");
                chet1 = debetoviy.chet;
                tip1=debetoviy.F;
                break;
            case 3:
                System.out.print("Вы выбрали кредитный счет" + "\n" + "\n");
                chet1 = kreditniy.chet;
                tip1=kreditniy.F;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
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
            z = J.nextInt();
            if (z == 0) {
                System.exit(1);
            }
        } while (z == p);
        int chet2;
        String tip2;
        switch (z) {
            case 1:
                System.out.print("Перевод будет совершен на текущий счет" + "\n" + "\n");
                chet2 = tecushiy.chet;
                tip2=tecushiy.F;
                break;
            case 2:
                System.out.print("Перевод будет совершен на дебетовый счет" + "\n" + "\n");
                chet2 = debetoviy.chet;
                tip2=debetoviy.F;
                break;
            case 3:
                System.out.print("Перевод будет совершен на кредитный счет" + "\n" + "\n");
                chet2 = kreditniy.chet;
                tip2=kreditniy.F;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + z);
        }
        int sr=main.chislo();
        chet2=chet2+sr;
        chet1=chet1-sr;
        System.out.print(tip1+" баланс: "+ chet1+"\n" +tip2+" баланс: "+ chet2);

    }
}
