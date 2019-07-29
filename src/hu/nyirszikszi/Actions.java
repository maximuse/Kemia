package hu.nyirszikszi;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Actions {
    private static String chemicalSymbol;

    static ArrayList<Felfedezesek> readList(String fileName) {
        ArrayList<Felfedezesek> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            row = raf.readLine();
            String[] slice;

            while (row != null) {
                slice = row.split(";");

                list.add(new Felfedezesek(slice[0], slice[1], slice[2], Integer.parseInt(slice[3]), slice[4]));

                row = raf.readLine();
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    static String task4(ArrayList<Felfedezesek> list) {
        int counter = 0;

        for (Felfedezesek felfedezesek : list) {
            if (felfedezesek.getEv().equals("Ókor")) {
                counter++;
            }
        }

        return "Felfedezések száma az ókorban: "+ counter;
    }

    static void task5() {
        Scanner s = new Scanner(System.in);
        Pattern p = Pattern.compile("[a-zA-Z]{1,2}");
        Matcher m;
        boolean error = true;

        do {
            System.out.print("Kérek egy vegyjelet: ");
            String cs = s.next().toLowerCase();
            m = p.matcher(cs);

            if (m.matches()) {
                chemicalSymbol = cs;
                error = false;
            }

        }
        while (error);
    }

    static String task6(ArrayList<Felfedezesek> list) {
        String result = "Keresés\n";
        boolean error = true;

        for (Felfedezesek felfedezesek : list) {
            if (felfedezesek.getVegyjel().toLowerCase().equals(chemicalSymbol)) {
                result += "\tAz elem vegyjele: " + felfedezesek.getVegyjel() +
                          "\n\tAz elem neve: " + felfedezesek.getNev() +
                          "\n\tRendszáma: " + felfedezesek.getRendszam() +
                          "\n\tFelfedezés éve: " + felfedezesek.getEv() +
                          "\n\tFelfedező: " + felfedezesek.getFelfedezo();
                error = false;
                break;
            }
        }

        if (error) {
            result += "\tNincs ilyen elem az adatforrásban!";
        }

        return result;
    }

    static String task7(ArrayList<Felfedezesek> list) {
        int result = 0;
        int sub;

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getEv().equals("Ókor")) {
                try {
                    sub = Integer.parseInt(list.get(i+1).getEv()) - Integer.parseInt(list.get(i).getEv());

                    if (sub > result) {
                        result = sub;
                    }

                }
                catch (Exception ignored) {}
            }
        }

        return result + " év volt a leghosszabb időszak két elem felfedezése között.";
    }
}