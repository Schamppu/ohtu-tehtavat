package ohtu.verkkokauppa;

public class Kauppa {

    private Varasto varasto;
    private Ostoskori ostoskori;
    private Viitegeneraattori viitegeneraattori;
    private String kaupanTili;
    private Pankki pankki;

    public Kauppa(Varasto varasto, Pankki pankki, Viitegeneraattori viitegeneraattori) {
        kaupanTili = "33333-44455";
        this.pankki = pankki;
        this.varasto = varasto;
        this.viitegeneraattori = viitegeneraattori;
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id);
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();

        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
