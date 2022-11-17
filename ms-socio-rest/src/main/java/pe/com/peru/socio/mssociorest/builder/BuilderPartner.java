package pe.com.peru.socio.mssociorest.builder;

import com.google.gson.Gson;
import pe.com.peru.socio.mssociorest.entity.Client;
import pe.com.peru.socio.mssociorest.entity.TypeDocument;
import pe.com.peru.socio.mssociorest.entity.TypeRelationship;
import pe.com.peru.socio.mssociorest.model.*;

import pe.com.peru.socio.mssociorest.util.Utilitario;

import java.text.ParseException;
import java.util.Date;

public class BuilderPartner {
	
  public PartnerResponse convertToResponse(Client client) {
  	Gson gson = new Gson();
  	System.out.println("Resultado del Entity: ".concat(gson.toJson(client)));
    PartnerResponse response = new PartnerResponse();
    response.setNames(client.getNames());
    response.setLastNameFather(client.getLastNameFather());
    response.setLastNameMother(client.getLastNameMother());
    response.setIdPartner(client.getCodClient());
    response.setRelationshipInfo(this.builderRelationshipInfo(client));
    response.setContactInfo(this.builderContactInfo(client));
    response.setMemberInfo(this.builderMemberInfo(client));
    return response;	
  }
  
  public Client convertToEntity(PartnerRequest partnerRequest) throws ParseException {
	Client client = new Client();
	client.setNames(partnerRequest.getNames());
	client.setLastNameFather(partnerRequest.getLastNameFather());
	client.setLastNameMother(partnerRequest.getLastNameMother());
	client.setDirection(partnerRequest.getDirection());
	client.setCreationDate(new Date());
	client.setMembershipDate(new Date());
	client.setBirthDate(Utilitario.convertToDate(partnerRequest.getBirthDate()));
	client.setTelephone(partnerRequest.getTelephone());
	client.setTypeRelationship(createTypeRelationshipEntity(partnerRequest.getTypeRelathionship()));
	client.setTypeDocument(createTypeDocumentEntity(partnerRequest.getTypeDocument()));
	client.setNumberDocument(partnerRequest.getNumberDocument());
	client.setUserValue(partnerRequest.getUserValue());
	client.setPasswordValue(partnerRequest.getPasswordValue());
	return client;
  }

  public TypeRelationship createTypeRelationshipEntity(Integer codType) {
    TypeRelationship type = new TypeRelationship();
    type.setCodRelationship(codType);
    return type;
  }

  public TypeDocument createTypeDocumentEntity(Integer codType) {
    TypeDocument type = new TypeDocument();
    type.setCodDocument(codType);
    return type;
  }
  
  private RelationshipInfo builderRelationshipInfo(Client client) {
	RelationshipInfo info = new RelationshipInfo();
	info.setCode(client.getTypeDocument().getCodDocument().toString());
	info.setDescription(client.getTypeDocument().getShortDescription());
	info.setNumberDocument(client.getNumberDocument());
	return info;
  }
  
  private ContactInfo builderContactInfo(Client client) {
	ContactInfo contact = new ContactInfo();
	contact.setTelephone(client.getTelephone());
	contact.setDirection(client.getDirection());
	contact.setBirthDate(Utilitario.formattDateLocal(client.getBirthDate()));
	return contact;
  }
  
  private MemberInfo builderMemberInfo(Client client) {
	MemberInfo info = new MemberInfo();
	info.setCreationDate(Utilitario.formattDateLocal(client.getCreationDate()));
	info.setMemebershipDate(Utilitario.formattDateLocal(client.getMembershipDate()));
	info.setUserValue(client.getUserValue());
	info.setPassword(client.getPasswordValue());
	return info;
  }
	

}
