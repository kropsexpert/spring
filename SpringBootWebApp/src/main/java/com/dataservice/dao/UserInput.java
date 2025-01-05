package com.dataservice.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class UserInput {
    //
    @Id
    private Long id;

    private String content;

    @Column("created_date")
    private java.sql.Timestamp createdDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.sql.Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.sql.Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}