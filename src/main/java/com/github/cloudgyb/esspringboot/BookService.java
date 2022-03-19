package com.github.cloudgyb.esspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author geng
 * 2020/12/19
 */
@Slf4j
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ESBookRepository esBookRepository;
    private final TransactionTemplate transactionTemplate;

    public BookService(BookRepository bookRepository,
                       ESBookRepository esBookRepository,
                       TransactionTemplate transactionTemplate) {
        this.bookRepository = bookRepository;
        this.esBookRepository = esBookRepository;
        this.transactionTemplate = transactionTemplate;
    }

    public void addBook(BookEntity book) {
        final BookEntity saveESBook = transactionTemplate.execute((status) ->
                bookRepository.save(book)
        );
        final ESBook esBook = new ESBook();
        assert saveESBook != null;
        BeanUtils.copyProperties(saveESBook, esBook);
        esBook.setId(saveESBook.getId() + "");
        try {
            esBookRepository.save(esBook);
        } catch (Exception e) {
            log.error(String.format("保存ES错误！%s", e.getMessage()));
        }
    }

    public List<ESBook> search(String keyword) {
        return esBookRepository.findByTitleOrAuthor(keyword, keyword);
    }

    public SearchHits<ESBook> searchBookTitle(String keyword) {
        return esBookRepository.find(keyword);
    }

    public List<BookEntity> searchBookFromMysql(String key) {
        return bookRepository.findBookByAuthorOrTitle(key, key);
    }
}
