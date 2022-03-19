package com.exam.examServer.modals;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Role {
	@Id
	private Long id;
	private String roleName;
	
	 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "role")
	 Set<UserRole> userRoles=new HashSet<UserRole>();

}
