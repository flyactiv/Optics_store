package com.example.ocharickmvcweb.repo;

import com.example.ocharickmvcweb.models.NewOrders;
import org.springframework.data.repository.CrudRepository;

public interface orderRepository extends CrudRepository<NewOrders, Long> {

}
