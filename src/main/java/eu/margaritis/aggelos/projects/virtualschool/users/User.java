package eu.margaritis.aggelos.projects.virtualschool.users;

public class User {

	private final String username;
	private final String password;
	private final Role role;
	private final String firstName;
	private final String lastName;

	public User(final String username, final String password, final Role role, final String firstName, final String lastName) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public final String getFirstName() {
		return firstName;
	}

	public final String getLastName() {
		return lastName;
	}

}