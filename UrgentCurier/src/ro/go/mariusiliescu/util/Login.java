package ro.go.mariusiliescu.util;

import java.util.ArrayList;
import java.util.List;

import ro.go.mariusiliescu.entities.LoginData;
import ro.go.mariusiliescu.entities.persoane.Receptioner;

/**
 * 
 * @author Marius Iliescu
 *
 */
public class Login {
	
    public static boolean authenticate(final String username, final String password) {
    	List<Receptioner> users = new ArrayList<>();
    	Boolean success = false; 	
    	final LoginData data = new LoginData(username, password);
		 
		for (Receptioner user : users) {
			if (user.getLoginData().getUsername().equals(data.getUsername()) && 
				user.getLoginData().getPassword().equals(SHAEncryption.encript(data.getPassword()))) {
				success = true;
				user.getLoginData().setIsLogged(true);
			}
		}
		return success;
    }
}