package com.xyz.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.product.model.Product;
import com.xyz.product.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductRepository productDb;

	// Save inforamtion of a product with comments
	@PostMapping("/SaveData")
	public String save(@RequestBody Product product) {

		String msg = " ";
		try {
			productDb.save(product);
			msg = "Product details Saved Successfully for " + product.getProduct_id();
		} catch (Exception e) {

			msg = " Error while saving the data in DB " + e.getMessage();

		}

		return msg;

	}

	// View saved product information

	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable String id) {
		int productId = Integer.parseInt(id);
		Optional<Product> obj1 = productDb.findById(productId);

		if (obj1.isPresent()) {

			return obj1.get();
		}
		return null;

	}

	// Update a product with comments of a saved product we can use post/put for
	// this case
	@PutMapping("/updateComments")
	public Product updateComments(@RequestBody Product product) {

		Optional<Product> pObj = productDb.findById(product.getProduct_id());

		if (pObj.isPresent()) {

			Product prodObj = pObj.get();
			prodObj.setComments(product.getComments()); // Only updating Comments based on id and save /Return
			return productDb.save(prodObj);
		} else {
			// If the id is not present then insert the data into DB
			return productDb.save(product);

		}

	}

	// Delete a saved product - first verify in a DB if the record is present then
	// delete
	@DeleteMapping("/deleteById/{id}")
	public String deleteProductById(@PathVariable String id) {
		int productId = Integer.parseInt(id);
		Optional<Product> obj1 = productDb.findById(productId);

		if (obj1.isPresent()) {

			productDb.deleteById(productId);
			return "Data deleted successfully for " + id;
		} else {

			return "Data item is not found for " + id;
		}

	}

//  Search product details based on Product Type and product name

	@GetMapping("/searchInfo/{productType}/{productName}")
	public Product findAllByProductTypeName(@PathVariable("productType") String productType,
			@PathVariable("productName") String productName) {

		Optional<Product> srchObj = productDb.findByProductTypeAndProductName(productType, productName);

		if (srchObj.isPresent()) {
			return srchObj.get();
		} else {
			return null;
		}

	}

}