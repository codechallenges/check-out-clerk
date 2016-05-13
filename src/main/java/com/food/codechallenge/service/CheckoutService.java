package com.food.codechallenge.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.food.codechallenge.model.Item;
import com.food.codechallenge.model.Product;
import com.food.codechallenge.model.Receipt;

public class CheckoutService {

	/**
	 * @param args
	 */
	
	private Map<String, Product> productsCache; // typically this will also be a service maintaining the product cache
	
	private Receipt receipt;

	public void setPricing(List<Product> productList) {
		if (this.productsCache == null) this.productsCache = new HashMap<String, Product>();
		for(Product product: productList) {
			this.productsCache.put(product.getProductCode(), product);
		}
	}
	
	public String scan(String productCode) {
		Product product = this.productsCache.get(productCode);

		if(product != null) {
			if (this.receipt == null) this.receipt = new Receipt();
			Item item = new Item(productCode, 
					product.getProductName(), 
					1, 
					product.getUnitPrice(), 
					product.getUnitPrice(), 
					product.getVolumePriceCount(), 
					product.getVolumePrice());
			
			this.receipt.adItem(item);

			return "SCAN SUCCESS";
		}
		return "SCAN ERROR: PRODUCT CODE [" +productCode+ "] NOT FOUND";
	}

	public void printReceipt() {
		getReceipt();
		System.out.println("Code\t" 
				+ "Name\t\t" 
				+ "Qty.\t"
				+ "Amount\t\t" 
				+ "U.Price\t\t" 
				+ "V.Price");
		for(Item item: receipt.getLineItems()) {
			System.out.println(item.getProductCode() + "\t" 
					+ item.getProductName() + "\t\t" 
					+ item.getQuantity() + "\t"
					+ "$" + item.getAmount() + "\t\t"
					+ "@ $" + item.getUnitPrice() + "\t\t" 
					+ item.getVolumePriceCount() + " for " + item.getVolumePrice());
		}
		System.out.println("\nTOTAL Items: " + receipt.getItemsCount());
		System.out.println("TOTAL Amount: $" + receipt.getTotalAmount());
	}

	private void aggregateReceipt() {
		Collections.sort(receipt.getLineItems());
		
		Receipt aggregatedReceipt = new Receipt();
		
		List<Item> items = receipt.getLineItems();
	
		for(int i=0; i<items.size(); i++){

			Item item = items.get(i);
			
			int count = Collections.frequency(items, item);
			int volumePriceCount = item.getVolumePriceCount();
			
			if(count < volumePriceCount) {
				item.setQuantity(count);	
				item.setAmount(item.getUnitPrice()*count);
				aggregatedReceipt.adItem(item);
				
			} else {
				for(int d = 1; d <= (count / volumePriceCount); d++) { // division loop
					item.setQuantity(volumePriceCount);
					item.setAmount(item.getVolumePrice());
					aggregatedReceipt.adItem(item);
				}
				
				int remainder = count % volumePriceCount;
				if(remainder > 0) {
					Item leftovers = new Item(item.getProductCode(), 
							item.getProductName(), 
							remainder, 
							(item.getUnitPrice() * remainder), 
							item.getUnitPrice(), 
							item.getVolumePriceCount(), 
							item.getVolumePrice());
					aggregatedReceipt.adItem(leftovers);
				}
			}
			i = i + (count-1); // skipping rest of the same items
		}
		receipt = aggregatedReceipt;
	}

	public Map<String, Product> getProductsCache() {
		return productsCache;
	}

	public void setProductsCache(Map<String, Product> productsCache) {
		this.productsCache = productsCache;
	}

	public Receipt getReceipt() {
		aggregateReceipt();
		return receipt;		
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}	
}










