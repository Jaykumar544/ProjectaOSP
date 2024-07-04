package com.biit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biit.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findByEmail(String email);
	Optional<User> findById(int id);


}