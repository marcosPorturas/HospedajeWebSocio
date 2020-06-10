package com.hospedaje.web.socio.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hospedaje.web.socio.dto.response.SocioResponse;
import com.hospedaje.web.socio.entity.Socio;

public class Utilitario {
	
	
	
	public static String convertirFechaddMMYYYY (Date date) {
		String dateConvert = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dateConvert = sdf.format(date);
		return dateConvert;
	}
	
	public static SocioResponse dtoSocioResponse(Socio socio) {
		SocioResponse socioResponse = new SocioResponse();
		socioResponse.setIdSocio(socio.getIdSocio());
		socioResponse.setNombres(socio.getNombres());
		socioResponse.setApellidos(socio.getApellidos());
		socioResponse.setCreationDate(convertirFechaddMMYYYY(socio.getCreationDate()));
		socioResponse.setEnabled(socio.isEnabled());
		return socioResponse;
	}
	
}
