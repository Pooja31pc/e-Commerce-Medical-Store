package com.meddeli.onlinemedicalstore.controller;

import com.meddeli.onlinemedicalstore.model.AddProductAdmin;
import com.meddeli.onlinemedicalstore.model.Brand;
import com.meddeli.onlinemedicalstore.model.Category;
import com.meddeli.onlinemedicalstore.model.Product;
import com.meddeli.onlinemedicalstore.repository.BrandRepository;
import com.meddeli.onlinemedicalstore.repository.CategoryRepository;
import com.meddeli.onlinemedicalstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("category")
    public List<Category> getCategory()
    {
        List<Category> category = (List<Category>) categoryRepo.findAll();

        return category;
    }

    @Autowired
    private BrandRepository brandRepo;

    @GetMapping("brand")
    public List<Brand> getBrand()
    {
        List<Brand> brand = (List<Brand>) brandRepo.findAll();

        return brand;
    }

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("product")
    public List<Product> getProduct()
    {
        List<Product> product =  productRepo.findAll();

        return product;
    }


    @PostMapping("addproduct")
    public String postProduct(@RequestBody AddProductAdmin addProductAdmin){
        Optional<Category> category = categoryRepo.findById(addProductAdmin.getCategoryId());
        Optional<Brand> brand = brandRepo.findById(addProductAdmin.getBrandId());

        if (category.isPresent()&&brand.isPresent()) {
                Category categoryProduct = category.get();
                Brand brandProduct = brand.get();
                Product product = new Product(addProductAdmin.getSku(), addProductAdmin.getProductName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), addProductAdmin.getCreatedOn(), addProductAdmin.getUpdatedOn(), categoryProduct, brandProduct);
                productRepo.save(product);
                return "Success";

        }

//        if (category.isPresent()) {
//            Category categoryProduct = category.get();
//            if (brand.isPresent()) {
//                Brand brandProduct = brand.get();
//                Product product = new Product(addProductAdmin.getSku(), addProductAdmin.getProductName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), addProductAdmin.getCreatedOn(), addProductAdmin.getUpdatedOn(), categoryProduct, brandProduct);
//                productRepo.save(product);
//                return "Success";
//            }
//        }
        Product product =new Product();
        productRepo.save(product);
        return "Success";

    }



}
