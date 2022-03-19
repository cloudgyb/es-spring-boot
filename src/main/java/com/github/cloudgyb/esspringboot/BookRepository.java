package com.github.cloudgyb.esspringboot;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 关系型数据库mysql Repository
 *
 * @author cloudgyb
 * @since 2022/3/19 19:31
 */
@Repository("bookRepository")
public interface BookRepository extends JpaRepository<BookEntity, String> {
    List<BookEntity> findBookByAuthorOrTitle(String author,String title);
}