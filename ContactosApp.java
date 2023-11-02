import java.util.*;
import java.util.stream.*;

public class ContactosApp {

	public static Scanner scanner = new Scanner(System.in);
	public static GestorContacts gc = new GestorContacts();


	public static void main(String[] args) {
		/*
		Gestión de Contactos: Crea un programa que permita al usuario agregar, ver, actualizar y eliminar contactos en una lista enlazada. Cada contacto podría tener campos como nombre, número de teléfono y correo electrónico.
		*/
		menuPrincipal();
		
	}


	private static void menuPrincipal() {
		while (true) {
			System.out.println("*** Contact Program v1.0 ***");
			System.out.println("Main Menu");
			System.out.println("1. Show Contacts");
			System.out.println("2. Add Contact");
			System.out.println("3. Update Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Exit");


			System.out.print("Choose an option: ");
			String option = scanner.nextLine();
			System.out.println();

			if (option.equals("1")){
				showContacts();
			}
			else if (option.equals("2")){
				addContact();
			}
			else if (option.equals("3")){
				updateContact();
			}
			else if (option.equals("4")){
				deleteContact();
			}
			else if (option.equals("5")){
				System.out.println("Closing program");
				break;
			}
			else{
				System.out.println("Invalid option. Try Again");					
			}
		}
		scanner.close();
	}

	private static void showContacts() {
		if (gc.isListEmpty()){
			System.out.println("No contacts registed yet.");
			System.out.println();
		}
		else {
			List<Contact> contacts = gc.getContacts();
			int index = 1;
			System.out.println("Contacts:");
			System.out.println();

			for (Contact contact : contacts) {
				System.out.printf("%d. Name: %s Number: %d Email: %s%n", index, contact.getNombre(), contact.getNumber(), contact.getEmail());
				index += 1;
			}
		}
		while (true){	
			System.out.println("Contacts Menu");
			System.out.println("1. Return to Main Menu");
			System.out.println();

			System.out.print("Choose an option: ");
			String option = scanner.nextLine();
			System.out.println();

			if (option.equals("1")) {
				break;
			}
			else {
				System.out.println("Invalid option. Try Again");
			}
		}
	}

	private static void addContact() {
		while (true) {
			String option = "";
			System.out.print("Enter a name: ");
			String name = scanner.nextLine();
			System.out.println();

			if (!StringUtils.isAlpha(name)){
				System.out.println("Name must be a text");
				System.out.println();
				
				System.out.println("1. Try Again");
				System.out.println("2. Return to main menu");

				System.out.println();
				System.out.print("Choose an option: ");
				option = scanner.nextLine();
				System.out.println();

				if (option.equals("1")) {
					continue;
				}
				else {
					break;
				}
			}		
			System.out.print("Enter a phone number: ");
			String number = scanner.nextLine();
			System.out.println();

			if (!StringUtils.isDigit(number)){
				System.out.println("Must be a number");
				System.out.println();

				System.out.println("1. Try Again");
				System.out.println("2. Return to main menu");

				System.out.println();
				System.out.print("Choose an option: ");
				option = scanner.nextLine();
				System.out.println();

				if (option.equals("1")){
					continue;
				}
				else{
					break;
				}
			}

			System.out.print("Enter an email: ");
			String email = scanner.nextLine();
			System.out.println();

			if (StringUtils.count(email, "@") != 1) {
				System.out.println("Must be an email");
				System.out.println();

				System.out.println("1. Try Again");
				System.out.println("2. Return to main menu");

				System.out.println();
				System.out.print("Choose an option: ");
				option = scanner.nextLine();
				System.out.println();

				if (option.equals("1")){
					continue;
				}

				else {
					break;			
				}
			}

			Contact contact = new Contact(name, Integer.parseInt(number), email);
			System.out.printf("%nContact: Name: %s Number: %d Email: %s%n", contact.getNombre(), contact.getNumber(), contact.getEmail());

			System.out.println();
			System.out.println("Do you want to save it?");

			System.out.println("1. Yes");
			System.out.println("2. Try Again");
			System.out.println("3. Return to Main Menu");

			System.out.println();
			System.out.print("Choose an option: ");
			option = scanner.nextLine();
			System.out.println();

			if (option.equals("1")) {
				gc.createContact(contact);
				System.out.println("Contact added successfully");
			}
			else if (option.equals("2")){
				continue;
			}
			else{
				break;
			}

			System.out.println();
			System.out.println("1. Add New Contact");
			System.out.println("2. Return Main Menu");

			System.out.println();
			System.out.print("Choose an option: ");
			option = scanner.nextLine();
			System.out.println();

			if (option.equals("1")) {
				continue;
			}
			else {
				break;
			}
			
		}
	}



