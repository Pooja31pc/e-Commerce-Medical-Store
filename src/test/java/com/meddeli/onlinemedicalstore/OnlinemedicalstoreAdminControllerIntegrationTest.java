package com.meddeli.onlinemedicalstore;

import com.meddeli.onlinemedicalstore.model.Brand;
import com.meddeli.onlinemedicalstore.model.Category;
import com.meddeli.onlinemedicalstore.model.Product;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlinemedicalstoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class OnlinemedicalstoreAdminControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

//    @LocalServerPort
//    private int port;

    private String postProductUrl() {
        return "http://localhost:8484/admin/addproduct";
    }

    private String postBrandUrl() {
        return "http://localhost:8484/admin/addbrand";
    }

    private String postCategoryUrl() {
        return "http://localhost:8484/admin/addcategory";
    }

    private String getProductUrl() {
        return "http://localhost:8484/admin/product";
    }

    private String deleteProductUrl() {
        return "http://localhost:8484/admin/deleteproduct";
    }

    private String deleteBrandUrl() {
        return "http://localhost:8484/admin/deletebrand";
    }

    private String deleteCategoryUrl() {
        return "http://localhost:8484/admin/deletecategory";
    }

    private String getBrandUrl() {
        return "http://localhost:8484/admin/brand";
    }

    private String getCategoryUrl() {
        return "http://localhost:8484/admin/category";
    }

    @Test
    public void contextLoads() {

    }

    //test for fetching all products
    @Test
    public void testGetAllProducts() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getProductUrl(),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    //test for fetching all brands
    @Test
    public void testGetAllBrands() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getBrandUrl(),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    //test for fetching all categories
    @Test
    public void testGetAllCategories() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getCategoryUrl(),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    //test to delete product by id
    @Test
    public void testDeleteProduct() {
        int id = 69;
        Product product = restTemplate.getForObject(deleteProductUrl() + id, Product.class);
        assertNotNull(product);
        restTemplate.delete(deleteProductUrl() + id);
        try {
            product = restTemplate.getForObject(deleteProductUrl() + id, Product.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    //test to delete brand by id
    public void testDeleteBrand() {
        int id = 1;
        Brand brand = restTemplate.getForObject(deleteBrandUrl() + id, Brand.class);
        assertNotNull(brand);
        restTemplate.delete(deleteBrandUrl() + id);
        try {
            brand = restTemplate.getForObject(deleteBrandUrl() + id, Brand.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    //test to delete category by id
    public void testDeleteCategory() {
        int id = 1;
        Brand brand = restTemplate.getForObject(deleteCategoryUrl() + id, Brand.class);
        assertNotNull(brand);
        restTemplate.delete(deleteCategoryUrl() + id);
        try {
            brand = restTemplate.getForObject(deleteCategoryUrl() + id, Brand.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    //test to create product
    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setSku("personalcare-108");
        product.setName("Vaseline");
        product.setDescription("Vaseline petroleum jelly rewind");
        product.setImageUrl("assets/images/personalcare/personalcare-107.jpg");
        product.isActive();
        product.setUnitPrice(new BigDecimal(212));
        product.setUnitsInStock(5);
        product.setCategory(new Category("5"));
        product.setBrand(new Brand("13"));
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(postProductUrl(), product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    //test to create brand
    @Test
    public void testCreateBrand() {
        Brand brand = new Brand();
        brand.setBrandName("Pooja");
        ResponseEntity<Brand> postResponse = restTemplate.postForEntity(postBrandUrl(), brand, Brand.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    //test to create category
    @Test
    public void testCreateCategory() {
        Category category = new Category();
        category.setCategoryName("POOJA");
        ResponseEntity<Category> postResponse = restTemplate.postForEntity(postCategoryUrl(), category, Category.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }



}
