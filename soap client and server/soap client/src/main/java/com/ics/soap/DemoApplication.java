package com.ics.soap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient countryClient) {
        return (args) -> {
            String name = "Poland";
            if (args.length > 0) {
                name = args[0];
            }

            countries.wsdl.GetCountryResponse response = countryClient.getCountry(name);
            countries.wsdl.Country country = response.getCountry();

            String result = country.getName()     + "\n" +
                    country.getCapital()  + "\n" +
                    country.getCurrency() + "\n" +
                    country.getPopulation();

            System.out.println(result);
        };
    }
}

