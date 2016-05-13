package com.food.codechallenge.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
	private List<Item> lineItems;

	public List<Item> getLineItems() {
		return lineItems;
	}
	
	public void setLineItems(List<Item> lineItems) {
		this.lineItems = lineItems;
	}

	public int getItemsCount() {
		int itemsCount = 0;
		for(Item lineItem : this.lineItems) {
			itemsCount = itemsCount + lineItem.getQuantity();
		}
		return itemsCount;
	}

	public void adItem(Item item) {
		if(lineItems == null) lineItems = new ArrayList<Item>();
		lineItems.add(item);
	}
	
	public Item getItem(String productCode) {
		if(lineItems != null) {
			for(Item item: getLineItems()) {
				if (item.getProductCode().equals(productCode)) return item;
			}
		}
		return null;
	}

	public double getTotalAmount() {
		double totalAmount = 0.0;
		for(Item item : this.lineItems) {
			totalAmount = totalAmount + item.getAmount();
		}
		return totalAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineItems == null) ? 0 : lineItems.hashCode());
		long temp;
		temp = Double.doubleToLongBits(getTotalAmount());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + getItemsCount();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receipt other = (Receipt) obj;
		if (lineItems == null) {
			if (other.lineItems != null)
				return false;
		} else if (!lineItems.equals(other.lineItems))
			return false;
		if (Double.doubleToLongBits(getTotalAmount()) != Double
				.doubleToLongBits(other.getTotalAmount()))
			return false;
		if (getItemsCount() != other.getItemsCount())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Receipt [lineItems=" + lineItems + ", totalItems=" + getItemsCount()
				+ ", totalAmount=" + getTotalAmount() + "]";
	}
}
