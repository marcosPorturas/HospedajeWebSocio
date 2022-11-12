package com.hospedaje.web.socio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.web.socio.builder.BuilderPartner;
import com.hospedaje.web.socio.config.ApplicationProperties;
import com.hospedaje.web.socio.dto.PartnerRequest;
import com.hospedaje.web.socio.dto.PartnerResponse;
import com.hospedaje.web.socio.dto.PartnersResponse;
import com.hospedaje.web.socio.repository.ClientRepository;

import io.reactivex.Observable;
import io.reactivex.Single;

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