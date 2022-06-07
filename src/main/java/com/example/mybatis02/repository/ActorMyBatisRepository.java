/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mybatis02.repository;

import com.example.mybatis02.model.Actor;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Victor Rosales
 */
@Mapper
public interface ActorMyBatisRepository {
    @Select("select * from actor")
    public List<Actor> findAll();
    
    @Select("SELECT * FROM actor WHERE idactor = #{id}")
    public Actor findById(long id);
    
    @Delete("DELETE FROM actor WHERE idactor = #{id}")
    public int deleteById(long id);
    
    @Insert("INSERT INTO actor(nombre, apellido, correo) " +
        " VALUES (#{nombre}, #{apellido}, #{correo})")
    public int insert(Actor post);
    
    @Update("Update actor SET nombre=#{nombre}, apellido=#{apellido}, correo=#{correo} where idactor=#{idactor}")
    public int update(Actor post);
}
