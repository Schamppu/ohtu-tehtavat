package statistics;

import java.util.LinkedList;

public class Query {

    private LinkedList<String> alkiot;

    public Query() {
        alkiot = new LinkedList<String>();
    }

    public void push(String alkio){
        alkiot.addFirst(alkio);
    }

    public String pop(){
        return alkiot.remove();
    }

    public boolean empty(){
        return alkiot.isEmpty();
    }
}
