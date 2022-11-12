package com.hospedaje.web.socio.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {
	
	
	
	public static String formattDateLocal (Date date) {
		String dateConvert = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dateConvert = sdf.format(date);
		return dateConvert;
	}
	
	
	
}
