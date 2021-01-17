package eu.margaritis.aggelos.projects.virtualschool.users;

public enum Role {

	GUEST, STUDENT, TEACHER;

	public static final Role getRoleByString(String role) {
		return valueOf(role);
	}
		
	public static final String getRoleAsString(Role role) {
		return role.toString();	
	}
	
	public final String getRoleAsString() {
		return this.toString();	
	}
	
	@Override
	public final String toString() {
		return super.toString().toLowerCase();
	}

}
