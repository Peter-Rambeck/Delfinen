package model;

import java.util.ArrayList;

public class Konkurrencer {
    public static ArrayList<Konkurrence> liste=new ArrayList<>();

    public Konkurrencer() {
    }

    @Override
    public String toString() {
        String retVal="";
        for (Konkurrence k:liste) {
            retVal=retVal+k.toString()+"\n";
        }
        return retVal;
    }
}
