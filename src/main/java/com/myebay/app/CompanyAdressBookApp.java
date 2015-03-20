package com.myebay.app;

import com.myebay.model.AddressBook;
import com.myebay.model.Person;
import com.myebay.services.AddressBookService;
import com.myebay.utils.Constants;

/**
 * 
 * @author Narayana Rao
 *
 */
public class CompanyAdressBookApp {

    public static void main(String[] args) throws Exception {    	
        
        AddressBook addressBook = AddressBookService.getAddressBookFromGivenPath(Constants.ADDRESS_BOOK_FILE);

        System.out.println("Q1: How many males are in the address book?");
        System.out.println("Ans:Total number of males in Addressbook: " + addressBook.countMalesInAddressBook());

        System.out.println("Q2: Who is the oldest person in the address book?");
        System.out.println("Ans:Oldest person in the Addressbook is: " + addressBook.findOldestPersonInAddressBook());

        System.out.println("Q3: How many days older is Bill than Paul?");
        Person billMcNight = addressBook.findByNameInList("Bill McKnight");
        Person paulRobinson = addressBook.findByNameInList("Paul Robinson");        
        System.out.println("Ans:Bill is " + billMcNight.compareAgeInDays(paulRobinson) + " older than Paul");
    }


}
