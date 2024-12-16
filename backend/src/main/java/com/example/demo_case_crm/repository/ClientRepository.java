package com.example.demo_case_crm.repository;

import com.example.demo_case_crm.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Optional<Client> findByEmail(String email);

    Optional<Client> findByPhone(String phone);

    Optional<Client> findByClaimsId(int id);

}