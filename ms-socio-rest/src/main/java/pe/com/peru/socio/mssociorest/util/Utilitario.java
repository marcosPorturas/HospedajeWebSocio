package pe.com.peru.socio.mssociorest.util;

import org.springframework.beans.factory.annotation.Autowired;
import pe.com.peru.socio.mssociorest.config.ApplicationProperties;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {

	
	public static String formattDateLocal (Date date) {
		String dateConvert = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dateConvert = sdf.format(date);
		return dateConvert;
	}

	public static Date convertToDate(String date) throws ParseException {
		String string = date;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateConvert = format.parse(string);
		return dateConvert;
	}

	
}
