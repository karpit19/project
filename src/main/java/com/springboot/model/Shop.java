package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * code written by supreeth.goud */
@Entity
@Table(name="shop",
uniqueConstraints=@UniqueConstraint(
		name="itemName_unique",
		columnNames = "itemName"
		)
		)
public class Shop {

    @Id
    /** 
     * code written by Arpit.katare*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    
    @Column(name = "itemName")
    private String itemName;
    
    @Column(name = "itemPrice")
    private String itemPrice;
    
    @Column(name = "gst")
    private String gst;
    
    @Column(name = "total")
    private String total;
    
    @Column(name = "expdate")
    private String expdate;
    
    
    
    
    public long getItemId() {
	  return itemId;
  }
    public void setItemId(long itemId) {
	  this.itemId = itemId;
  }
    public String getItemName() {
	  return itemName;
  }
    public void setItemName(String itemName) {
	  this.itemName = itemName;
  }
    public String getItemPrice() {
	  return itemPrice;
  }
    public void setItemPrice(String itemPrice) {
	  this.itemPrice = itemPrice;
  }
    public String getGst() {
	  return gst;
  }
    public void setGst(String gst) {
	  this.gst = gst;
  }
    public String getTotal() {
	  return total;
  }
    public void setTotal(String total) {
	  this.total = total;
  }
    public String getExpdate() {
	  return expdate;
  }
    public void setExpdate(String expdate) {
	  this.expdate = expdate;
  }
  }
