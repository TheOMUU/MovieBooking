package com.movieBooking.movie.repository;

import com.movieBooking.movie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByName(@Param("name") String name);
    @Query("SELECT u FROM User u WHERE u.name = :name AND u.age = :age")
    List<User> findUserByNameAndAge(@Param("name") String name, @Param("age") Integer age);
    @Query("SELECT u FROM User u WHERE u.age BETWEEN :minAge AND :maxAge")
    List<User> findUserAgeRange(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
    @Query("SELECT u FROM User u WHERE u.age >= :minAge ORDER BY u.age DESC")
    List<User> findSortedUser(@Param("minAge") Integer minAge);
    @Query("SELECT u FROM User u WHERE u.age IN :ages")
    List<User> findUserAgeIn(@Param("ages") List<Integer> ages);

}
