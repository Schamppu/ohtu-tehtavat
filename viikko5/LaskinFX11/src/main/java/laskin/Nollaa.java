package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    TextField tuloskentta;
    Sovelluslogiikka sovellus;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    int undoValue = 0;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    @Override
    public void suorita() {
        this.undoValue = Integer.parseInt(this.tuloskentta.getText());
        this.sovellus.nollaa();
        int laskunTulos = this.sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);

    }

    @Override
    public void peru() {
        this.tuloskentta.setText("" + this.undoValue);
    }

}
