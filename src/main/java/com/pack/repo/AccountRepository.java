package com.pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.CustomerDetails;
@Repository
public interface AccountRepository extends JpaRepository<CustomerDetails, Integer> {
public CustomerDetails findByAccountNo(Integer account);
}
