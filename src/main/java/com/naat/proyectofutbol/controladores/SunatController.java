package com.naat.proyectofutbol.controladores;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/sunat")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class SunatController {
	
	
	 @GetMapping(value = { "/moneda/{anio}/{mes}" })
	    @ResponseBody
	    public List<Object> swCrearTcb(
	            @PathVariable("mes") String mes,
	            @PathVariable("anio") String anio) throws Exception {

	        String url = "https://api.apis.net.pe/v1/tipo-cambio-sunat?month=" + mes + "&year=" + anio;

	        RestTemplate restTemplate = new RestTemplate();

	        Object[] monedas = restTemplate.getForObject(url, Object[].class);

			return Arrays.asList(monedas);
	    }
}
