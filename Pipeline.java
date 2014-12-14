package com.kami;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by mkamleithner on 12/14/14.
 */
public class Pipeline {

    private final Produktionsschritt[] reihenfolge;
    private Queue<Produkt> produkte = new LinkedList<>();
    private EnumMap<Produktionsschritt, Produkt> schritte = new EnumMap<>(Produktionsschritt.class);

    public void addProdukt(Produkt produkt) {
        this.produkte.add(produkt);

    }

    public Pipeline(Produktionsschritt[] reihenfolge) {
        this.reihenfolge = reihenfolge;
    }

    public boolean clock() {
        for (int i = reihenfolge.length - 1; i >= 0; i--) {
            Produkt produkt;
            Produktionsschritt schritt = reihenfolge[i];
            if ((produkt = schritte.get(schritt)) != null) {
                int kosten = produkt.getKosten(schritt).decrementAndGet();
                if (kosten <= 0) {
                    if (i == reihenfolge.length - 1) {
                        schritte.put(schritt, null);
                    } else {
                        if (schritte.get(reihenfolge[i + 1]) == null) {
                            schritte.put(schritt, null);
                            schritte.put(reihenfolge[i + 1], produkt);
                        }

                    }
                }
            }

        }
        if (schritte.get(reihenfolge[0]) == null && !produkte.isEmpty()) {
            schritte.put(reihenfolge[0], produkte.poll());
        }

        for (Produktionsschritt schritt : reihenfolge) {
            if (schritte.get(schritt) != null) {
                return true;
            }
        }
        return false;

    }


}
