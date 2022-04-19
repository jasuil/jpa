package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BagRepository extends CrudRepository<Bag, Long>, JpaSpecificationExecutor<Bag> {
}
