package com.meddeli.onlinemedicalstore.controller;

import com.meddeli.onlinemedicalstore.model.*;
import com.meddeli.onlinemedicalstore.model.User;
import com.meddeli.onlinemedicalstore.repository.*;
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

    @GetMapping("productid")
    private Optional<Product> getProductById(@RequestParam("id") long productid)
    {
        Optional<Product> productById = productRepo.findById(productid);
        return productById;
    }

    @GetMapping("categoryid")
    private Optional<Category> getCategoryById(@RequestParam("id") long categoryid)
    {
        Optional<Category> categoryById = categoryRepo.findById(categoryid);
        return categoryById;
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
//        }
        User userDetailsSave = null;
        userDetailsSave = userRepo.save(user);
        return userDetailsSave;
    }

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private CartFoodItemRepository cartFoodItemRepo;


    @PostMapping("addcartitem")
    public String postCartItem(@RequestBody AddItemUser addItemUser) {
        Optional<Product> product = productRepo.findById((long) addItemUser.getProductId());
        Optional<User> user = userRepo.findById((long) addItemUser.getUserId());
        if (user.isPresent()) {
            User userObj = user.get();
            List<Cart> carts = cartRepo.getUnorderedCartList(userObj);
            Cart cart;
            if (carts.size() < 1) {
                cart = cartRepo.save(new Cart(false, userObj));
            } else {
                cart = carts.get(0);
            }
            if (product.isPresent()) {
                Product medicine = product.get();
                CartFoodItem cartfoodItem = new CartFoodItem(addItemUser.getQuantity(), cart, medicine);
                cartFoodItemRepo.save(cartfoodItem);
                return "Success";
            }
        }
        return "Error";
    }


}
