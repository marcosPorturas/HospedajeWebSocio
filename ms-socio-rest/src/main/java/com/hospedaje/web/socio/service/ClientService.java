package com.hospedaje.web.socio.service;

import com.hospedaje.web.socio.dto.PartnerRequest;
import com.hospedaje.web.socio.dto.PartnerResponse;
import com.hospedaje.web.socio.dto.PartnersResponse;

import io.reactivex.Single;


public interface ClientService {

	Single<PartnersResponse> listarSocios();
	Single<PartnerResponse> addSocio(PartnerRequest partnerRequest);
}
