package pe.com.peru.socio.mssociorest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Observable;
import io.reactivex.Single;
import pe.com.peru.socio.mssociorest.builder.BuilderPartner;
import pe.com.peru.socio.mssociorest.config.ApplicationProperties;
import pe.com.peru.socio.mssociorest.model.PartnerRequest;
import pe.com.peru.socio.mssociorest.model.PartnerResponse;
import pe.com.peru.socio.mssociorest.model.PartnersResponse;
import pe.com.peru.socio.mssociorest.repository.ClientRepository;

@Service
public class ClientServiceImplement implements ClientService{
	
	@Autowired
	ApplicationProperties properties;
	
	@Autowired
	ClientRepository socioRepository;

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
	public Single<PartnerResponse> addSocio(PartnerRequest partnerRequest) {
		// TODO Auto-generated method stub
		return null;
	}


}