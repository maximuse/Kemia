package hu.nyirszikszi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Felfedezesek> list = Actions.readList("felfedezesek.csv");

        System.out.println("3. feladat: Elemek száma: " + list.size());

        System.out.println("4. feladat: " + Actions.task4(list));

        System.out.println("5. feladat:");
        Actions.task5();

        System.out.println("6. feladat: " + Actions.task6(list));

        System.out.println("7. feladat: " + Actions.task7(list));

        System.out.println("8. feladat: " + Actions.task8(list));
    }
}