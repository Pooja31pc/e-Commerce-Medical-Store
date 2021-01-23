package com.meddeli.onlinemedicalstore;

import com.meddeli.onlinemedicalstore.model.Brand;
import com.meddeli.onlinemedicalstore.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlinemedicalstoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class OlineMedicalStoreUserControllerINtegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String getProductsByBrandUrl() {
        return "http://localhost:8484/user/brandproducts";
    }

    private String getProductByIdUrl() { return "http://localhost:8484/user/productid"; }

    private String getProductUrl() {
        return "http://localhost:8484/user/product";
    }

    private String getBrandUrl() {
        return "http://localhost:8484/user/brand";
    }

    private String getCategoryUrl() {
        return "http://localhost:8484/user/category";
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

    //test for fetching product by product id
    @Test
    public void testGetProductById() {
        Product product = restTemplate.getForObject(getProductByIdUrl() + "/6", Product.class);
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        assertNotNull(product);
    }

    //test for fetching products by brand id
    @Test
    public void testGetProductsByBrandId() {
        Brand brand = restTemplate.getForObject( getProductsByBrandUrl() + "/1", Brand.class);
//        System.out.println(product.getName());
//        System.out.println(product.getDescription());
        assertNotNull(brand);
    }

}
