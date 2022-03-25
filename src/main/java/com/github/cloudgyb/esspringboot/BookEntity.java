package com.github.cloudgyb.esspringboot;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * mysql 存储book
 *
 * @author cloudgyb
 * @since 2022/3/19 20:33
 */
@Data
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Date createTime = new Date();
    private Date updateTime = new Date();
}
