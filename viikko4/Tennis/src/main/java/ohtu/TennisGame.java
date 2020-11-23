package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScoreWord(int scoreNumber) {
        if (scoreNumber == 0) {
            return "Love";
        }
        if (scoreNumber == 1) {
            return "Fifteen";
        }
        if (scoreNumber == 2) {
            return "Thirty";
        }
        if (scoreNumber == 3) {
            return "Forty";
        }
        return "Error.";
    }

    public String getAdvantage() {
        if (player1Score <= 3) {
            return getScoreWord(player1Score) + "-All";
        } else {
            return "Deuce";
        }
    }

    public String getMoreThanFour() {
        int leadingScore = Math.abs(player1Score - player2Score);
        String returnText = "";
        if (leadingScore < 2) {
            returnText += "Advantage ";
        } else {
            returnText += "Win for ";
        }
        return returnText + getLeadingPlayerName();
    }

    public String getLeadingPlayerName() {
        if (player1Score > player2Score) {
            return player1Name;
        } else {
            return player2Name;
        }
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score) {
            score = getAdvantage();
        }
        if ((player1Score >= 4 || player2Score >= 4) && score.length() == 0)
        {
            score = getMoreThanFour();
        }
        if (score.equals(""))
        {
            score = getScoreWord(player1Score) + "-" + getScoreWord(player2Score);
        }
        return score;
    }
}
