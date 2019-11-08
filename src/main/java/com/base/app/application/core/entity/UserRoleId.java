package com.base.app.application.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UserRoleId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "role_id", nullable = false)
	private Integer roleId;

}
