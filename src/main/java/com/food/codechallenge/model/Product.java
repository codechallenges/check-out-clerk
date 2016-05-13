package com.food.codechallenge.model;


public class Product {
	
	private String productCode;
	private String productName;
	private double unitPrice;
	private int volumePriceCount;
	private double volumePrice;
	
	public Product(String productCode, String productName, double unitPrice, int volumePriceCount, double volumePrice) {
		this.productCode = productCode;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.volumePriceCount = volumePriceCount;
		this.volumePrice = volumePrice;
	}
	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getVolumePriceCount() {
		return volumePriceCount;
	}

	public void setVolumePriceCount(int volumePriceCount) {
		this.volumePriceCount = volumePriceCount;
	}

	public double getVolumePrice() {
		return volumePrice;
	}

	public void setVolumePrice(double volumePrice) {
		this.volumePrice = volumePrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((productCode == null) ? 0 : productCode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + volumePriceCount;
		temp = Double.doubleToLongBits(volumePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double
				.doubleToLongBits(other.unitPrice))
			return false;
		if (volumePriceCount != other.volumePriceCount)
			return false;
		if (Double.doubleToLongBits(volumePrice) != Double
				.doubleToLongBits(other.volumePrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName
				+ ", unitPrice=" + unitPrice + ", volumePriceCount=" + volumePriceCount
				+ ", volumePrice=" + volumePrice + "]";
	}
}
