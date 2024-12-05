package com.chai.thymleaf.repositories;

import com.chai.thymleaf.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
