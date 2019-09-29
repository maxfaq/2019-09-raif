package dz.bankomatNew;

import java.util.Scanner;

public class Bankomat {
    Cheta tecushiy;
    Cheta debetoviy;
    Cheta kreditniy;

    public Bankomat() {
        Debetoviy debetoviy = new Debetoviy(25000);
        Kreditniy kreditniy = new Kreditniy(-5000);
        Tecushiy tecushiy = new Tecushiy(1900000);
        this.tecushiy = tecushiy;
        this.debetoviy = debetoviy;
        this.kreditniy = kreditniy;
    }

    Cheta vyborChetaIPerevodMUChetami() {

        System.out.print("\n" + "Вас приветствует программа \"Банкомат\"" + "\n" + "Выберете счет"
                + "\n" + "1) Текущий"
                + "\n" + "2) Дебетовый"
                + "\n" + "3) Кредитный"
                + "\n" + "4) Перевод между счетами"
                + "\n" + "0) Выход"
                + "\n");
        Scanner vvodCheta = new Scanner(System.in);
        while (!vvodCheta.hasNextInt()) {
            System.out.print("Выбирите счет:" + "\n");
            vvodCheta.next();
        }
        int nomerChetaVMenu = vvodCheta.nextInt();
        if (kreditniy.chet < (-20000) && nomerChetaVMenu == 2) {
            System.out.print("Вам запрещенно работь с дебетовым счетом, " +
                    "по причине задолжности более 20000 на кредитном счете" + "\n" + "\n");
            System.out.print("\n" + "Выберете счет"
                    + "\n" + "1) Текущий"
                    + "\n" + "3) Кредитный"
                    + "\n" + "0) Выход"
                    + "\n");
            Scanner punktMenuPriZadolgnosti = new Scanner(System.in);
            while (!punktMenuPriZadolgnosti.hasNextInt()) {
                System.out.print("Выбирите счет:" + "\n");
                punktMenuPriZadolgnosti.next();
                nomerChetaVMenu = punktMenuPriZadolgnosti.nextInt();
            }
        }
        if (nomerChetaVMenu == 4) {
            Perevod perevod = new Perevod();
            perevod.perevodMezduChetami();
            System.exit(1);
        }
        if (nomerChetaVMenu == 0) {
            System.exit(1);
        }
        switch (nomerChetaVMenu) {
            case 1:
                System.out.print("Вы выбрали текущий счет" + "\n" + "\n");
                return tecushiy;
            case 2:
                System.out.print("Вы выбрали дебетовый счет" + "\n" + "\n");
                return debetoviy;
            case 3:
                System.out.print("Вы выбрали кредитный счет" + "\n" + "\n");
                return kreditniy;
            default:

                throw new IllegalStateException("Unexpected value: " + nomerChetaVMenu);
        }
    }

    void manipulytciyChetom(Cheta vyborCheta) {
        int vybranayOperaciy;
        do {
            vybranayOperaciy = vyborOperciy();
            vyborCheta.chet = operaciy(vybranayOperaciy, vyborCheta.chet, vyborCheta.tip);
        } while (vybranayOperaciy != 0);
    }

    private static int snytie(int chet) {
        int summaSnytiy;
        do {
            summaSnytiy = summaDlyManipulytciy();
            if (summaSnytiy > 30000) {
                System.out.print("Запрещено снятие болеее 30000 за один сеанс!"
                        + "\n" + "Пожалуйста, укажите сумму менее 30000" + "\n");
            }
        }
        while (summaSnytiy > 30_000);
        chet -= summaSnytiy;
        if (chet < 0) {
            System.out.print("Недостаточно средств" + "\n");
            chet += summaSnytiy;
        } else {
            System.out.print("На вашем счету осталось   " + chet + "\n");
        }
        return chet;
    }

    private int polozit(int chet, String tip) {
        int summaVneseniy = summaDlyManipulytciy();
        chet += summaVneseniy;
        System.out.print("Баланс вашего счета  " + chet + "\n" + "\n");
        if (summaVneseniy > 1000000 && tip.equals("Текущий счет")) {
            int u = debetoviy.chet + 2000;
            System.out.print("\n" + "За пополнение текущего счета более чем на 1 миллион"
                    + "\n" + "Вам дополнительно зачислено 2000 на дебетовый счет"
                    + "\n" + "Баланс вашего дебетового счета  " + u + "\n" + "\n");
        }
        return chet;
    }

    private static int vyborOperciy() {
        System.out.print("\n" + "Выберете действие"
                + "\n" + "1) Снять деньги"
                + "\n" + "2) Внести деньги"
                + "\n" + "3) Баланс"
                + "\n" + "0) Выход"
                + "\n");
        Scanner vyborOperaciy = new Scanner(System.in);
        while (!vyborOperaciy.hasNextInt()) {
            System.out.print("Выбирите пункт меню:" + "\n");
            vyborOperaciy.next();
        }
        return vyborOperaciy.nextInt();
    }

    private int operaciy(int operaciy, int chet, String tip) {
        switch (operaciy) {
            case 1:
                System.out.print("Выбирите сумму которую желаете снять");
                chet = snytie(chet);
                break;
            case 2:
                System.out.print("Вставте деньги в купюро приемник");
                chet = polozit(chet, tip);
                break;
            case 3:
                System.out.print("Баланс вашего счета  " + chet + "\n" + "\n");
                break;
        }
        return chet;
    }

    static int summaDlyManipulytciy() {
        int chislo;
        System.out.print("\n" + "Введите сумму:" + "\n");
        Scanner vvodChisla = new Scanner(System.in);
        while (!vvodChisla.hasNextInt()) {
            System.out.print("Введите:" + "\n");
            vvodChisla.next();
        }
        chislo = vvodChisla.nextInt();
        return chislo;
    }
}
