package com.educare.open.model;

import javax.persistence.*;
import java.sql.Timestamp;

//@Entity
//@Table(name = "post")
public class Post {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "title")
    private String title;

//    @Column(name = "content")
    private String content;


//    @Column(name = "view_count")
    private Integer viewCount;

//    @Column(name = "create_at")
    private Timestamp createAt;

//    @Column(name = "update_at")
    private Timestamp updateAt;

//    @Column(name = "tags")
    private String tags;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;

    public Post() {
    }

    public Post(String title, String content, Category category, Integer viewCount, Timestamp createAt, Timestamp updateAt, String tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.viewCount = viewCount;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
