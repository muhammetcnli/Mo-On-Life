package com.atlas.Mo_on_Life.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    @Lob
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "view_count")
    private int viewCount = 0;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "slug")
    private String slug;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>(); // Set allows us to no duplicate tags


    // Hibernate needs empty constructor
    public Post() {
    }


    @PrePersist
    public void generateSlug(){
        if(this.slug == null || this.slug.isBlank()){
            this.slug = toSlug(this.title);
        }
    }

    private String toSlug(String title) {

        return title.toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9\\s]", "") // remove special chars
                .replaceAll("\\s+", "-") // switches the blanks with "-"
                .trim()
                ;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getSlug() {
        return slug;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.slug = toSlug(title);
    }
}
