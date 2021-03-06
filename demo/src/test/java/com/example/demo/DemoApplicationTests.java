package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.repository.Account;
import com.example.demo.repository.AccountBag;
import com.example.demo.repository.AccountBagRepository;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.Bag;
import com.example.demo.repository.BagRepository;
import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BagRepository bagRepository;
    @Autowired
    private AccountBagRepository accountBagRepository;

    @Test
    void AccountSaveTest() {
        Customer customer = new Customer();
        customer.setFirstname("j");
        customer.setLastname("si");
        customerRepository.save(customer);

        Account account = new Account();
        account.setExpiryDate(LocalDate.of(2022, 4, 19));
        account.setCustomer(customer);
        accountRepository.save(account);
        long firstAccountId = account.getId();

        account = new Account();
        account.setExpiryDate(LocalDate.of(2022, 1, 12));
        account.setCustomer(customer);
        accountRepository.save(account);
        long lastAccountId = account.getId();

        Account lastAccountByCustomerId = accountRepository.getLastAccountByCustomerId(customer.getId());

        Assert.isTrue(lastAccountByCustomerId.getCustomer().getId().equals(customer.getId()), "bad1");
        Assert.isTrue(lastAccountByCustomerId.getId().equals(account.getId()), "bad2");
    }

    @Test
    public void accountBagEntityTest() {
        Customer customer = new Customer();
        customer.setFirstname("j");
        customer.setLastname("si");
        Account account = new Account();
        account.setExpiryDate(LocalDate.now());
        account.setCustomer(customer);

        accountRepository.save(account);
        customerRepository.save(customer);

        Bag bag = new Bag();
        bag.setCreateAt(LocalDateTime.now());
        bag.setName("?????????");
        bagRepository.save(bag);
        AccountBag accountBag = new AccountBag();
        accountBag.setAccount(account);
        accountBag.setBag(bag);
        accountBagRepository.save(accountBag);
        Iterable<AccountBag> list = accountBagRepository.findAll();
        Assert.isTrue(list.iterator().hasNext(), "good");
    }

}
