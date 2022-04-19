package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository to manage {@link Account} instances.
 *
 * @author jasuil
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
    /**
     * left outer join
     *
     * @param customerId
     * @return Account
     */
    @Query(value = "select c.firstname, c.lastname, account.* from customer c  "
                   + "left outer join (select max(account.id) as id, customer_id from account group by account.customer_id) a "
                   + "on a.customer_id = c.id "
                   + "left outer join account "
                   + "on a.id = account.id "
                   + "where c.id = ?", nativeQuery = true)
    Account getLastAccountByCustomerId(Long customerId);
}