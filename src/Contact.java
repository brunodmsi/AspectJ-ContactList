import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Contact {
	ArrayList<Contact> list = new ArrayList<Contact>();
	
	private String name;
	private String telephone;
	
	public void insert_contact (String name, String telephone) {
		Contact contact = new Contact();
		
		contact.name = name;
		contact.telephone = telephone;
		
		list.add(contact);
		JOptionPane.showMessageDialog(null, "Contato "+ name +" adicionado!");
	}
	
	public void remove_contact (String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(name)) {
				list.remove(i);
				JOptionPane.showMessageDialog(null, "Contato "+ name +" removido!");
			}
		}
	}
	
	public void print_list () {
		String print = "";
		for (int i = 0; i < list.size(); i++) {
			print += "Nome: "+ list.get(i).name + "\n";
			print += "Telefone: "+ list.get(i).telephone + "\n\n";
		}
		
		if(print.equals("")) {
			JOptionPane.showMessageDialog(null, "Sem contatos cadastrados.");
		} else {
			JOptionPane.showMessageDialog(null, print);
		}
	}
}
