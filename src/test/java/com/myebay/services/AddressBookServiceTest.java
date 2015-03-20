package com.myebay.services;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.myebay.model.AddressBook;

public class AddressBookServiceTest {

	@Test
	public void testGetAddressBookFromGivenFile() throws IOException {
		URL addressBookPath = this.getClass().getResource("/AddressBook");
		File giveFile = new File(addressBookPath.getPath());
		AddressBook addressBook = AddressBookService.getAddressBookFromGivenFile(giveFile);
		assertEquals("Expecting 5 persons in address book", 5, addressBook.addressBookSize());
	}

	@Test
	public void testGetAddressBookFromGivenPath() throws IOException {
		URL addressBookPath = this.getClass().getResource("/AddressBook");

		AddressBook addressBook = AddressBookService.getAddressBookFromGivenPath(addressBookPath.getPath());

		assertEquals("Expecting 5 persons in address book", 5, addressBook.addressBookSize());
	}

}