	private static void updateContact() {
		while (true){
			
			System.out.print("Choose contact to change by position, type 'Exit' to Return Main Menu: ");
			String option = scanner.nextLine();
			System.out.println();

			if (option.equals("Exit")){
				break;
			}

			else if (!StringUtils.isDigit(option)) {
				System.out.println("Choose a number option. Try again");
				continue;
			}
			else if (gc.isListEmpty()){
				System.out.println("There's no contact in the list");
			}

			else if (!(Integer.parseInt(option) >= 1 && Integer.parseInt(option) <= gc.getListSize())){
				System.out.println("There's no contact in that position. Try again");
				continue;

			} else {
				System.out.println("Seleccionaste el siguiente contacto: ");
				int index = Integer.parseInt(option) - 1;
				Contact contact = gc.getContact(index);
				System.out.printf("%s. Name: %s Number: %d Email: %s%n", option, contact.getNombre(), contact.getNumber(), contact.getEmail());

				System.out.println();
				System.out.println("1. Modificar contacto");
				System.out.println("2. Buscar otro contacto");

				System.out.println();
				System.out.print("Choose an option: ");
				option = scanner.nextLine();
				System.out.println();

				if (option.equals("1")){
					while (true){
						System.out.print("Enter a name: ");
						String name = scanner.nextLine();
						System.out.println();

						if (!StringUtils.isAlpha(name)) {
							System.out.println("Name must be a text");
							System.out.println();
							
							System.out.println("1. Try Again");
							System.out.println("2. Return to Update Menu");

							System.out.println();
							System.out.print("Choose an option: ");
							option = scanner.nextLine();
							System.out.println();

							if (option.equals("1")){
								continue;
							}
							else{
								break;
							}
						}


						System.out.print("Enter a Phone Number: ");
						String number = scanner.nextLine();
						System.out.println();

						if (!StringUtils.isDigit(number)){
							System.out.println("Must be a number");
							System.out.println();

							System.out.println("1. Try Again");
							System.out.println("2. Return to main menu");

							System.out.println();
							System.out.print("Choose an option: ");
							option = scanner.nextLine();
							System.out.println();

							if (option.equals("1")){
								continue;
							}
							else{
								break;
							}
						}

						System.out.println();
						System.out.print("Enter an email: ");
						String email = scanner.nextLine();
						System.out.println();

						if (StringUtils.count(email, "@") != 1) {
							System.out.println("Must be an email");
							System.out.println();

							System.out.println("1. Try Again");
							System.out.println("2. Return to main menu");

							System.out.println();
							System.out.print("Choose an option: ");
							option = scanner.nextLine();
							System.out.println();

							if (option.equals("1")){
								continue;
							}
							else{
								break;			
							}
						}		
						
						Contact updatedContact = new Contact(name, Integer.parseInt(number), email);
						System.out.printf("%nOld Contact: Name: %s Number: %d Email: %s%n", contact.getNombre(), contact.getNumber(), contact.getEmail());
						System.out.printf("%nNew Contact: Name: %s Number: %d Email: %s%n", updatedContact.getNombre(), updatedContact.getNumber(), updatedContact.getEmail());

						System.out.println();
						System.out.println("Do you want to update it?");

						System.out.println("1. Yes");
						System.out.println("2. Try Again");
						System.out.println("3. Return to Update Menu");

						System.out.println();
						System.out.print("Choose an option: ");
						option = scanner.nextLine();

						if (option.equals("1")){
							gc.updateContact(index, updatedContact);
							System.out.println("Contact updated successfully");

							break;
						}
						else if (option.equals("2")) {
							continue;
						}
						else{
							break;
						}
					}
				} else {
					continue;
				}
			}
		}
	}


			
	private static void deleteContact() {
		while (true){
			System.out.print("Choose contact to delete by position, type 'Exit' to Return to Main Menu: ");
			String option = scanner.nextLine();
			System.out.println();

			if (option.equals("Exit")){
				break;
			}

			else if (!StringUtils.isDigit(option)){
				System.out.println("Choose a number option. Try again");
				continue;
			}
			else if (gc.isListEmpty()){
				System.out.println("There's no contact in the list");
			}

			else if (!(Integer.parseInt(option) >= 1 && Integer.parseInt(option) <= gc.getListSize())) {
				System.out.println("There's no contact in that position. Try again");
				continue;
			}

			else {
				System.out.println("Seleccionaste el siguiente contacto: ");
				int index = Integer.parseInt(option) - 1;
				Contact contact = gc.getContact(index);

				System.out.printf("%s. Name: %s Number: %d Email: %s%n", option, contact.getNombre(), contact.getNumber(), contact.getEmail());

				System.out.println();
				System.out.println("1. Delete Contact");
				System.out.println("2. Choose another contact");

				System.out.println();
				System.out.print("Choose an option: ");
				option = scanner.nextLine();
				System.out.println();

				if (option.equals("1")) {
					gc.deleteContact(index);
					System.out.println("Contact deleted successfully");
				}
				else {
					continue;
				}
			}
		}	
	}

}


