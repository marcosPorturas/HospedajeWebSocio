package com.hospedaje.web.socio.builder;

import com.hospedaje.web.socio.dto.ContactInfo;
import com.hospedaje.web.socio.dto.MemberInfo;
import com.hospedaje.web.socio.dto.PartnerRequest;
import com.hospedaje.web.socio.dto.PartnerResponse;
import com.hospedaje.web.socio.dto.RelationshipInfo;
import com.hospedaje.web.socio.entity.Client;
import com.hospedaje.web.socio.util.Utilitario;

public class BuilderPartner {
	
  public PartnerResponse convertToResponse(Client client) {
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
  
  public Client convertToEntity(PartnerRequest partnerRequest) {
	Client client = new Client();
	
	return client;
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
