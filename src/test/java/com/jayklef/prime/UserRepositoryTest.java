package com.jayklef.prime;

import com.jayklef.prime.entity.Student;
import com.jayklef.prime.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private StudentRepository productRepository;

    @Test
    public void addNewProduct(){

        Student product = new Student();
        product.setFirstname("Laptop");
        product.setTelephone("Computer Accessories");
        product.setAmount(BigDecimal.valueOf(200000));
        product.setAddress(new Date(2022-04-23));

        Student savedProduct = productRepository.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        List<Student> products = productRepository.findAll();
        Assertions.assertThat(products).hasSizeGreaterThan(0);


        for (Student product: products){
            System.out.println(product);
        }
    }

    @Test
    public void updateProduct(){
        Integer productId = 1;
        Optional<Student> Product1 = productRepository.findById(productId);
        Student product = Product1.get();
        product.setFirstname("Garri");
        productRepository.save(product);

        Student updatedProduct = productRepository.findById(productId).get();
        Assertions.assertThat(updatedProduct.getFirstname()).isEqualTo("Garri");
    }

    @Test
    public void findProduct(){
        Integer productId = 2;
        Optional<Student> optionalProduct = productRepository.findById(productId);

        Assertions.assertThat(optionalProduct).isPresent();
        System.out.println(optionalProduct.get());
    }

    @Test
    public void  deleteProduct(){
        Integer productId = 1;
        productRepository.deleteById(productId);

        Optional<Student> deletedProduct = productRepository.findById(productId);

        Assertions.assertThat(deletedProduct).isNotPresent();
    }
}
