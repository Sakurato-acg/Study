package com.atguigu.dao.impl;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDAO;


import java.util.List;

@SuppressWarnings("all")
public class BookDAOImpl extends BaseDAO implements BookDAO {

    @Override
    public int addBook(Book book) {
        String sql = "insert into book.t_book (`name`, `price`, `author`, `sales`, `stock`, `img_path`) VALUES (?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(),
                book.getSales(), book.getStock(),book.getImg_path()
        );
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from book.t_book where `id`=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update book.t_book set `name`=?,`price`=?,`author`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
        return update(sql,book.getName(), book.getPrice(), book.getAuthor(),
                book.getSales(), book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryById(Integer id) {
        String sql="select `id`, `name`, `price`, `author`, `sales`, `stock`, `img_path` from book.t_book where `id`=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select `id`, `name`, `price`, `author`, `sales`, `stock`, `img_path` from book.t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql="select count(*) from book.t_book";
        Number count= (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPriceCount(int min,int max){
        String sql ="select count(*) from book.t_book where price between ? and ?";
        Number number= (Number) queryForSingleValue(sql,min,max);
        return number.intValue();
    }
    @Override
    public List<Book> queryForPriceItems(int min,int max,int begin,int pageSize){
        String sql="select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from book.t_book where price between ? and  ? order by price limit ?,?";
        List<Book> list = queryForList(Book.class, sql, min, max, begin, pageSize);
        return list;
    }
}
