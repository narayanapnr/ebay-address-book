package com.myebay.services;

import com.myebay.model.AddressBook;
import com.myebay.model.Gender;
import com.myebay.model.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * @author Narayana Rao
 *
 */

public class AddressBookService {
	

	public static AddressBook getAddressBookFromGivenFile(File addressBookFile) throws IOException {
		List<String> addressBookData = loadFileContent(addressBookFile);
		List<Person> persons = convertCSVDataToListOfPersons(addressBookData);

		return new AddressBook(persons);
	}
	
	private static List<String> loadFileContent(File file) throws IOException {
		List<String> list = new ArrayList<>();

		if (file != null) {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
				String line = bufferedReader.readLine();

				while (line != null) {
					list.add(line);
					line = bufferedReader.readLine();
				}
			}
		}

		return list;
	}


	public static AddressBook getAddressBookFromGivenPath(String addressBookPath) throws IOException {
		File addressBookFile = new File(addressBookPath);
		return getAddressBookFromGivenFile(addressBookFile);
	}


	private static List<Person> convertCSVDataToListOfPersons(List<String> csvData) {
		List<Person> listOfPersons = new ArrayList<>();

		if (csvData != null) {
			DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("dd/MM/yy");

			for (String csv : csvData) {
				String[] csvDetails = csv.split(",");

				Gender gender = Gender.FEMALE;
				if (csvDetails[1].trim().equals("Male")) {
					gender = Gender.MALE;
				}

				DateTime dateTime = dateFormatter.parseDateTime(csvDetails[2].trim());

				Person person = new Person(csvDetails[0].trim(), gender, dateTime);
				listOfPersons.add(person);
			}
		}

		return listOfPersons;
	}


}
