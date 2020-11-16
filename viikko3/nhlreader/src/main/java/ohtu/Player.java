
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private String assists;
    private String goals;
    private String penalties;
    private String team;
    private String games;

    public void setName(String var) {
        this.name = var;
    }
    public void setNationality(String var) {
        this.nationality = var;
    }
    public void setAssists(String var) {
        this.assists = var;
    }
    public void setGoals(String var) { this.goals = var; }
    public void setPenalties(String var) {
        this.penalties = var;
    }
    public void setTeam(String var) { this.team = var; }
    public void setGames(String var) {
        this.games = var;
    }

    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }
    public String getAssists() {
        return assists;
    }
    public String getGoals() {
        return goals;
    }
    public String getPenalties() {
        return penalties;
    }
    public String getTeam() {
        return team;
    }
    public String getGames() {
        return games;
    }

    @Override
    public String toString() {
        return name + " " + team + " goals " + goals + " assists " + assists;
    }

}
