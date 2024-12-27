package com.vinay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stockrepo extends JpaRepository<Stock, Integer>{

}
