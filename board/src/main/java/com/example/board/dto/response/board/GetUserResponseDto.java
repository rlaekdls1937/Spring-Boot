package com.example.board.dto.response.board;

import com.example.board.dto.response.ResponseDto;
import com.example.board.entity.UserEntity;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class GetUserResponseDto extends ResponseDto{
    private String email;
    private String nickname;
    private String profileImage;

    private GetUserResponseDto(UserEntity userEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImage = userEntity.getProfileImageUrl();
    }
    public static ResponseEntity<GetUserResponseDto> success(UserEntity userEntity) {
        GetUserResponseDto body = new GetUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
