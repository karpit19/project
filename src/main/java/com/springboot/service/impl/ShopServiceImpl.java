package com.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.springboot.service.*;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.*;
import com.springboot.repository.ShopRepository;
/**
 * code written by supreeth.goud */
@Service
public class ShopServiceImpl implements ShopService {
	
	private ShopRepository shopRepository;
	
	
	
	public ShopServiceImpl(ShopRepository shopRepository) {
		super();
		this.shopRepository = shopRepository;
	}


	@Override
	public Shop saveShop(Shop shop) {
		shop.setTotal(calculateTotal(shop.getGst(),shop.getItemPrice() ));
		return shopRepository.save(shop);
}


	@Override
	public List<Shop> getAllShop() {
		return shopRepository.findAll();
	}

/**
 * code written by Snigdha.sree */
	@Override
	public Shop getShopById(long id) { 
	
//		Optional<Shop> shop = shopRepository.findById(id);
	   
//	    if(shop.isPresent()) {
//	    	return shop.get();
 //   }else {
		
//	   throw new ResourceNotFoundException("Shop", "Id",id);
 //      }
		return shopRepository.findById(id).orElseThrow(()  -> 
		           new ResourceNotFoundException("Shop", "Id", id));
		   
	   }


	@Override
	public Shop updateShop(Shop shop, long id) {
		Shop existingShop = shopRepository.findById(id).orElseThrow(
				()  -> new ResourceNotFoundException("Shop","ID", id));
		
		existingShop.setItemId(shop.getItemId());
		existingShop.setItemName(shop.getItemName());
		existingShop.setItemPrice(shop.getItemPrice());
		existingShop.setGst(shop.getGst());
		existingShop.setTotal(shop.getTotal());
		existingShop.setExpdate(shop.getExpdate());
		//save existing shop to DB
		shopRepository.save(existingShop);
	     return existingShop;
	}


	@Override
	public void deleteShop(long id) {
		
		//check whether a shop exist in DB or not
		shopRepository.findById(id).orElseThrow(() ->
		                     new ResourceNotFoundException("Shop","id",id));
		shopRepository.deleteById(id);
		
	}

	/* code is written by  Arpit Katare */
	@Override
	public String calculateTotal(String gst,String itemPrice) {
		double igst= Double.parseDouble(gst);
		double price=Double.parseDouble(itemPrice);
		
		double total=0.0;
		
		total=((igst/100.0)*price)+price;
		String totalprice=""+total;
		return totalprice; 	
		
	}
  }



	

