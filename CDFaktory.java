package com.kami;

/**
 * Created by mkamleithner on 12/14/14.
 */
public class CDFaktory {

    public CD getCD1() {
        return new CD(false, true, true, "CD1");
    }


    public CD getCD2() {
        return new CD(false, false, false, "CD2");
    }


    public CD getCD3() {
        return new CD(true, true, true,"CD3");
    }


    public CD getCD4() {
        return new CD(false, false, true, "CD4");
    }


    public CD getCD5() {
        return new CD(true, true, true, "CD5");
    }


}
