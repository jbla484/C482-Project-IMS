package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Objects;

/**
 * The Inventory class takes part and product objects as parameters and stores them in
 * observable lists.
 *
 * @author James Blankenship
 * @version 1.0
 */
public class Inventory {

    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * @param newPart the part to add
     */
    public static void addPart(Part newPart) {

        allParts.add(newPart);
    }

    /**
     * @param newProduct the product to add
     */
    public static void addProduct(Product newProduct) {

        allProducts.add(newProduct);
    }

    /**
     * @param partId the partId to lookup
     * @return the part with index partId
     */
    public static Part lookupPart(int partId) {

        return allParts.get(--partId);
    }

    /**
     * @param productId the productId to lookup
     * @return the product with index productId
     */
    public static Product lookupProduct(int productId) {

        return allProducts.get(productId);
    }

    /**
     * @param partName the partName to lookup
     * @return an observable array of parts that match the part name
     */
    public static ObservableList<Part> lookupPart(String partName) {

        ObservableList<Part> partList = FXCollections.observableArrayList();

        for (Part part : allParts) {
            if (Objects.equals(partName, part.getName())) {
                partList.add(part);
            }
        }

        return partList;
    }

    /**
     * @param productName the productName to lookup
     * @return an observable array of products that match the product name
     */
    public static ObservableList<Product> lookupProduct(String productName) {

        ObservableList<Product> productList = FXCollections.observableArrayList();

        for (Product product : allProducts) {
            if (Objects.equals(productName, product.getName())) {
                productList.add(product);
            }
        }

        return productList;
    }

    /**
     * @param index the index of the part being updated
     * @param selectedPart the part with the updated values
     */
    public static void updatePart(int index, Part selectedPart) {

        allParts.set(index - 2, selectedPart);
    }

    /**
     * @param index the index of the product being updated
     * @param selectedProduct the product with the updated values
     */
    public static void updateProduct(int index, Product selectedProduct) {

        allProducts.set(index - 2, selectedProduct);
    }

    /**
     * @param selectedPart the part to be deleted
     * @return a boolean value indicating whether the part got deleted
     */
    public static boolean deletePart(Part selectedPart) {

        return allParts.remove(selectedPart);
    }

    /**
     * @param selectedProduct the product to be deleted
     * @return a boolean value indicating whether the product got deleted
     */
    public static boolean deleteProduct(Product selectedProduct) {

        return allProducts.remove(selectedProduct);
    }

    /**
     * @return an Observable List of all parts
     */
    public static ObservableList<Part> getAllParts() {

        return allParts;
    }

    /**
     * @return an Observable List of all products
     */
    public static ObservableList<Product> getAllProducts() {

        return allProducts;
    }
}
