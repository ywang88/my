package com.evan.my.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;


/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2020-03-15 11:45:55
 */
@Entity
@Data
@Table(name = "book")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String cover;

    private String title;

    private String author;

    private String date;

    private String press;

    private String abs;
    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;


}