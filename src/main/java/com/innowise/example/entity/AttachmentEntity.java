package com.innowise.example.entity;

import java.time.Instant;

public class AttachmentEntity {
   private Long id;
   private String fileName;
   private String comment;
   private Instant CreateTime;
   private Instant UpdateTime;
   private Long contactId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Instant createTime) {
        CreateTime = createTime;
    }

    public Instant getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        UpdateTime = updateTime;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}
