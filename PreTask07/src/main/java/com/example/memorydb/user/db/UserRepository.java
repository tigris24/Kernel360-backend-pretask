package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface  UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    // select * from user where score >= ?? AND score <= ??
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int score, int score2);

    @Query(
//            value = "select u from user u where u.score >= ?1 AND u.score <= ?2",
            value = "select * from user as u where u.score >= min AND u.score <= max",
            nativeQuery = true
    )
    List<UserEntity> score(@Param(value="min") int min,
                           @Param(value="max") int max);
}
