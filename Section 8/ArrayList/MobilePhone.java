import java.util.ArrayList;

public class MobilePhone {
	
	private String myNumber;
	private ArrayList<Contact> myContacts;
	
	
	
	public MobilePhone(String myNumber) {
		
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}
	
	private int findContact(Contact contact) {
		return myContacts.indexOf(contact);
	}
	private int findContact(String name) {
		for(int i=0;i<myContacts.size();i++) {
			if(myContacts.get(i).getName().equals(name)){
			    return i;
			}
		}
		return -1;
	}
	public boolean addNewContact(Contact contact) {
		if(findContact(contact.getName())>=0) {
			//System.out.println("Contact "+contact.getName() +" already exists");
			return false;
		}else {
			myContacts.add(contact);	
			//System.out.println("Contact "+contact.getName() +" added");
			return true;
		}
	}
	public boolean updateContact(Contact oldContact, Contact newContact) {
		if(findContact(oldContact)<0) { //Contact doesnt exist
			return false;
		}else if(findContact(newContact.getName())>=0){
			return false; //contact with the new name already exists
		}
		else {
			myContacts.set(findContact(oldContact), newContact);
			return true;
		}
	}
	public boolean removeContact(Contact contact) {
		if(findContact(contact)<0) {
			return false; //Contact doesn't exist
		}
		else {
			return myContacts.remove(contact);
		}
	}
	public Contact queryContact(String name) {
		if(findContact(name)<0) {
			return null; //doesn't exist;
		}
		else {
			return myContacts.get(findContact(name));
		}
	}
	public void printContacts() {
		//myContacts.forEach((contact)->System.out.println(contact.getName()+" -> "+contact.getPhoneNumber())); 
		System.out.println("Contact List:");
		for(int i=0;i<myContacts.size();i++) {
			System.out.println(i+1+". "+myContacts.get(i).getName()+" -> "+myContacts.get(i).getPhoneNumber());
			
		}
	}
	

}
