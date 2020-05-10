package com.xyz.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyz.product.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {


	//custom method to handle 2 strings from DB  
	//Commenting the below code and using the Query to get the data..
	
	//public Optional<Product> findByProductTypeAndProductName(String productType, String productName);
	
	@Query("SELECT t from Product t where t.productType = :productType and t.productName = :productName")
	public Optional<Product> findByProductTypeAndProductName(@Param("productType")String productType,
															 @Param("productName")String productName);
	

	

}
