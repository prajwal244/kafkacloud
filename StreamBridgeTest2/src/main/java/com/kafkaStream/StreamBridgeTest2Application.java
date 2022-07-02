package com.kafkaStream;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StreamBridgeTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(StreamBridgeTest2Application.class, args);
	}

	@Autowired
    private StreamBridge streamBridge;

    @PostMapping("/publish")
    public void delegateToSupplier(@RequestBody Book book) {
     
      
        System.out.println("Sending person: " + book);
        streamBridge.send("personSupplier-out-0", book);
    }
    
    @PostMapping("/publish1")
    public void delegateToSupplier1(@RequestBody Book book) {
     
      
        System.out.println("Sending person: " + book);
        streamBridge.send("personSupplier1-out-0", book);
    }
}
