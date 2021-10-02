package ru.matveykenya;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        AutoMaker autoMaker = new AutoMaker(shop, 10, 3000);
        Buyer buyer = new Buyer(shop, 5000);

        Thread buyer1 = new Thread(null, buyer, "Покупатель_1");
        //buyer1.setDaemon(true);
        Thread buyer2 = new Thread(null, buyer, "Покупатель_2");
        //buyer2.setDaemon(true);
        Thread buyer3 = new Thread(null, buyer, "Покупатель_3");
        //buyer3.setDaemon(true);
        Thread buyer4 = new Thread(null, buyer, "Покупатель_4");
        //buyer4.setDaemon(true);
        Thread buyer5 = new Thread(null, buyer, "Покупатель_5");
        //buyer4.setDaemon(true);

        //стартуем
        new Thread(autoMaker).start();
        buyer1.start();
        buyer2.start();
        buyer3.start();
        buyer4.start();
        buyer5.start();
    }
}
