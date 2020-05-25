package com.example.sd2020.demo;

import model.Antrenori;
import model.DanceCourse;
import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Antrenori a = new Antrenori(1, "Nume", "Prenume", "Dans");
		DanceCourse dc = new DanceCourse(1, a, "Curs de salsa", new Date());
		User u =  new User(1, "Ana", "Maria", 12, "M", "Salsa");
		//u.addCourseDate(new Date());
		//System.out.println(u.coursesDates);
		//dc.addObserver(u);

		//dc.setDate(new Date(2020));
		//System.out.println(u.coursesDates);

		SpringApplication.run(DemoApplication.class, args);
	}

}
