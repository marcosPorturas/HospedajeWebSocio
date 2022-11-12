package com.hospedaje.web.socio.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_type_relationship")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeRelationship implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_relationship")
	private Integer codRelationship;
	
	private String description;

}
