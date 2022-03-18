package org.example;

/**
 * The Inhouse class inherits from the Part class, making an Inhouse part from a call to the
 * super class and setting additional values via class methods.
 *
 * @author James Blankenship
 * @version 1.0
 */
public class InHouse extends Part {

    private int machineId;

    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * @param machineId the machineId to set
     */
    public void setMachineId(int machineId) {

        this.machineId = machineId;
    }

    /**
     * @return the machineId
     */
    public int getMachineId() {

        return this.machineId;
    }
}
