package com.market.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.api.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}
