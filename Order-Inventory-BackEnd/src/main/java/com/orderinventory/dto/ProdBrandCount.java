package com.orderinventory.dto;

public class ProdBrandCount {
	private int Id;
	private Long count;
	/**
	 * @param id
	 * @param count
	 */
	public ProdBrandCount(int id, Long count) {
		super();
		Id = id;
		this.count = count;
	}
	/**
	 * 
	 */
	public ProdBrandCount() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}
}
