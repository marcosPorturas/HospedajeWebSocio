package pe.com.peru.socio.mssociorest.service;

import io.reactivex.Single;
import pe.com.peru.socio.mssociorest.model.PartnerRequest;
import pe.com.peru.socio.mssociorest.model.PartnerResponse;
import pe.com.peru.socio.mssociorest.model.PartnersResponse;


public interface ClientService {

	Single<PartnersResponse> listarSocios();
	Single<PartnerResponse> getSocio(Integer idSocio);
	Single<PartnerResponse> addSocio(PartnerRequest partnerRequest);
}
