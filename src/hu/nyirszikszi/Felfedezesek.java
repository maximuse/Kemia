package hu.nyirszikszi;

class Felfedezesek {
    private String ev;
    private String nev;
    private String vegyjel;
    private int rendszam;
    private String felfedezo;

    Felfedezesek(String ev, String nev, String vegyjel, int rendszam, String felfedezo) {
        this.ev = ev;
        this.nev = nev;
        this.vegyjel = vegyjel;
        this.rendszam = rendszam;
        this.felfedezo = felfedezo;
    }

    String getEv() {
        return ev;
    }

    String getNev() {
        return nev;
    }

    String getVegyjel() {
        return vegyjel;
    }

    int getRendszam() {
        return rendszam;
    }

    String getFelfedezo() {
        return felfedezo;
    }

    @Override
    public String toString() {
        return "Felfedezesek{" +
                "ev='" + ev + "'" +
                ", nev='" + nev + "'" +
                ", vegyjel='" + vegyjel + "'" +
                ", rendszam=" + rendszam +
                ", felfedezo='" + felfedezo + "'" +
                "}\n";
    }
}