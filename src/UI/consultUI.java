package UI;

import Functions.*;
import static dit042.SimpleIO.*;

public class consultUI {
	private functions function;
	
	public consultUI() {
		this.function = new functions();
	}
	
	public static void main(String[] args){
		consultUI program = new consultUI();
		program.run();
	}
	
	public void run() {
		int ans ;
		final int ADDUSER = 1;
		final int SHOWUSER = 2;
		final int DELETEUSER = 3;
		final int EXIT = 4;
		println("welcome to telefonebook");
			do {
				
				println("to add new number press 1");
				println("to see available numbers press 2");
				println("to delete number press 3");
				println("to exit press 4");
				ans = readInt();
				
				switch (ans) {
					case ADDUSER:
						println("enter the firstName");
						String first = readString();
						println("enter the last name");
						String last = readString();
						println("enter the phone number");
						int tel = readInt();
						try {
							function.addUser(first, last, tel);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
						
					case SHOWUSER:
						println(function.printAllUsers());
						break;
					case DELETEUSER:
						println("enter the first name");
						String firstname = readString();
						println("enter the last name");
						String lastname = readString();
						try {
							function.deleteUser(firstname, lastname);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
						
					case EXIT:
						break;
					}
			}
		while(ans != EXIT);{
			println("Goodbye");
			}
	}
}
