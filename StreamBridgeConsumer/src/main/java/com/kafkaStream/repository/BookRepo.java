package com.kafkaStream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafkaStream.model.BookStore;

@Repository
public interface BookRepo extends JpaRepository<BookStore, Integer> {

}
