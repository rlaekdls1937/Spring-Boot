package com.example.board.dto.response.board;

import com.example.board.dto.response.ResponseDto;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class GetUserResponseDto extends ResponseDto{
    private String email;
    private String nickname;
    private String profileImage;

    private GetUserResponseDto(String email, String nickname, String profileImage){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = email;
        this.nickname = nickname;
        this.profileImage = profileImage;
    }
    public static ResponseEntity<GetUserResponseDto> success(String email, String nickname, String profileImage) {
        GetUserResponseDto body = new GetUserResponseDto(email, nickname, profileImage);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
