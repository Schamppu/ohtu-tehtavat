package statistics;

import statistics.matcher.PlaysIn;

public class QueryBuilder {
    Query query;

    QueryBuilder() {
        query = new Query();
    }

    public QueryBuilder playsIn(String team) {
        this.query = new PlaysIn(team);
        return this;
    }

    public Query query() {
        return query;
    }
}
