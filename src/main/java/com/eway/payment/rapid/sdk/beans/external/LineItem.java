package com.eway.payment.rapid.sdk.beans.external;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Contains line item information
 */
public class LineItem {

    @JsonProperty("SKU")
    private String sku;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Quantity")
    private Integer quantity;

    @JsonProperty("UnitCost")
    private Integer unitCost;

    @JsonProperty("Tax")
    private Integer totalTax;

    @JsonProperty("Total")
    private Integer total;

    /**
     * Used to set the line item's values so that the total and tax add up
     * correctly.
     * Sets the total and totalTax.
     *
     * @param unitCost Cost of each unit (in cents)
     * @param unitTax Cost of tax on each unit (in cents)
     * @param quantity Number of units
     */
    public void calculate(Integer unitCost, Integer unitTax, Integer quantity) {
        if (unitCost != null && unitTax != null && quantity != null) {
            totalTax = quantity * unitTax;
            total = (quantity * unitCost) + totalTax;
        }
    }

    /**
     * Return ID of the Line Item's product
     *
     * @return ID of the Line Item's product
     */
    public String getSku() {
        return sku;
    }

    /**
     * Set the ID of the Line Item's product
     *
     * @param sku ID of the Line Item's product
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Return product description of the item
     *
     * @return Product description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the product description of the item
     *
     * @param description Product description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return the number of items
     *
     * @return The number of items
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the number of items
     *
     * @param quantity The number of items
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Return price (in cents) of each item
     *
     * @return Price (in cents)
     */
    public Integer getUnitCost() {
        return unitCost;
    }

    /**
     * Set the price (in cents) of each item
     *
     * @param unitCost Price (in cents)
     */
    public void setUnitCost(Integer unitCost) {
        this.unitCost = unitCost;
    }

    /**
     * Return the combined tax (in cents) for all the items
     *
     * @return the combined tax (in cents)
     */
    public Integer getTotalTax() {
        return totalTax;
    }

    /**
     * Set the combined tax (in cents) for all the items
     *
     * @param totalTax the combined tax (in cents)
     */
    public void setTotalTax(Integer totalTax) {
        this.totalTax = totalTax;
    }

    /**
     * Return the total (including Tax) for all the items
     *
     * @return Total (including Tax)
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Set the total (including Tax) for all the items in cents
     *
     * @param total Total (including Tax)
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
