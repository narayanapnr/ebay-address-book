package com.myebay.model;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * 
 * @author Narayana Rao
 *
 */
public class AddressBookTest {
	
	    DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");

	    @Test
	    public void testCountMalesInAddressBook() {
	        Person person1 = new Person("P", Gender.MALE, new DateTime());
	        Person person2 = new Person("P", Gender.FEMALE, new DateTime());
	        Person person3 = new Person("P", Gender.MALE, new DateTime());
	        Person person4 = new Person("P", Gender.MALE, new DateTime());

	        List<Person> listOfPersons = new ArrayList<>();
	        listOfPersons.add(person1);
	        listOfPersons.add(person2);
	        listOfPersons.add(person3);	        
	        listOfPersons.add(person4);
	        
	        AddressBook addressBook = new AddressBook(listOfPersons);
	        int result = addressBook.countMalesInAddressBook();
	        assertEquals("We have 3 males", 3, result);
	    }
	    
	    @Test
	    public void testFindOldestPersonInAddressBook() {
	        Person person1 = new Person("W", Gender.MALE, dateFormatter.parseDateTime("07/07/2007"));
	        Person person2 = new Person("X", Gender.FEMALE, dateFormatter.parseDateTime("09/09/1999"));
	        Person person3 = new Person("Y", Gender.MALE, dateFormatter.parseDateTime("06/06/2000"));
	        Person person4 = new Person("Z", Gender.MALE, dateFormatter.parseDateTime("08/08/2001"));

	        List<Person> listOfPersons = new ArrayList<>();
	        listOfPersons.add(person1);
	        listOfPersons.add(person2);
	        listOfPersons.add(person3);	        
	        listOfPersons.add(person4);

	        AddressBook addressBook = new AddressBook(listOfPersons);
	        Person result = addressBook.findOldestPersonInAddressBook();
	        assertEquals("Oldest person is person2", person2, result);
	    }


}
