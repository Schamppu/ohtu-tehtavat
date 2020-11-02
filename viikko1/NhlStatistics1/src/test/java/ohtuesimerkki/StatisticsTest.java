package ohtuesimerkki;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void hakuTestiNull() {
        assertEquals(null, stats.search("ööööööö"));
    }

    @Test
    public void hakuTesti() {
        assertNotEquals(null, stats.search("Semen"));
    }

    @Test
    public void tiimiTesti() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void topScoreTesti() {
        assertEquals(2, stats.topScorers(1).size());
    }

}