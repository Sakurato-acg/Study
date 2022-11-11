package com.atguigu.test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

class BookServiceTest {
    BookService bookService=new BookServiceImpl();
    @Test
    void addBook() {
    }

    @Test
    void deleteBookById() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void queryById() {
        System.out.println(bookService.queryById(1));
    }

    @Test
    void queryBooks() {
    }

    @Test
    void page(){
        Page<Book> page = bookService.page(1, Page.PAGE_SIZE);
        System.out.println(page);

        page.getItems().forEach(System.out::println);
    }


}