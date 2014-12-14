package com.kami;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //List<List<Produktionsschritt>> möglicheReihenfolgen = Schrittpermutator.schrittPermutations();
        int i = 0;

        Produktionsschritt[] arr = new Produktionsschritt[0];

        //for (List<Produktionsschritt> schritte : möglicheReihenfolgen){
        List<Produktionsschritt> schritte = Arrays.asList(Produktionsschritt.values());
        System.out.println(schritte);

        Pipeline pipeline ;
        List<CD> cds = new ArrayList<>();

        CDFaktory faktory = new CDFaktory();
        // cds.add(faktory.getCD5());
        // cds.add(faktory.getCD4());
        // cds.add(faktory.getCD5());
        // cds.add(faktory.getCD4());

        cds.add(faktory.getCD2());
        cds.add(faktory.getCD3());
        cds.add(faktory.getCD4());

        List<List<CD>> cdPermutations = new Schrittpermutator<CD>().generatePerm(cds);

        for (List<CD> permutation : cdPermutations) {
            System.out.println(permutation);
            pipeline =  new Pipeline(schritte.toArray(arr));

           // for (int j = 0; j < 10; j++) {
           //     cds.add(faktory.getCD1());
           // }

            for (CD cd : permutation) {
                pipeline.addProdukt(cd);

            }

            int clocks = 0;
            while (pipeline.clock()) {
                clocks++;
            }
            System.out.println(clocks + " " + i++);

        }
    }
}
