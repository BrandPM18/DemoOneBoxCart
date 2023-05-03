package com.root.demo.repository.mapper;

import com.root.demo.repository.model.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface CartMapper {

    @Select("select * from cart")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property="products", column = "products"),
            @Result(property="totalPrice", column = "final_amount"),
            @Result(property="creationDate", column = "creation_date"),
            @Result(property="modificationDate", column = "modification_date"),
            @Result(property="creationUser", column = "creation_user"),
            @Result(property="modificationUser", column = "modification_user")
    })
    List<Cart> findAll();

    @Select("select * from cart where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property="products", column = "products"),
            @Result(property="totalPrice", column = "final_amount"),
            @Result(property="creationDate", column = "creation_date"),
            @Result(property="modificationDate", column = "modification_date"),
            @Result(property="creationUser", column = "creation_user"),
            @Result(property="modificationUser", column = "modification_user")
    })
    Cart findById(String id);

    @Insert("insert into cart (id, products, final_amount, creation_date, modification_date, creation_user, modification_user) " +
            "values (#{id}, #{products}, #{totalPrice}, current_timestamp, current_timestamp, #{creationUser}, #{modificationUser})")
    int save(Cart cart);

    @Update("update cart set products = #{products}, final_amount = #{totalPrice}, modification_date = current_timestamp, modification_user = #{modificationUser} where id = #{id}")
    int update(Cart cart);

    @Delete("delete from cart where id = #{id}")
    int deleteById(String id);
}
