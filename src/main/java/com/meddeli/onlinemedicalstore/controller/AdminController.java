package com.meddeli.onlinemedicalstore.controller;

import com.meddeli.onlinemedicalstore.model.*;
import com.meddeli.onlinemedicalstore.repository.AdminRepository;
import com.meddeli.onlinemedicalstore.repository.BrandRepository;
import com.meddeli.onlinemedicalstore.repository.CategoryRepository;
import com.meddeli.onlinemedicalstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
   // @CrossOrigin(originPatterns = "http://localhost:4200")
    @GetMapping("product")
    public List<Product> getProduct( HttpServletRequest request)
    {
        List<Product> product =  productRepo.findAll();

        return product;
    }

    @DeleteMapping("deletebrand")
    public String deleteBrand(@RequestParam("id") long brandId) {
        brandRepo.deleteById(brandId);

        return "Success";
    }

    @DeleteMapping("deletecategory")
    public String deleteCategory(@RequestParam("id") long categoryId) {
        brandRepo.deleteById(categoryId);

        return "Success";
    }

    @PostMapping("addbrand")
    public String addBrand(@RequestBody Brand brand) {
            return "Success";
    }

    @PostMapping("addcategory")
    public String addCategory(@RequestBody Category category) {
        return "Success";
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

    //dlt product by product Id
    @DeleteMapping("deleteprodut")
    public String deleteProduct(@RequestParam("id") long productid) {
        productRepo.deleteById(productid);
        return "success.";
    }

    //dlt all products of a particular brand id
    @DeleteMapping("deleteallproductbybrand")
    public String deleteAllProductByBrand(@RequestParam("id") long brandid)
    {
        productRepo.deleteByBrandId(brandid);
        return "success.";
    }

    //dlt all products of a particular category id
    @DeleteMapping("deleteallproductbycategory")
    public String deleteAllProductByCategory(@RequestParam("id") long categoryid)
    {
        productRepo.deleteByCategoryId(categoryid);
        return "success.";
    }

    @Autowired
    private AdminRepository adminRepo;

    @PostMapping("registeradmin")
    private Admin registerAdmin(@RequestBody Admin admin)
    {
        Admin adminDetailsSave = null;
        adminDetailsSave = adminRepo.save(admin);

        return adminDetailsSave;
    }

//    @PostMapping("loginadmin")
//    private Admin loginAdmin(@RequestBody Admin admin)
//    {
//        String tempEmailId = admin.getEmailid();
//        String tempPassword = admin.getPassword();
//        Admin admintemp = null;
//        if(tempEmailId!=null && tempPassword!=null){
//            admintemp =  adminRepo.fetchUserByEmailAndPassword(tempEmailId,tempPassword);
//        }
//
//       return admintemp;
   // }


}
