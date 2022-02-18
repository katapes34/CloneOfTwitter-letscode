package com.smitter.application.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;

    // one user has many Massages (author var are in the Message class)
    @ManyToOne
            // when we call Message we get information about author
            (fetch = FetchType.EAGER)
    // rename default column (authorId) which generics automatically to user_id
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public String getAuthorName() {
        if (author != null) {
            return author.getUsername();
        }
        return "<none>";
    }

    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }


}
