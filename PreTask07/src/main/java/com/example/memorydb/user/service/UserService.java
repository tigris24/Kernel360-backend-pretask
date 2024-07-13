package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity save(@RequestBody UserEntity userEntity) {
        // save
        return userRepository.save(userEntity);
    }


    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void delete(UserEntity id) {
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> filterScore(int score){
        return userRepository.findAllByScoreGreaterThanEqual(score);
    }
    public List<UserEntity> filterScore(int score1, int score2){
        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(score1, score2);
    }

    public List<UserEntity> filterScore2(int score1, int score2){
        return userRepository.score(score1, score2);
    }

}
