package com.FSD.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepositories extends JpaRepository<Product , Long> {
}


