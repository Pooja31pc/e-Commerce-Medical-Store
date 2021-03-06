package com.meddeli.onlinemedicalstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

//   public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
//       config.exposeIdsFor(Book.class);
//       config.exposeIdsFor(BookCategory.class);
//   }

    @Autowired
    private EntityManager entityManager;

    @Value("${url}")
    private String accessUrl;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
                .map(Type::getJavaType)
                .toArray(Class[]::new));

        config.getCorsRegistry()
                .addMapping("/**")
                //.allowedOrigins("http://localhost:4200");
                .allowedOrigins(accessUrl);

//        config.getCorsRegistry()
//                .addMapping("/admin**")
//                .allowedOrigins("http://localhost:4200");
    }

}
