import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String args[]) throws IOException {
		Contact contacts = new Contact();

		int choice = 0;
		while (choice != 4) {
			choice = Integer.parseInt(
					JOptionPane.showInputDialog(
							"1 - Adicionar um Contato\n" +
							"2 - Remover um Contato\n" +
							"3 - Ver contatos\n" +
							"4 - Sair\n "
					));
			
			String name;
			switch(choice) {
				
				case 1:
					name = JOptionPane.showInputDialog("Insira o nome:");
					String telephone = JOptionPane.showInputDialog("Insira o telefone:");
					contacts.insert_contact(name, telephone);
					break;
					
				case 2:
					name = JOptionPane.showInputDialog("Insira o nome a ser removido:");
					contacts.remove_contact(name);
					break;
					
				case 3:
					contacts.print_list();
					break;
					
				case 4:
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Comando Invalido!");
			}
		}
	}
}
 