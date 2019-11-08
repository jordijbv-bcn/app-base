package com.base.app.application.core.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRoleId id;

}
