package com.evan.my.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2020-03-15 11:46:12
 */
@Entity
@Data
@Table(name = "category")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String name;

}