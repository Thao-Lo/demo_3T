package project.demo3T.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	
	@Column(name="image_name")
	private String imageName;
	
	@Lob
	@Column(name="image_data")
	private byte[] imageData;
	
	@Column(name="created_by")	
	private String createdBy;
	
	@Column(name="created_date",nullable = false, updatable = false)
	private LocalDateTime createdDate;
	
	@Column(name="modify_by")
	private String modifiedBy;
	
	@Column(name="modify_date")
	private LocalDateTime modifiedDate;
	
	
	
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
	
    @PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
	}
	
	@PreUpdate 
	protected void onUpdate() {
		modifiedDate = LocalDateTime.now();
	}	
	
}
