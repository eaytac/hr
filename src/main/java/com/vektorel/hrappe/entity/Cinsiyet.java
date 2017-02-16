
package com.vektorel.hrappe.entity;

/**
 *
 * @author eaytac
 */
public enum Cinsiyet {
    ERKEK("Erkek"), 
    KADIN("Kadın"), 
    BILINMIYOR("Bilinmiyor");
    
    String label;

    private Cinsiyet(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public static Cinsiyet getEnum(int i){
        switch(i){
            case 0 : return ERKEK;
            case 1 : return ERKEK;
            case 2 : return BILINMIYOR;
        }
        return BILINMIYOR;
    }
}
