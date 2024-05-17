package dev.patika.spring.dao;

import dev.patika.spring.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
//burda springden faydalaniyoruz, crud islemlerini metodun ismine tanimlayarak arama yaptiriyoruiz. Mail objectin variable ismiyle ayni olmak zorunda!
    Customer findByMail(String mail);

}
