package com.example.listjobsproject;

import com.example.listjobsproject.dataValidityVerifier.DataValidator;
import com.example.listjobsproject.scrapper.NoFluffJobs;
import com.example.listjobsproject.scrapper.PracujPl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ListJobsProjectApplication implements CommandLineRunner {

	DataValidator dataValidator;

	@Autowired
	public ListJobsProjectApplication(DataValidator dataValidator) {
		this.dataValidator = dataValidator;
	}

	public static void main(String[] args) {
		SpringApplication.run(ListJobsProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Runnable> listOfClass = new ArrayList<>(List.of(new NoFluffJobs(dataValidator),new PracujPl(dataValidator)));

		for (Runnable klasa:listOfClass)
		{
			Thread object = new Thread(klasa);
			object.start();
		}


		System.out.println("Odpalam Program");



	}


}
