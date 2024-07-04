package com.biit.repositories;

import com.biit.entities.Employee;
import com.biit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	Optional<Employee> findByEmail(String email);

	Optional<Employee> findById(int id);
}