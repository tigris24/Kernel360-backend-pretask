package com.example.exception.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
//    @JsonProperty("user_names")
    private String userName;
//    @JsonProperty("user_age")
    private Integer userAge;
//    @JsonProperty("email")
    private String email;
//    @JsonProperty("is_korean")
    private Boolean isKorean;

/*    public String getUserName() {
        return userName;
    }
    public Integer getUserAge() {
        return userAge;
    }
    public String getEmail(){
        return email;
    }
    public Boolean getIsKorean() {
        return isKorean;
    }
    @JsonIgnore
    public String getUser(){
        return userName;
    }
*/
/*    private UserRequest(){

    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }*/
}
