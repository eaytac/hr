
package com.vektorel.hrappe.util;

/**
 *
 * @author eaytac
 */
public class DefaultComboModel {

    private Long value;
    private String label;

    public DefaultComboModel(Long value, String label) {
        this.value = value;
        this.label = label;
    }

    public Long getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}