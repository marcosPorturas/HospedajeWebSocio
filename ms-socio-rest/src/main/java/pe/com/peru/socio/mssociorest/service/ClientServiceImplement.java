package pe.com.peru.socio.mssociorest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Observable;
import io.reactivex.Single;
import pe.com.peru.socio.mssociorest.builder.BuilderPartner;
import pe.com.peru.socio.mssociorest.config.ApplicationProperties;
import pe.com.peru.socio.mssociorest.entity.Client;
import pe.com.peru.socio.mssociorest.model.PartnerRequest;
import pe.com.peru.socio.mssociorest.model.PartnerResponse;
import pe.com.peru.socio.mssociorest.model.PartnersResponse;
import pe.com.peru.socio.mssociorest.repository.ClientRepository;


@Service
@Slf4j
public class ClientServiceImplement implements ClientService{
	
	@Autowired
	ApplicationProperties properties;
	
	@Autowired
	ClientRepository socioRepository;

	BuilderPartner builder = new BuilderPartner();
	
	@Override
	public Single<PartnersResponse> listarSocios(String transactionId) {
		// TODO Auto-generated method stub
		log.info("[Metodo Listar Socio]");
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
	public Single<PartnerResponse> getSocio(Integer idSocio,String transactionId) {
		log.info("[Metodo Obtner Socio]");
		return Single.just(socioRepository.findById(idSocio).orElse(new Client()))
				.map(socio-> builder.convertToResponse(socio));
	}

	@Override
	public Single<PartnerResponse> addSocio(PartnerRequest partnerRequest,String transactionId) {
		// TODO Auto-generated method stub
		log.info("[Metodo Agregar Socio]");
		return Single.just(partnerRequest)
				.map(request -> builder.convertToEntity(request))
				.map(entity -> socioRepository.save(entity))
				.map(entitySave -> builder.convertToResponse(entitySave));
	}

}