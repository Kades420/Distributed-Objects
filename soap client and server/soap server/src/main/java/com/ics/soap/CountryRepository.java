package com.ics.soap;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import localhost._8080.webservice.Country;
import localhost._8080.webservice.Currency;
import localhost._8080.webservice.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
  private static final Map<String, Country> countries = new HashMap<>();
    private static final Map<String, Student> students = new HashMap<>();

  @PostConstruct
  public void initData() {
     Country spain = new Country();
     spain.setName("Spain");
     spain.setCapital("Madrid");
     spain.setCurrency(Currency.EUR);
     spain.setPopulation(46704314);


     countries.put(spain.getName(), spain);

     Country poland = new Country();
     poland.setName("Poland");
     poland.setCapital("Warsaw");
     poland.setCurrency(Currency.PLN);
     poland.setPopulation(38186860);

     countries.put(poland.getName(), poland);

     Country uk = new Country();
     uk.setName("United Kingdom");
     uk.setCapital("London");
     uk.setCurrency(Currency.GBP);
     uk.setPopulation(63705000);

     countries.put(uk.getName(), uk);


      Student patel = new Student();
      patel.setName("Patel");
      patel.setPhoneNumber("0712312312");
      patel.setAdmissionNumber("088292");

      students.put(patel.getAdmissionNumber(), patel);

  }

  public Country findCountry(String name) {
     Assert.notNull(name, "The country's name must not be null");
     return countries.get(name);
  }

    public Student findStudent(String admissionNumber) {
        Assert.notNull(admissionNumber, "The student number must not be null");
        return students.get(admissionNumber);
    }
}
