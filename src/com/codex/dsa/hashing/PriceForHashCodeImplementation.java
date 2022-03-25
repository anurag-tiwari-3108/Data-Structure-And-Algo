package com.codex.dsa.hashing;

public class PriceForHashCodeImplementation {

	private String item;
	private int itemCode;

	public PriceForHashCodeImplementation(String itm, int itmCode) {
		this.item = itm;
		this.itemCode = itmCode;
	}

	public int hashcode() {
		System.out.println("In hashcode");
		int hashcode = 0;
		hashcode = itemCode * 20;
		hashcode += item.hashCode();

		System.out.println("Hashcode for " + itemCode + " is " + hashcode);
		return hashcode;
	}

	public boolean equals(Object obj) {

		if (obj instanceof PriceForHashCodeImplementation) {
			PriceForHashCodeImplementation price = (PriceForHashCodeImplementation) obj;
			return (price.item.equals(this.item) && price.itemCode == this.itemCode);
		} else {
			return false;
		}
	}

}
