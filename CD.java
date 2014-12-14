package com.kami;

import java.util.EnumMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mkamleithner on 12/14/14.
 */
public class CD implements Produkt {

    private boolean sonderCD;
    private boolean siebDruck;
    private boolean verpackungVollautomatisch;

    private String name;

    private EnumMap<Produktionsschritt, AtomicInteger> kosten;

    public CD(boolean sonderCD, boolean siebDruck, boolean verpackungVollautomatisch,String name) {
        this.sonderCD = sonderCD;
        this.siebDruck = siebDruck;
        this.verpackungVollautomatisch = verpackungVollautomatisch;
        this.name = name;

        this.kosten = new EnumMap<Produktionsschritt, AtomicInteger>(Produktionsschritt.class);
        kosten.put(Produktionsschritt.ERSTELLUNG, new AtomicInteger(this.sonderCD ? 3 : 2));
        kosten.put(Produktionsschritt.MASTER, new AtomicInteger(this.sonderCD ? 2 : 1));
        kosten.put(Produktionsschritt.ÜBERPRÜFUNG, new AtomicInteger(1));
        kosten.put(Produktionsschritt.LABELDRUCK, new AtomicInteger(siebDruck ? 1 : 2));
        kosten.put(Produktionsschritt.VERPACKUNG, new AtomicInteger(verpackungVollautomatisch ? 1 : 2));

    }

    public AtomicInteger getKosten(Produktionsschritt produktionsschritt) {
        return kosten.get(produktionsschritt);
    }


    @Override
    public String toString() {
        return name;
    }
}
