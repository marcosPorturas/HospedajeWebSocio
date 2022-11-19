package pe.com.peru.socio.mssociorest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.reactivex.Maybe;
import pe.com.peru.socio.mssociorest.model.PartnerRequest;
import pe.com.peru.socio.mssociorest.model.PartnerResponse;
import pe.com.peru.socio.mssociorest.model.PartnersResponse;
import pe.com.peru.socio.mssociorest.service.ClientService;


@RestController
@RequestMapping("/socio")
public class SocioController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Maybe<ResponseEntity<PartnersResponse>> controllerPartnerList(
	  @RequestHeader("TransactionId")String transactionId) {
		return clientService.listarSocios(transactionId)
				.map(response -> new ResponseEntity<>(response,HttpStatus.OK))
				.toMaybe();

	}

	@GetMapping(value = "/obtener", produces = MediaType.APPLICATION_JSON_VALUE)
	public Maybe<ResponseEntity<PartnerResponse>> controllerPartnerGet(@RequestParam Integer idSocio,
	  @RequestHeader("TransactionId")String transactionId) {
		return clientService.getSocio(idSocio,transactionId)
				.map(response -> new ResponseEntity<>(response,HttpStatus.OK))
				.toMaybe();

	}

	@PostMapping(value = "/agregar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Maybe<ResponseEntity<PartnerResponse>> controllerPartnerAdd(@RequestBody PartnerRequest partnerRequest,
	  @RequestHeader("TransactionId")String transactionId) {
		return clientService.addSocio(partnerRequest,transactionId)
				.map(response -> new ResponseEntity<>(response,HttpStatus.OK))
				.toMaybe();

	}
	
	
	
}
