package project.demo3T.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Category {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id; 	//int max value: 2.1 billions
	private String name;
	private int priority;  
}
