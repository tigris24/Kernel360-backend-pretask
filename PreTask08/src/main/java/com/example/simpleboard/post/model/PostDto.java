package com.example.simpleboard.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

    private Long id;

    private Long boardId;

    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;

    private String content;

    private LocalDateTime postedAt;

}
