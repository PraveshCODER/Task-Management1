package task.management.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String fullName;

    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
    private List<Task> assignedTasks;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String username, String fullName, List<Task> assignedTasks) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.assignedTasks = assignedTasks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Task> getAssignedTasks() {
		return assignedTasks;
	}

	public void setAssignedTasks(List<Task> assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", fullName=" + fullName + ", assignedTasks="
				+ assignedTasks + "]";
	}
    
    

}
