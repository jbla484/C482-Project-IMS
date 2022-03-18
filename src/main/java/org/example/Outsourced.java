package org.example;

/**
 * The Outsourced class inherits from the Part class, making an Outsourced part from a call to the
 * super class and setting additional values via class methods.
 *
 * @author James Blankenship
 * @version 1.0
 */
public class Outsourced extends Part {

    private String companyName;

    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * @param companyName the company name to set
     */
    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    /**
     * @return the company name in a String
     */
    public String getCompanyName() {

        return this.companyName;
    }
}
