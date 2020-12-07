package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    private boolean atLeastOne = false;

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                // Muutetaan atLeastOnea trueksi niin saadaan tuotua se returnilla
                atLeastOne = true;
            }
        }

        return atLeastOne;
    }
}
