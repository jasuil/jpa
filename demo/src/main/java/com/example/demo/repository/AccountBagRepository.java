package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AccountBagRepository extends CrudRepository<AccountBag, Long>, JpaSpecificationExecutor<AccountBag> {
}
