package com.skk.spb.dao;

import com.skk.spb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookDao extends JpaRepository<Book,Integer> {
}
