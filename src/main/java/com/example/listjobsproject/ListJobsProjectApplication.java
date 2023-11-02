package com.example.listjobsproject;

import com.example.listjobsproject.models.PageScrapper;
import com.example.listjobsproject.scrapper.NoFluffJobs;
import com.example.listjobsproject.scrapper.PracujPl;
import com.example.listjobsproject.validators.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
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
		//wystarczy miec klasy ktore implementuja Runnable
		//potem te klasy wpadaja do kotla, z kotl
//		List<Runnable> listOfClass = new ArrayList<>(List.of(new NoFluffJobs(),new PracujPl()));
//
//		for (Runnable klasa:listOfClass)
//		{
//			Thread object = new Thread(klasa);
//			object.start();
//		}

		dataValidator.Validate("Junior h","http/","januszek","4333.0");

	}
}
