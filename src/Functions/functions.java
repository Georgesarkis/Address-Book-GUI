package Functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Classes.*;

public class functions {
	public List <user> userlist;
	Gson objGson ;
	
	public functions() {
		this.userlist = new ArrayList<>();
		objGson = new GsonBuilder().create();
	}
	
	public user retriveUser(String firstName , String lastName) {
		for(int i = 0 ; i < userlist.size() ; i++) {
			if(userlist.get(i).getFirstName().equals(firstName)&& userlist.get(i).getLastName().equals(lastName)) {
				return userlist.get(i);
			}
		}
		return null;
	}
	
	public void addUser(String firstName , String lastName , int tel) throws Exception {
		user users = retriveUser(firstName, lastName);
		if(users == null) {
		user newuser = new user ( firstName , lastName , tel);
		userlist.add(newuser);
		}
		else {
			throw new Exception ("user is already exict");
		}
	}
	
	public void deleteUser(String first , String last) throws Exception {
		user users = retriveUser(first, last);
		if(users != null) {
		userlist.remove(users);
		}
		else {
			throw new Exception("user doesn't excist");
		}
	}
	
	public String printAllUsers() {
		String all = "";
		for(int i = 0; i < userlist.size() ; i++) {
			all = all + userlist.get(i).toString();
		}
		return all;
	}
	
	public void saveGson() {
		try {
			FileOutputStream file = new FileOutputStream("userlist.txt");
			String s = objGson.toJson(userlist);
			Writer writer = new FileWriter("userlist.txt");
			writer.write(s);
			writer.close();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readGson() {
		List<user> list = null;
		try {
			File pointFile = new File("userlist.txt");
			Scanner pointReader = new Scanner(pointFile);
			String gson = pointReader.nextLine();
			Type listType = new TypeToken<List<user>>(){}.getType();
			list = (List<user>) new Gson().fromJson( gson , listType); //objGson.fromJson(gson, listType);
			pointReader.close();
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		userlist = list;
	}
	
}
