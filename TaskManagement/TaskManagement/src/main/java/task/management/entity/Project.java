package task.management.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	    private List<Task> tasks;

		public Project(Long id, String name, List<Task> tasks) {
			super();
			this.id = id;
			this.name = name;
			this.tasks = tasks;
		}

		public Project() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Task> getTasks() {
			return tasks;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}

		@Override
		public String toString() {
			return "Project [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
		}
	    
	    
}
