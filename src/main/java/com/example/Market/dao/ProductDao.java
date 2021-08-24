package com.example.Market.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Market.model.Product;



@Transactional
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

  public List<Product> findByProductidAndCategory(Integer productid, String category);
}
