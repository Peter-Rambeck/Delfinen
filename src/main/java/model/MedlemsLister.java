package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MedlemsLister {
    //klasse der bare indeholder et static hashmap med medlemmer
    // og 3 toString til at udskrive disse i forskellige situationer

    public static HashMap<Integer, Medlem> medlemMap = new HashMap<>();

    @Override
    public String toString() {
        //den almindelige toString, et medlem per linje
        String retVal="Medlemmer";
        for (Medlem medlem:medlemMap.values()) {
            retVal=retVal+medlem.toString()+"\n";
        }
        return retVal;
    }


    public String KortToString() {
        //den korte toString, kun id og navn, et medlem per linje
        String retVal="Medlemmer\n";
        for (Medlem medlem:medlemMap.values()) {
            retVal=retVal+medlem.kortToString()+"\n";
        }
        return retVal;
    }
    public String KortToStringkonkurrencemedlem() {
        //den korte toString, kun id og navn, et medlem per linje
        //udskriver kun konkurrencemedlemmer, bruges af træneren..
        String retVal="Medlemmer\n";
        for (Medlem medlem:medlemMap.values()) {
            if((medlem!=null)&&(!
                    medlem.isMotionist())){
            retVal=retVal+medlem.kortToString()+"\n";}
        }
        return retVal;
    }
}
