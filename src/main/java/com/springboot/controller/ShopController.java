package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Shop;
import com.springboot.service.ShopService;


/**
 * code written by supreeth.goud */

@RestController
@RequestMapping("/api/shop")
public class ShopController{
	
	private ShopService shopService;

	public ShopController(ShopService shopService) {
		super();
		this.shopService = shopService;
	}
	
	//build create shop REST API

	
	@PostMapping()
	public ResponseEntity<Shop> saveShop(@RequestBody Shop shop){
		
	return new ResponseEntity<Shop>(shopService.saveShop(shop),HttpStatus.CREATED);
	}
	
	//build get all shop REST API
	@GetMapping
	public List<Shop>getAllShop(){
		return shopService.getAllShop();
	}
		
	//build get shop by id REST API
	/** 
	 * code written by Snigdha.sree*/
	
	@GetMapping("{id}")
	public ResponseEntity<Shop> getShopById(@PathVariable("id") long itemId){
	     return new ResponseEntity<Shop>(shopService.getShopById(itemId),HttpStatus.OK);
	}
	
	//build update shop Rest API
	
	@PutMapping("{id}")
	public ResponseEntity<Shop> updateShop(@PathVariable("id") long id
		                                  ,@RequestBody Shop shop){
		    return new ResponseEntity<Shop>( shopService.updateShop(shop, id),HttpStatus.OK);                           	  
		 }
	//build delete shop REST API 

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteShop(@PathVariable("id") long id){
		
		//delete shop from DB
		shopService.deleteShop(id);
		return new ResponseEntity<String>("item "+id+" deleted successfully!.",HttpStatus.OK);
	}
	}
