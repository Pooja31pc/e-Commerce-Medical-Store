package com.meddeli.onlinemedicalstore.controller;

import com.meddeli.onlinemedicalstore.model.*;
import com.meddeli.onlinemedicalstore.repository.AdminRepository;
import com.meddeli.onlinemedicalstore.repository.BrandRepository;
import com.meddeli.onlinemedicalstore.repository.CategoryRepository;
import com.meddeli.onlinemedicalstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
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
    public List<Product> getProduct()
    {
        List<Product> product =  productRepo.findAll();

        return product;
    }

//    public Optional<Product> deleteProduct(@RequestParam("id") long productid) {
//        Optional<Product> removedStore = productRepo.findById(productid);
//        productRepo.deleteByProductId(productid);
//        return removedStore;
//    }
//@CrossOrigin(originPatterns = "http://localhost:4200")
    @GetMapping("deletebrand")
    public Optional<Brand> deleteBrand(@RequestParam("id") long brandid) {
       Optional<Brand> brandRecord = brandRepo.findById(brandid);
        brandRepo.deleteByBrandId(brandid);
        return brandRecord;
    }

    @GetMapping("deletecategory")
    public Optional<Category> deleteCategory(@RequestParam("id") long categoryid) {
        Optional<Category> categoryRecord = categoryRepo.findById(categoryid);
        categoryRepo.deleteByCategoryId(categoryid);
        return categoryRecord;
    }

    @PostMapping("addbrand")
    public Brand addBrand(@RequestBody Brand brand) {
            Brand brandRecord = brandRepo.save(brand);
        return brandRecord;
    }

    @PostMapping("addcategory")
    public Category addCategory(@RequestBody Category category) {
        Category categoryRecord = categoryRepo.save(category);
        return categoryRecord;
    }

    //@CrossOrigin(originPatterns = "http://localhost:4200")
    @PostMapping("addproduct")
    public Product postProduct(@RequestBody AddProductAdmin addProductAdmin){
        Optional<Category> category = categoryRepo.findById(addProductAdmin.getCategory_id());
        Optional<Brand> brand = brandRepo.findById(addProductAdmin.getBrand_id());

        Category categoryProduct = category.get();
        Brand brandProduct = brand.get();
        Product product = new Product(addProductAdmin.getSku(), addProductAdmin.getName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), categoryProduct, brandProduct);
        Product productRecord = null;
        if (category.isPresent()&&brand.isPresent())
//                Category categoryProduct = category.get();
//                Brand brandProduct = brand.get();
//                Product product = new Product(addProductAdmin.getSku(), addProductAdmin.getName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), categoryProduct, brandProduct);
            productRecord = productRepo.save(product);
        //System.out.println(productRecord);
                return productRecord;
//        Product product =new Product();
//        productRepo.save(product);
//        return "Success";

    }
//    @GetMapping("productbyid")
//    public Product getProductById(@RequestParam("id") Product product){
//       // List<Product> product = productRepo.findById(id);
//        return product;
//    }

    //fetch product by id
    @GetMapping("productbyid")
    private Optional<Product> getBrandById(@RequestParam("id") long id)
    {
        Optional<Product> product = productRepo.findById(id);

        return product;
    }

    //dlt product by product Id
    //@CrossOrigin(originPatterns = "http://localhost:4200")
    @GetMapping("deleteproduct")
    public Optional<Product> deleteProduct(@RequestParam("id") long productid) {
        Optional<Product> removedStore = productRepo.findById(productid);
        productRepo.deleteByProductId(productid);
        return removedStore;
    }
    //{"success":false;};


    //dlt all products of a particular brand id --- postman baki hai
    @DeleteMapping("deleteallproductbybrand")
    public String deleteAllProductByBrand(@RequestParam("id") long brandid)
    {
        productRepo.deleteByBrandId(brandid);
        return "success.";
    }

    //dlt all products of a particular category id --- postman baki hai
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

    //UPDATE SOLUTION 0
