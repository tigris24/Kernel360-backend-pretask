package com.example.simpleboard.board.db;

import com.example.simpleboard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;
    private String status;

    @OneToMany(
            mappedBy = "board"
    )
//    @Where(clause = "status = 'REGISTERED'") // deprecated
    @SQLRestriction("status = 'REGISTERED'")
    @Builder.Default
    @OrderBy("id DESC")
    private List<PostEntity> postList = List.of();

}