class Contact {
	private String nombre;
	private int number;
	private String email;

	public Contact(String nombre, int number, String email) {
		this.nombre = nombre;
		this.number = number;
		this.email = email;
	}

	public Contact(Contact contact) {
		this.nombre = contact.nombre;
		this.number = contact.number;
		this.email = contact.email;
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getNumber(){
		return this.number;
	}

	public String getEmail(){
		return this.email;
	}

	public String toString(){
		return "[Name: " + this.getNombre() + " Number: " + this.getNumber() + " Email: " + this.getEmail() + "]";
	}

}

class GestorContacts {

	private List<Contact> contacts;

	public GestorContacts(){
		this.contacts = new ArrayList<Contact>();
	}

	public GestorContacts(List<Contact> contacts){
		this.contacts = contacts;
	}

	public List<Contact> getContacts() {
		return contacts.stream().map(contact -> new Contact(contact)).collect(Collectors.toList());
	}

	public Contact getContact(int index) {
		if (this.contacts.isEmpty() || index < 0 || index >= this.contacts.size()) {
			return null;
		}

		return new Contact(this.contacts.get(index));
	}

	public boolean isListEmpty() {
		return this.contacts.isEmpty();
	}

	public int getListSize() {
		return this.contacts.size();
	} 

	public void createContact(Contact contact) {
		this.contacts.add(contact);
	}

	public void updateContact(int index, Contact contact) {
		this.contacts.set(index, contact);
	}

	public void deleteContact(int index) {
		this.contacts.remove(index);
	}
}

class StringUtils {

	//Check if all the characters in the text are letters
	public static boolean isAlpha(String text) {
		for(char a : text.toCharArray()) {
			if (!Character.isLetter(a)) {
				return false;
			}
		}
		return true;
	}

	//Check if all the characters in the text are numbers
	public static boolean isDigit(String text) {
		for(char a : text.toCharArray()) {
			if (!Character.isDigit(a)) {
				return false;
			}
		}
		return true;
	}

	public static int count(String text, String ocurrence) {
		int counter = 0;
		int index = text.indexOf(ocurrence);

		while (index != -1) {
			counter++;
			index = text.indexOf(ocurrence, index + 1);
		}

		return counter;
	}
}
