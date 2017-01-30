package com.ledzedev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@SpringBootApplication
public class LedzeCouchbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LedzeCouchbaseApplication.class, args);
	}
}

interface TravelRepository<Travel> extends CouchbaseRepository<Travel, String>{
	Collection<Travel> findById(String id);
}

@Component
class SampleTravelCLR implements CommandLineRunner{

	private final TravelRepository travelRepository;

	public SampleTravelCLR(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

	}
}

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Travel {

	@Id
	private String id;

	private String type;

	private String name;

	private String iata;

}