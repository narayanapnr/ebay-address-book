package com.myebay.model;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * 
 *  @author Narayana Rao
 *
 */

public class Person {

    private String personName;
    private Gender gender;
    private DateTime dateOfBirth;

    public Person(String personName, Gender gender, DateTime dateOfBirth){
        this.personName = personName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DateTime getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isMale(){
        return getGender().equals(Gender.MALE);
    }

    public boolean isFemale(){
        return getGender().equals(Gender.FEMALE);
    }

    public int compareAgeInDays(Person person) {
        int days = 0;
        if (person != null) {
            days = Days.daysBetween(this.getdateOfBirth(), person.getdateOfBirth()).getDays();
        }
        return days;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (gender != other.gender)
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + personName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + "]";
	}

 
}