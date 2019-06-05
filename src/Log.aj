import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;  

public aspect Log {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
	
	pointcut insertingContact (String name, String telephone): call(* Contact.insert_contact(String, String)) 
										  					&& args(name, telephone);
	
	pointcut removingContact (String name): call(* Contact.remove_contact(String)) 
												&& args(name);
	
	before(String name, String telephone): insertingContact (name, telephone) {
		String text = "INSERT ["+ name +", "+ telephone +"] - "+ dtf.format(LocalDateTime.now());
		
		System.out.println(text);
		
		try {
			File temp = File.createTempFile("contacts", ".txt");
			boolean exists = temp.exists();
			
			if (!exists) {
				FileWriter writer = new FileWriter("contacts.txt");
				BufferedWriter bf = new BufferedWriter(writer);
				bf.write(text);
				bf.close();
			} else {
				Writer output = new BufferedWriter(new FileWriter("contacts.txt", true));
				output.append("\n");
				output.append(text);
				output.close();
			}
		} catch(IOException err) {
			System.out.println(err);
		}
	}
	
	after(String name): removingContact (name) {
		String text = "REMOVE ["+ name +"] - "+ dtf.format(LocalDateTime.now());
		
		System.out.println(text);

		try {
			File temp = File.createTempFile("contacts", ".txt");
			boolean exists = temp.exists();
			
			if (!exists) {
				FileWriter writer = new FileWriter("contacts.txt");
				BufferedWriter bf = new BufferedWriter(writer);
				bf.write(text);
				bf.close();
			} else {
				Writer output = new BufferedWriter(new FileWriter("contacts.txt", true));
				output.append("\n");
				output.append(text);
				output.close();
			}
		} catch(IOException err) {
			System.out.println(err);
		}
	}
}
