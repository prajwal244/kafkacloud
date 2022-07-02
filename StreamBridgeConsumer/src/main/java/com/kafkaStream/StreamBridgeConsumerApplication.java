package com.kafkaStream;


import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kafkaStream.model.BookStore;
import com.kafkaStream.repository.BookRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class StreamBridgeConsumerApplication {

	@Autowired
	BookRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(StreamBridgeConsumerApplication.class, args);
	}
	
	@Bean
    public Consumer<Book> personConsumer() {
		
        return book -> {
        	log.info("Received: "+book);
           // System.out.println("Received: " + book);
        	
        	BookStore books = new BookStore();
        	books.setId(book.getId());
        	books.setName(book.getName());
        	repo.save(books);
        	
        };
    }
	
	@Bean
    public Consumer<Book> bookConsumer() {
        return book -> {
            System.out.println("Received: " + book);
            BookStore books = new BookStore();
        	books.setId(book.getId());
        	books.setName(book.getName());
        	repo.save(books);
        	
        };
    }
	

}
