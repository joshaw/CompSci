package loginRequest;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 40L;

	private String username;
	private int passwordHash;

	public LoginRequest(String username, String password) {
		this.username = username;
		this.passwordHash = password.hashCode();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public int getPasswordHash() {
		return passwordHash;
	}

	@Override
	public String toString() {
		return "Username: " + username + "\nPassHash: " + passwordHash;
	}

}
