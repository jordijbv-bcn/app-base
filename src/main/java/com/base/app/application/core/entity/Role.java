package com.base.app.application.core.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=IDENTITY)    
    @Column(name="id", unique=true, nullable=false)
	private Integer id;
    
    @Column(name="user_role", length=255)
	private String userRole;

	public Role(Integer id) {
		super();
		this.id = id;
	}

}
