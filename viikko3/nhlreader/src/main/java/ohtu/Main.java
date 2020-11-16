package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        ArrayList<Player> shownPlayers = new ArrayList<Player>();
        for (int i = 0; i < players.length; i ++) {
            if (players[i].getNationality().equals("FIN")) {
                shownPlayers.add(players[i]);
            }
        }

        System.out.println("Suomalaiset pelaajat:");
        while(shownPlayers.size() > 0) {
            int biggestScore = -1;
            int selected = -1;
            for (int i = 0; i < shownPlayers.size(); i ++) {
                int score = Integer.parseInt(shownPlayers.get(i).getAssists()) + Integer.parseInt(shownPlayers.get(i).getGoals());
                if (score > biggestScore) {
                    biggestScore = score;
                    selected = i;
                }
            }
            String format = "%-20s%s";
            System.out.printf(format, shownPlayers.get(selected).getName(),shownPlayers.get(selected).getTeam());
            format = "%-10s%s";
            System.out.printf(format, "  " + shownPlayers.get(selected).getGoals() + " + " + shownPlayers.get(selected).getAssists(), " = " + biggestScore);
            System.out.println("");
            shownPlayers.remove(selected);
        }
    }
}
