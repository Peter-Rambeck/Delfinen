package model;

import java.util.HashMap;

public class Konkurrencer {
//klasse som kun indeholder hashmap med alle konkurrencer og en toString..

       public static HashMap<Integer, Konkurrence> konkurrenceMap = new HashMap<Integer, Konkurrence>();

    public Konkurrencer() {
    }

    @Override
    public String toString() {
        String retVal="";
        for (Konkurrence k : konkurrenceMap.values()) {
            retVal=retVal+k.toString()+"\n";
        }
        return retVal;
    }

}
