package pe.com.peru.socio.mssociorest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codClient;
	
	private Date creationDate;
	
	private Date updateDate;
	
	private Integer enabled;
	
	private String names;
	
	private String lastNameFather;
	
	private String lastNameMother;
	
	private String  direction;
	
	private Date birthDate;
	
	private Date membershipDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cod_relationship",referencedColumnName="cod_relationship")
	private TypeRelationship typeRelationship;
	
	private String telephone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cod_document",referencedColumnName="cod_document")
	private TypeDocument typeDocument;
	
	private String numberDocument;
	
	private String userValue;
	
	private String passwordValue;
	
}