//@PutMapping("updateproduct")
//public Product updateProduct(@RequestParam("id") long id){
//    Optional<Product> product = productRepo.findById(id);
//
//    AddProductAdmin addProductAdmin = null;

//    Optional<Category> category = categoryRepo.findById(addProductAdmin.getCategory_id());
//    Optional<Brand> brand = brandRepo.findById(addProductAdmin.getBrand_id());

//    Category categoryProduct = category.get();
//    Brand brandProduct = brand.get();
//    Product product = new Product(addProductAdmin.getSku(), addProductAdmin.getName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), categoryProduct, brandProduct);
//    Product productRecord = null;
//    if (category.isPresent()&&brand.isPresent())
//                Category categoryProduct = category.get();
//                Brand brandProduct = brand.get();
//                Product product = new Product(addProductAdmin.getSku(), addProductAdmin.getName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), categoryProduct, brandProduct);
//        productRecord = productRepo.save(product);
//        product.setSku(addProductAdmin.getSku());
//        product.setName(addProductAdmin.getName());
//        product.setDescription(addProductAdmin.getDescription());
//        product.setUnitPrice(addProductAdmin.getUnitPrice());
//        product.setImageUrl(addProductAdmin.getImageUrl());
//        product.setActive(addProductAdmin.isActive());
//        product.setUnitsInStock(addProductAdmin.getUnitsInStock());
////        product.setCategory(addProductAdmin.categoryProduct);
////            product.setBrand(productDetails.getBrand());
//
//    Product updatedProduct = productRepo.save(product);
//    return updatedProduct;
//}

//UPDATE SOLUTION 1
//    @PutMapping("/updateproduct/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
//        Product product = productRepo.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
//
//        product.setSku(productDetails.getSku());
//        product.setName(productDetails.getName());
//        product.setDescription(productDetails.getDescription());
//        product.setUnitPrice(productDetails.getUnitPrice());
//        product.setImageUrl(productDetails.getImageUrl());
//        product.setActive(productDetails.isActive());
//        product.setUnitsInStock(productDetails.getUnitsInStock());
//        product.setCategory(productDetails.getCategory());
//        product.setBrand(productDetails.getBrand());
//
//        Product updatedProduct = productRepo.save(product);
//        return ResponseEntity.ok(updatedProduct);
//    }

//UPDATE SOLUTION 2
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
//                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employee.setEmailId(employeeDetails.getEmailId());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
//        final Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }

    @PutMapping("updateproduct")
    public Product updateProduct(@RequestParam("id") long productId, @RequestBody AddProductAdmin addProductAdmin) {
//        Optional<Category> category = categoryRepo.findById(addProductAdmin.getCategory_id());
//        Optional<Brand> brand = brandRepo.findById(addProductAdmin.getBrand_id());
        Product product = productRepo.findByProductId(productId);
//        Category categoryProduct = category.get();
//        Brand brandProduct = brand.get();
//        Product product = new Product(addProductAdmin.setSku(addProductAdmin.getSku()), addProductAdmin.getName(), addProductAdmin.getDescription(), addProductAdmin.getUnitPrice(), addProductAdmin.getImageUrl(), addProductAdmin.isActive(), addProductAdmin.getUnitsInStock(), categoryProduct, brandProduct);
        product.setSku(addProductAdmin.getSku());
        product.setName(addProductAdmin.getName());
        product.setDescription(addProductAdmin.getDescription());
        product.setUnitPrice(addProductAdmin.getUnitPrice());
        product.setImageUrl(addProductAdmin.getImageUrl());
        product.setActive(addProductAdmin.isActive());
        product.setUnitsInStock(addProductAdmin.getUnitsInStock());
        Product productRecord = null;

        productRecord = productRepo.save(product);
        //System.out.println(productRecord);
        return productRecord;
    }


}
