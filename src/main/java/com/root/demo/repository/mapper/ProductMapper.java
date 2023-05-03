package com.root.demo.repository.mapper;

import com.root.demo.repository.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductMapper {
    @Select("select * from product")
    List<Product> findAll();

    @Select("select * from product where id = #{id}")
    Product findById(Integer id);

    @Insert("insert into product (id, description, amount) values (DEFAULT, #{description}, #{amount})")
    @Options(useGeneratedKeys=true, keyColumn="id")
    int save(Product product);
}
