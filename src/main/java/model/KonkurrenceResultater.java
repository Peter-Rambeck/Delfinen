package model;
import java.util.HashMap;
import java.util.TreeMap;

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
    public void udskrivTop5(int disciplin,boolean mand, boolean senior){
        //udskriver top5 over resultater som opfylder kriterie
        //hashmap med alle resultater gennemløbes og
        // resultater der opfylder kriterie tilføjes til treemap (sorteret på tid)
        //de 5 første udskrives
        String retVal="Top5 Liste:\n";
        TreeMap<Integer, KonkurrenceResultat> sorteredeResultater
                = new TreeMap<Integer, KonkurrenceResultat>();
        for (KonkurrenceResultat k:konkurrenceResultatMap.values()){
            if(k.opfylderKriterie(disciplin, mand, senior)){
                sorteredeResultater.put(k.getTid(),k);
            }

        }
        //udskriv 5 eller så mange der er fundet resultater
        int antal=sorteredeResultater.size();
        if (antal>5){antal=5;}
        for(int i=0;i<antal;i++){
            System.out.print(sorteredeResultater.pollFirstEntry().getValue());
        }

        return;
    }


}
