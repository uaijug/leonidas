package br.com.uaijug.leonidas.model.domain;

public enum Role {

	ADMIN("ADMIN"), USER("USER");

	private String role;

	private Role(String role) {
		this.setRole(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
