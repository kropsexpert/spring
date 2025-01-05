
package com.dataservice.repository;

import com.dataservice.dao.UserInput;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInput, Long> {
//    @Modifying
//    @Query("INSERT INTO user_input (content) VALUES (:content)")
//    boolean insertContent(@Param("content") String content);
}