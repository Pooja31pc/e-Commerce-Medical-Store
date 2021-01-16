package com.meddeli.onlinemedicalstore.controller;

import com.meddeli.onlinemedicalstore.model.Brand;
import com.meddeli.onlinemedicalstore.model.Category;
import com.meddeli.onlinemedicalstore.model.Product;
import com.meddeli.onlinemedicalstore.model.User;
import com.meddeli.onlinemedicalstore.repository.BrandRepository;
import com.meddeli.onlinemedicalstore.repository.CategoryRepository;
import com.meddeli.onlinemedicalstore.repository.ProductRepository;
import com.meddeli.onlinemedicalstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private BrandRepository brandRepo;

    @GetMapping("product")
    public List<Product> getProduct()
    {
        List<Product> product = (List<Product>) productRepo.findAll();

        return product;
    }

    @GetMapping("brand")
    public List<Brand> getBrand()
    {
        List<Brand> brand = (List<Brand>) brandRepo.findAll();

        return brand;
    }

    @GetMapping("category")
    public List<Category> getCategory()
    {
        List<Category> category = (List<Category>) categoryRepo.findAll();

        return category;
    }

    @GetMapping("brandid")
    private Optional<Brand> getBrandById(@RequestParam("id") long brandid)
    {
        Optional<Brand> brandById = brandRepo.findById(brandid);

        return brandById;
    }

    @GetMapping("brandproducts")
    private List<Product> getBrandProduct(@RequestParam("id") long brandid)
    {
        List<Product> brandProduct = productRepo.findByBrandProduct(brandid);

        return brandProduct;
    }

    @GetMapping("categoryproducts")
    private List<Product> getCategoryProduct(@RequestParam("id") long categoryid)
    {
        List<Product> categoryProduct = productRepo.findByCategoryProduct(categoryid);

        return categoryProduct;
    }

    @PostMapping("registeruser")
    private User registerUser(@RequestBody User user)
    {
//        to check if user already exists or not.
//        String tempEmail = user.getEmail();
//        if(tempEmail!=null && !"".equals(tempEmail)) {
//
//        }

        User userDetailsSave = null;
        userDetailsSave = userRepo.save(user);

        return userDetailsSave;
    }




}
