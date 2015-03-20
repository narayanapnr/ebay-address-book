package com.myebay.model;

import java.util.List;

/**
 * 
 *  @author Narayana Rao
 *
 */

public class AddressBook {
	

    private List<Person> addressBook;

    public AddressBook(List<Person> persons) {
        if (persons == null) {
            throw new IllegalArgumentException("ALERT!!!!: Provide valid Constructor argument");
        }
        addressBook = persons;
    }

    
    public int addressBookSize() {
        return addressBook.size();
    }

  
    public boolean isAddressBookEmpty() {
       return addressBookSize() == 0;
    }

   
    public int countMalesInAddressBook() {
        int totalMales = 0;
        for (Person person : addressBook) {
            if (person.isMale()) {
            	totalMales = totalMales + 1;
            }
        }
        return totalMales;
    }

   
    public Person findOldestPersonInAddressBook() {
        Person oldestPerson = null;
        for (Person person : addressBook) {
            if (oldestPerson == null || person.getdateOfBirth().isBefore(oldestPerson.getdateOfBirth())) {
            	oldestPerson = person;
            }
        }
        return oldestPerson;
    }


   
    public Person findByNameInList(String name) {
        Person person = null;
        if (name != null) {
            for (Person persn : addressBook) {
                if (name.equals(persn.getPersonName())) {
                    person = persn;
                    break;
                }
            }
        }
        return person;
    }

  

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressBook == null) ? 0 : addressBook.hashCode());
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
		AddressBook other = (AddressBook) obj;
		if (addressBook == null) {
			if (other.addressBook != null)
				return false;
		} else if (!addressBook.equals(other.addressBook))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AddressBook [addressBook=" + addressBook + "]";
	}

}
