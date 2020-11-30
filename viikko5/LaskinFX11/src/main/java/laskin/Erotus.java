package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    TextField tuloskentta;
    Sovelluslogiikka sovellus;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    int undoValue = 0;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    @Override
    public void suorita() {
        this.undoValue = Integer.parseInt(this.tuloskentta.getText());
        this.sovellus.miinus(Integer.parseInt(this.syotekentta.getText()));
        int laskunTulos = sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);
        if ( laskunTulos==0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }
        this.undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        this.tuloskentta.setText("" + this.undoValue);
    }

}
