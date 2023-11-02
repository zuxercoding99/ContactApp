#Gestión de Contactos: Crea un programa que permita al usuario agregar, ver, actualizar y eliminar contactos en una lista enlazada. Cada contacto podría tener campos como nombre, número de teléfono y correo electrónico.

class Contact:

	def __init__(self, name, number, email):
		self.name = name
		self.number = number
		self.email = email

contacts = [Contact("Panchito", 1432432434, "panchito@gmail.com")]

def menu_principal():
	while True:
		
		print("*** Contact Program v1.0 ***")
		print("Main Menu")
		print("1. Show Contacts")
		print("2. Add Contact")
		print("3. Update Contact")
		print("4. Delete Contact")
		print("5. Exit")

		option = input("\nChoose an option: ")

		if option == "1":
			show_contacts()
		elif option == "2":
			add_contact()
		elif option == "3":
			update_contact()
		elif option == "4":
			delete_contact()
		elif option == "5":
			print("Closing program.")
			break
		else:
			print("Invalid option. Try Again")		

def show_contacts():
	
	if len(contacts) == 0:
		print("\nNo contacts registed yet.")
	else:
		index = 1
		print("\nContacts:")
		for contact in contacts:
			print(f"{index}. Name: {contact.name} Number: {contact.number} Email: {contact.email}")
			index += 1

	while True:	
		print("\nContacts Menu")
		print("1. Return to Main Menu")

		option = input("\nChoose an option: ")

		if option == "1":
			break
		else:
			print("Invalid option. Try Again")	

def add_contact():
	while True:
		
		name  = input("Enter a name: ")
		if not name.isalpha():
			print("Name must be a text")
			
			print("1. Try Again")
			print("2. Return to main menu")

			option = input("\nChoose an option: ")

			if option == "1":
				continue
			else:
				break

		number = input("Enter a phone number: ")
		if not number.isdigit():
			print("Must be a number")

			print("1. Try Again")
			print("2. Return to main menu")

			option = input("\nChoose an option: ")

			if option == "1":
				continue
			else:
				break

		email = input("Enter an email: ")		
		if not email.count("@") == 1:
			print("Must be an email")

			print("1. Try Again")
			print("2. Return to main menu")

			option = input("\nChoose an option: ")

			if option == "1":
				continue
			else:
				break			

		contact = Contact(name, number, email)
		print(f"\nContact: Name: {contact.name} Number: {contact.number} Email: {contact.email}")

		print("\nDo you want to save it?")

		print("1. Yes")
		print("2. Try Again")
		print("3. Return to Main Menu")

		option = input("\nChoose an option: ")

		if option == "1":
			contacts.append(contact)
			print("Contact added successfully")
		elif option == "2":
			continue
		else:
			break

		print("\n1. Add New Contact")
		print("2. Return Main Menu")

		option = input("\nChoose an option: ")

		if option == "1":
			continue
		else:
			break

def update_contact():
	while True:
		
		option = input("Choose contact to change by position, type 'Exit' to Return Main Menu: ")

		if option == "Exit":
			break

		elif not option.isdigit():
			print("Choose a number option. Try again")
			continue
		elif len(contacts) == 0:
			print("There's no contact in the list")

		elif not (int(option) >= 1 and int(option) <= len(contacts)):
			print("There's no contact in that position. Try again")
			continue

		else:
			print("Seleccionaste el siguiente contacto: ")
			index = int(option) - 1
			contact = contacts[index]
			print(f"{option}. Name: {contact.name} Number: {contact.number} Email: {contact.email}")

			print("\n1. Modificar contacto")
			print("2. Buscar otro contacto")

			option = input("\nChoose an option: ")

			if option == "1":
				while True:
					name  = input("Enter a name: ")
					if not name.isalpha():
						print("Name must be a text")
						
						print("1. Try Again")
						print("2. Return to Update Menu")

						option = input("\nChoose an option: ")

						if option == "1":
							continue
						else:
							break

					number = input("Enter a Phone Number: ")
					if not number.isdigit():
						print("Must be a Number")

						print("1. Try Again")
						print("2. Return to Update Menu")

						option = input("\nChoose an option: ")

						if option == "1":
							continue
						else:
							break

					email = input("Enter an Email: ")		
					if not email.count("@") == 1:
						print("Must be an email")

						print("1. Try Again")
						print("2. Return to Update Menu")

						option = input("\nChoose an option: ")

						if option == "1":
							continue
						else:
							break			

					updated_contact = Contact(name, number, email)
					print(f"\nOld Contact: Name: {contact.name} Number: {contact.number} Email: {contact.email}")
					print(f"New Contact: Name: {updated_contact.name} Number: {updated_contact.number} Email: {updated_contact.email}")

					print("\nDo you want to update it?")

					print("1. Yes")
					print("2. Try Again")
					print("3. Return to Update Menu")

					option = input("\nChoose an option: ")

					if option == "1":
						contacts[index] = updated_contact
						print("Contact updated successfully")
						break

					elif option == "2":
						continue
					else:
						break

			else:
				continue

def delete_contact():
	while True:
		option = input("Choose contact to delete by position, type 'Exit' to Return to Main Menu: ")

		if option == "Exit":
			break

		elif not option.isdigit():
			print("Choose a number option. Try again")
			continue

		elif len(contacts) == 0:
			print("There's no contact in the list")

		elif not (int(option) >= 1 and int(option) <= len(contacts)):
			print("There's no contact in that position. Try again")
			continue

		else:
			print("Seleccionaste el siguiente contacto: ")
			index = int(option) - 1
			contact = contacts[index]
			print(f"{option}. Name: {contact.name} Number: {contact.number} Email: {contact.email}")

			print("\n1. Delete Contact")
			print("2. Choose another contact")

			option = input("\nChoose an option: ")

			if option == "1":
				contacts.pop(index)
				print("Contact deleted successfully")
			else:
				continue



if __name__ == "__main__":
	menu_principal()