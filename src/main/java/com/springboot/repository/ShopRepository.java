package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Shop;
/** 
 * code written by Supreeth.goud*/
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
