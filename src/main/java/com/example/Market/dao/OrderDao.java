package com.example.Market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Market.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

}
