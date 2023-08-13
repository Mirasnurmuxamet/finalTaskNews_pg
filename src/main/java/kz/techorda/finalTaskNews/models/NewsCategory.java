package kz.techorda.finalTaskNews.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_news_category")
@Getter
@Setter
public  class NewsCategory extends BaseModel {

    @Column(name = "name")
    private String name;


}
