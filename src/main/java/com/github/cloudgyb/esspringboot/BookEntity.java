package com.github.cloudgyb.esspringboot;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer id;
    private String title;
    private String author;
    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }
}
