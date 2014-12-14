package com.kami;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mkamleithner on 12/14/14.
 */
public interface
        Produkt {


    AtomicInteger getKosten(Produktionsschritt produktionsschritt);
}
