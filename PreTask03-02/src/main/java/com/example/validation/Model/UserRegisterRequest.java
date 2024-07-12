package com.example.validation.Model;

import com.example.validation.Annotation.PhoneNumber;
import com.example.validation.Annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
//    @NotBlank
    private String name;
    private String nickName;

    @NotBlank
    @Size(min = 1, max = 12)
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다." )
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerDate;

    @YearMonth(pattern = "yyyy-MM")
    private String yearMonth;

    @AssertTrue(message = "name or nickName must exist")
    public boolean isNameCheck(){
        if(Objects.nonNull(name) && !name.isBlank()){
            return true;
        }
        if(Objects.nonNull(nickName) && !nickName.isBlank()){
            return true;
        }

        return false; // get 400 error and print message
    }
}
