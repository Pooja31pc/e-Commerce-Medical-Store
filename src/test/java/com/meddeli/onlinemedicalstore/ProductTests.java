package com.meddeli.onlinemedicalstore;

import com.meddeli.onlinemedicalstore.model.Brand;
import com.meddeli.onlinemedicalstore.model.Category;
import com.meddeli.onlinemedicalstore.model.Product;
import com.meddeli.onlinemedicalstore.repository.BrandRepository;
import com.meddeli.onlinemedicalstore.repository.CategoryRepository;
import com.meddeli.onlinemedicalstore.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
public class ProductTests {

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Test
    public void testCreateBrand(){
        Brand brand = new Brand("Pooja");
        brandRepo.save(brand);
    }

    @Test
    public void testCreateCategory(){
        Category category = new Category("Hair Care");
        categoryRepo.save(category);
    }

//    @Test
//    public void findCategoryByName() {
//        String name = "Ayurveda";
//        Category category = categoryRepo.findByName(name);
//        assert(category.getCategoryName()).equals(name);
//    }


}
