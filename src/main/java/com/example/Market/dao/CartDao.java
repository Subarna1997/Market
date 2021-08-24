package com.example.Market.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Market.model.Cart;

@Transactional
@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

}
