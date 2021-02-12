package com.example.mobilele.models.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    protected Instant created;

    @Column(nullable = false)
    protected Instant modified;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    @PrePersist
    public void prePersist(){
        setCreated(Instant.now());
        setModified(Instant.now());
    }

    @PreUpdate
    public void preUpdate(){
        setModified(Instant.now());
    }

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BaseEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + modified +
                '}';
    }
}
