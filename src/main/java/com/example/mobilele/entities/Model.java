package com.example.mobilele.entities;


import com.example.mobilele.enums.Category;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "image_url", length = 512)
    private String imageUrl;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    @ManyToOne
    private Brand brand;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
