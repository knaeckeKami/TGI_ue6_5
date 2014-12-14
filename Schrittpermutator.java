package com.kami;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mkamleithner on 12/14/14.
 */
public class Schrittpermutator<K> {

    private static Produktionsschritt[] startPermutation = Produktionsschritt.values();

    public static List<List<Produktionsschritt>> schrittPermutations() {

        return new Schrittpermutator<Produktionsschritt>().generatePerm(new ArrayList<>(Arrays.asList(startPermutation)));
    }


    public static void printPermutations(int[] n, int[] Nr, int idx, List<Produktionsschritt[]> perms) {
        if (idx == n.length) {  //stop condition for the recursion [base clause]
            perms.add(getReihenfolge(n));
            return;
        }
        for (int i = 0; i <= Nr[idx]; i++) {
            n[idx] = i;
            printPermutations(n, Nr, idx + 1, perms); //recursive invokation, for next elements
        }
    }

    public static Produktionsschritt[] getReihenfolge(int[] anordnung) {
        System.out.println(Arrays.toString(anordnung));
        Produktionsschritt[] produktionsschritte = new Produktionsschritt[startPermutation.length];
        for (int i = 0; i < produktionsschritte.length; i++) {
            produktionsschritte[i] = startPermutation[anordnung[i]];
        }


        return produktionsschritte;
    }


    public  List<List<K>> generatePerm(List<K> original) {
        if (original.size() == 0) {
            List<List<K>> result = new ArrayList<List<K>>();
            result.add(new ArrayList<K>());
            return result;
        }
        K firstElement = original.remove(0);
        List<List<K>> returnValue = new ArrayList<List<K>>();
        List<List<K>> permutations = generatePerm(original);
        for (List<K> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<K> temp = new ArrayList<K>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

}
