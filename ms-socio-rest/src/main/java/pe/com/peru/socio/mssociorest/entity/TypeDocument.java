package pe.com.peru.socio.mssociorest.entity;

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
@Table(name="tbl_type_document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeDocument implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_document")
	private Integer codDocument;
	
	private String shortDescription;

}
