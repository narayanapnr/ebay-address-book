package com.myebay.model;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;


public class PersonTest {
	
	    DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");
	    
	    @Test
	    public void testCompareAgeInDaysWithNullValue() {
	        Person person = new Person("X", Gender.MALE, dateFormatter.parseDateTime("07/07/2000"));

	        int result = person.compareAgeInDays(null);
	        assertEquals("0 days when param is null", 0, result);
	    }

	    @Test
	    public void testCompareAgeInDaysWithNotNullValue() {
	        Person person1 = new Person("X", Gender.MALE, dateFormatter.parseDateTime("07/07/2000"));
	        Person person2 = new Person("Y", Gender.FEMALE, dateFormatter.parseDateTime("08/08/2000"));

	        int value = person1.compareAgeInDays(person2);
	        assertEquals("person1 is 32 days older", 32, value);


	        person2 = new Person("Y", Gender.FEMALE, dateFormatter.parseDateTime("08/09/2000"));

	        value = person1.compareAgeInDays(person2);
	        assertEquals("person1 is 63 days older", 63, value);
	    }

	    
	    @Test
	    public void testIsFemale() {
	        Person person = new Person("Female", Gender.FEMALE, new DateTime());	        
	        assertTrue("Person is female", person.isFemale());
	        
	    }
	    
	    @Test
	    public void testIsNotFemale() {
	        Person person = new Person("Female", Gender.FEMALE, new DateTime());
	        assertFalse("Person is not female", person.isMale());
	       
	    }

	    @Test
	    public void testIsMale() {
	        Person person = new Person("Male", Gender.MALE, new DateTime());
	        assertTrue("Person is male", person.isMale());
	       
	    }

	    @Test
	    public void testIsNotMale() {
	        Person person = new Person("Male", Gender.MALE, new DateTime());
	       
	        assertFalse("Person is not male", person.isFemale());
	    }


	  
}
