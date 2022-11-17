package pe.com.peru.socio.mssociorest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.transaction.annotation.Transactional;
import pe.com.peru.socio.mssociorest.builder.BuilderPartner;
import pe.com.peru.socio.mssociorest.config.ApplicationProperties;
import pe.com.peru.socio.mssociorest.entity.Client;
import pe.com.peru.socio.mssociorest.entity.TypeDocument;
import pe.com.peru.socio.mssociorest.entity.TypeRelationship;
import pe.com.peru.socio.mssociorest.model.PartnerRequest;
import pe.com.peru.socio.mssociorest.model.PartnerResponse;
import pe.com.peru.socio.mssociorest.model.PartnersResponse;
import pe.com.peru.socio.mssociorest.repository.ClientRepository;
import pe.com.peru.socio.mssociorest.repository.TypeDocumentRepository;
import pe.com.peru.socio.mssociorest.repository.TypeRelationshipRepository;
import pe.com.peru.socio.mssociorest.util.Utilitario;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class ClientServiceImplement implements ClientService{
	
	@Autowired
	ApplicationProperties properties;
	
	@Autowired
	ClientRepository socioRepository;
	@Autowired
	TypeDocumentRepository typeDocumentRepository;
	@Autowired
	TypeRelationshipRepository typeRelationshipRepository;

	BuilderPartner builder = new BuilderPartner();
	
	@Override
	public Single<PartnersResponse> listarSocios() {
		// TODO Auto-generated method stub
		return Observable.fromIterable(socioRepository.findAll())
				.map(socio -> builder.convertToResponse(socio))
				.toList()
				.map(list -> {
					PartnersResponse response = new PartnersResponse();
					response.setPartners(list);
					return response;
				});
	}

	@Override
	public Single<PartnerResponse> getSocio(Integer idSocio) {
		return Single.just(socioRepository.findById(idSocio).orElse(new Client()))
				.map(socio-> builder.convertToResponse(socio));
	}

	@Override
	public Single<PartnerResponse> addSocio(PartnerRequest partnerRequest) {
		// TODO Auto-generated method stub
		return Single.just(partnerRequest)
				.map(request -> builder.convertToEntity(request))
				.map(entity -> socioRepository.save(entity))
				.map(entitySave -> this.agreeDescription(entitySave))
				.map(entityUpdate -> builder.convertToResponse(entityUpdate));
	}

	private Client agreeDescription(Client client) {
		TypeRelationship typeRelationship = typeRelationshipRepository
				.findById(client.getTypeRelationship().getCodRelationship())
				.orElse(null);
		TypeDocument typeDocument = typeDocumentRepository
				.findById(client.getTypeDocument().getCodDocument())
				.orElse(null);
		client.setTypeDocument(typeDocument);
		client.setTypeRelationship(typeRelationship);
		return client;
	}

}