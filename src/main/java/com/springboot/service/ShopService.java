package com.springboot.service;

import java.util.List;

import com.springboot.model.Shop;

/**
 * code written by supreeth.goud */
public interface ShopService{
	Shop saveShop(Shop shop);
	List<Shop> getAllShop();
	/** 
	 * code written by Snigdha.sree*/
	
	Shop getShopById(long id);
	Shop updateShop(Shop shop,long id);
	void deleteShop(long id);
	
	String calculateTotal(String gst,String itemPrice);
	

}

