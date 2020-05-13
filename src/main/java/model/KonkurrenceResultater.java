package model;

import java.util.HashMap;

public class KonkurrenceResultater {
    // Hash map med alle konkurrenceresultater.
    public static HashMap<Integer, KonkurrenceResultat> konkurrenceResultatMap = new HashMap<Integer, KonkurrenceResultat>();

    public KonkurrenceResultater() {
    }

    @Override
    public String toString() {
        String retVal="";
        for (KonkurrenceResultat konkurrenceResultat:konkurrenceResultatMap.values()){
            retVal=retVal+konkurrenceResultat.toString();

        }
        return retVal;
    }


}
