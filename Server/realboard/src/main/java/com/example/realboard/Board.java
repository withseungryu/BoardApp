package com.example.realboard;



import jdk.vm.ci.meta.Local;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
//teststsetstes
@Getter
@NoArgsConstructor
@Entity(name="board")
@Table
public class Board implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    private Timestamp createdDate;

    @Column
    private Timestamp updatedDate;

    @OneToOne
    @JoinColumn(name= "user_idx")
    private User user;


    @Builder
    public Board(String title, String subTitle, String content, Timestamp createdDate,
                  Timestamp updatedDate, User user){

        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
    }


    public void setCreatedDateNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        this.createdDate = Timestamp.valueOf(localDateTime);
    }


    public void setUpdatedDateNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        this.updatedDate = Timestamp.valueOf(localDateTime);
    }

    public void update(Board board) {
        this.title = board.getTitle();
        this.subTitle = board.getSubTitle();
        this.content = board.getContent();
        LocalDateTime localDateTime = LocalDateTime.now();
        this.updatedDate = Timestamp.valueOf(localDateTime);
        this.user =user;
    }


}

