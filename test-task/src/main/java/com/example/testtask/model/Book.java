package com.example.testtask.model;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
@XmlRootElement
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String author_fio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_fio() {
        return author_fio;
    }

    public void setAuthor_fio(String author_fio) {
        this.author_fio = author_fio;
    }
}