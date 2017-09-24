package com.lyg.bookstore;

import com.lyg.bookstore.dao.BaseRepositoryFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@MapperScan("com.lyg.bookstore.mapper")
@EnableJpaRepositories(basePackages = {"com.lyg.bookstore.dao"},
        repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
