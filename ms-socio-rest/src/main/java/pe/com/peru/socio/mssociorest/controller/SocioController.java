package pe.com.peru.socio.mssociorest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.reactivex.Maybe;
import pe.com.peru.socio.mssociorest.model.PartnersResponse;
import pe.com.peru.socio.mssociorest.service.ClientService;

@RestController
@RequestMapping("/socio")
public class SocioController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Maybe<ResponseEntity<PartnersResponse>> controllerParnerList() {
		return clientService.listarSocios()
				.map(response -> new ResponseEntity<>(response,HttpStatus.OK))
				.toMaybe();

	}
	
	
	
}
