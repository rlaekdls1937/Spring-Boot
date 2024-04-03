package com.example.board.service.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.board.GetUserResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email){

        //UserEntity userEntity = null;

        try {
        // 1. User 테이블에서 email 해당하는 유저 조회
        // SELECT * FROM user WHERE email = :email
        // findByEmail(email)
        // (email -> (조회 결과 인스턴스))    
            UserEntity userEntity = userRepository.findByEmail(email);

        // 2. 조회 결과에 따라 반환 결정
        // 1) false이면 존재하지 않는 유저 응답처리 x
        // 2) null 이면 존재하지 않는 유저 응답처리
            if(userEntity == null) return ResponseDto.notExistUser();

        // 3. 조회 결과 데이터를 성공 응답
        
            return GetUserResponseDto.success(userEntity);

        } catch (Exception exception) {
            // 1-1. 조회 처리 중 데이터베이스관련 예외가 발생하면 데이터베이스 에러 응답처리
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        

        

    }    
}

// 사용자로부터 email 입력
// ---------------------------

// 성공
// 존재하지 않는 유저
// 데이터베이스 에러