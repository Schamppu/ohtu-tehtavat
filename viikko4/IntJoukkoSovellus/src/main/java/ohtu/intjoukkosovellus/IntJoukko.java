
package ohtu.intjoukkosovellus;

public class IntJoukko {
    private int kasvatusKoko;
    private int[] lukuJono;
    private int alkioMaara;

    public IntJoukko() {
        lukuJono = new int[5];
        for (int i = 0; i < lukuJono.length; i++) {
            lukuJono[i] = 0;
        }
        alkioMaara = 0;
        this.kasvatusKoko = 5;
    }

    /** Tarkistaa kapasiteetin */
    public int[] tarkistaKapasiteetti(int kapasiteetti) {
        if (kapasiteetti < 0 ) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        return tarkistaKapasiteetti(kapasiteetti);
    }

    public IntJoukko(int kapasiteetti) {
        lukuJono = tarkistaKapasiteetti(kapasiteetti);
        for (int i = 0; i < lukuJono.length; i++) {
            lukuJono[i] = 0;
        }
        alkioMaara = 0;
        this.kasvatusKoko = 5;

    }

    public IntJoukko(int kapasiteetti, int kasvatusKoko) {
        lukuJono = tarkistaKapasiteetti(kapasiteetti);
        for (int i = 0; i < lukuJono.length; i++) {
            lukuJono[i] = 0;
        }
        alkioMaara = 0;
        this.kasvatusKoko = kasvatusKoko;

    }

    public boolean lisaa(int luku) {
        if (alkioMaara == 0) {
            lukuJono[0] = luku;
            alkioMaara++;
            return true;
        }
        if (!kuuluu(luku)) {
            lukuJono[alkioMaara] = luku;
            alkioMaara++;
            if (alkioMaara % lukuJono.length == 0) {
                int[] vanhaTaulukko = lukuJono;
                kopioiTaulukko(lukuJono, vanhaTaulukko);
                lukuJono = new int[alkioMaara + kasvatusKoko];
                kopioiTaulukko(vanhaTaulukko, lukuJono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        int kuuluuTauluun = 0;
        for (int i = 0; i < alkioMaara; i++) {
            if (luku == lukuJono[i]) {
                kuuluuTauluun++;
            }
        }
        if (kuuluuTauluun > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean poista(int luku) {
        int luvunIndeksi = -1;
        int taulukonKopio;
        for (int i = 0; i < alkioMaara; i++) {
            if (luku == lukuJono[i]) {
                luvunIndeksi = i;
                lukuJono[luvunIndeksi] = 0;
                break;
            }
        }
        if (luvunIndeksi != -1) {
            for (int j = luvunIndeksi; j < alkioMaara - 1; j++) {
                taulukonKopio = lukuJono[j];
                lukuJono[j] = lukuJono[j + 1];
                lukuJono[j + 1] = taulukonKopio;
            }
            alkioMaara--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioMaara;
    }


    @Override
    public String toString() {
        if (alkioMaara == 0) {
            return "{}";
        } else if (alkioMaara == 1) {
            return "{" + lukuJono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioMaara - 1; i++) {
                tuotos += lukuJono[i];
                tuotos += ", ";
            }
            tuotos += lukuJono[alkioMaara - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioMaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukuJono[i];
        }
        return taulu;
    }


    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
        return z;
    }
}
