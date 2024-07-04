package com.biit.repositories;

import com.biit.entities.Feedback;
import com.biit.entities.Product;
import com.biit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    public List<Product> findByName(String name);
    public List<Product> findByType(String type);

    Optional<Product> findById(int id);
    public List<Product> findByNameAndType(String name,String type);
}