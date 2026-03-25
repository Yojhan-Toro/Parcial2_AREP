package edu.co.eci.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MathApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathApplication.class, args);


		MathService math = new MathService();

		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);


		System.out.print(math.linearSearch(a, 4));

	}

}
