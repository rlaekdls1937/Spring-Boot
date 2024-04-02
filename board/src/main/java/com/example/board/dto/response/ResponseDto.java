package com.example.board.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.board.GetLatestListResponseDto;
import com.example.board.dto.response.board.ResponseCode;
import com.example.board.dto.response.board.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {
    private String code;
    private String message;
    public static ResponseEntity<? super GetLatestListResponseDto> databaseError() {  
        ResponseDto body = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
        public static ResponseEntity<ResponseDto> notExistUser(){
            ResponseDto body = new ResponseDto(ResponseCode.NOT_EXIST_USER,ResponseMessage.NOT_EXIST_USER);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
        }
}