package project.demo3T.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // int max value: 2.1 billions
	private String name;
	
	@Column(name="created_by")	
	private String createdBy;
	
	@Column(name="created_date",nullable = false, updatable = false)
	private LocalDateTime createdDate;
	
	@Column(name="modify_by")
	private String modifiedBy;
	
	@Column(name="modify_date")
	private LocalDateTime modifiedDate;
	

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<Product> products;


	@PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
	}
	
	@PreUpdate 
	protected void onUpdate() {
		modifiedDate = LocalDateTime.now();
	}	
	
}
