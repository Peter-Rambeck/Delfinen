package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Konkurrencer {
    //public static ArrayList<Konkurrence> liste=new ArrayList<>();
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
