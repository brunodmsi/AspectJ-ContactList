import java.util.ArrayList;


public class Contact {
	ArrayList<Contact> list = new ArrayList<Contact>();
	
	private String name;
	private String telephone;
	
	public void insert_contact (String name, String telephone) {
		Contact contact = new Contact();
		
		contact.name = name;
		contact.telephone = telephone;
		
		list.add(contact);
	}
	
	public void remove_contact (String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(name)) {
				System.out.println(i);
				System.out.println(list.get(i).name);
				list.remove(i);
			}
		}
	}
	
	public void print_list () {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Nome: "+ list.get(i).name);
			System.out.println("Telefone: "+ list.get(i).telephone + "\n");
		}
	}
}
