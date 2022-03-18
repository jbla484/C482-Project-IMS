package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Product class inherits from the Part class, making a product from a call to the
 * super class and setting associated parts to an observable list.
 *
 * @author James Blankenship
 * @version 1.0
 */
public class Product extends Part {

    private final ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    public Product(int id, String name, double price, int stock, int min, int max) {

        super(id, name, price, stock, min, max);
    }

    /**
     * @param part the part to add
     */
    public void addAssociatedPart(Part part) {

        associatedParts.add(part);
    }

    /**
     * @param selectedAssociatedPart the part to delete
     * @return a boolean value indicating whether the part got deleted
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {

        return associatedParts.remove(selectedAssociatedPart);
    }

    /**
     * @return an Observable List of all associated parts
     */
    public ObservableList<Part> getAllAssociatedParts() {

        return associatedParts;
    }
}
