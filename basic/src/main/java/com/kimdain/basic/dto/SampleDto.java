package com.kimdain.basic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// Request Body로 받는 데이터에 대한 유효성 검사를 validation 의존성을 추가 해야함
public class SampleDto {
    @NotNull // 해당 속성을 null이 올 수 없도록 지정
    private String notNull;

    @NotEmpty // 문자열일 경우 null 또는 빈 문자열이 올 수 없도록 지정
    private String notEmpty;

    @NotBlank // 문자열일 경우 null 또는 빈 문자열 또는 공백으로된 문자열이 올 수 없도록 지정
    private String notBlank;

    // RequestBody로 받아오는 데이터는 Wrapper 클래스 타입으로 데이터를 받는 것이 좋음
    @NotNull
    //@NotEmpty @NotBlank는 문자열에서만 유효함
    private Integer requiredInt;

    @Length(min=5, max=10)
    @NotNull // 문자열일 경우 문자열 길이의 최소 최대를 지정 (null 값이면 검사 안함)
    private String length;


    @NotNull
    // 최댓값과 최솟값
    @Max(100)
    @Min(0)
    private Integer maxMin;

    @NotNull
    // 최대 최소 범위를 지정
    @Range(min=0, max= 100)
    private Integer range;

    @NotEmpty
    // 문자열이 이메일 형식인지 확인
    @Email
    private String email; 
    
    // 정규식을 이용해 문자열의 패턴 검사를 진행
    // 전화번호, 이메일, url, 주민등록번호, 비밀번호
    // 영어로만된 문자열, 한글로만된 문자열, 숫자로만 된 문자열
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-z]{2,4}$")  // 알파벳 대소문자,숫자0~9까지 올수있다
    private String emailPattern;

}
