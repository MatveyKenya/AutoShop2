package ru.matveykenya;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final List<String> listAuto = new ArrayList<>();
    private boolean shopOpened = true;

    public synchronized void put(String auto, boolean endAuto){
        listAuto.add(auto);
        System.out.println("\nПроизведен новый " + auto);
        if (endAuto) {
            close();
        }
        notifyAll();
    }

    public synchronized String get() {
        while (!isAuto() && isOpened()){
            System.out.println("Машин нет. " + Thread.currentThread().getName() + " ждет...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isAuto() ? listAuto.remove(0) : null;
    }

    public boolean isAuto() {
        return listAuto.size() > 0;
    }

    public boolean isOpened() {
        return shopOpened;
    }

    public void close() {
        shopOpened = false;
    }

    @Override
    public String toString() {
        return "В Автосалоне в наличии - " + listAuto;
    }
}
