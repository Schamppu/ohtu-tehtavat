package ohtu.verkkokauppa;

import java.util.*;

public class Varasto implements VarastoInterface {

    private KirjanpitoInterface kirjanpito;
    private HashMap<Tuote, Integer> saldot;

    public Varasto(KirjanpitoInterface kirjanpito) {
        saldot = new HashMap<Tuote, Integer>();
        alustaTuotteet(saldot);
        this.kirjanpito = kirjanpito;
    }

    @Override
    public Tuote haeTuote(int id){
        for (Tuote t : saldot.keySet()) {
            if ( t.getId()==id) return t;
        }

        return null;
    }

    @Override
    public int saldo(int id){
        return saldot.get(haeTuote(id));
    }

    @Override
    public void otaVarastosta(Tuote t){
        saldot.put(t,  saldo(t.getId())-1 );
        kirjanpito.lisaaTapahtuma("otettiin varastosta "+t);
    }

    @Override
    public void palautaVarastoon(Tuote t){
        saldot.put(t,  saldo(t.getId())+1 );
        kirjanpito.lisaaTapahtuma("palautettiin varastoon "+t);
    }

}
