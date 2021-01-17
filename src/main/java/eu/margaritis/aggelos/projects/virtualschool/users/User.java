package eu.margaritis.aggelos.projects.virtualschool.users;

public class User {

	private final String username;
	private final String password;
	private final Role role;
	
	public User(final String username, final String password, final Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
		UserUtil.getUsers().add(this);
	}

	public final String getUsername() {
		return username;
	}

	public final String getPassword() {
		return password;
	}

	public final Role getRole() {
		return role;
	}
	
}