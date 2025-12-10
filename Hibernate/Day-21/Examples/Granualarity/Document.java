package com.example.granuality;

//FINE GRANULARITY – Field-Level Mapping
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doc_title", length = 150)
    private String title;

    @Lob
    private String content;

    @Column(name = "created_on")
    private Instant createdOn;

  

    @Override
    public String toString() {
        return "Document{id=" + id + ", title='" + title + "', contentLength=" +
                (content != null ? content.length() : 0) +
                ", createdOn=" + createdOn + "}";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Instant getCreatedOn() { return createdOn; }
    public void setCreatedOn(Instant createdOn) { this.createdOn = createdOn; }
}
