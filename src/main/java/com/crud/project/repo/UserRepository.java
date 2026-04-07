package com.crud.project.repo;

import com.crud.project.entity.Order;
import com.crud.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("select o from order o where o.orderId = : orderId")
    Optional<Order> findByOrderId(String orderId);

}
