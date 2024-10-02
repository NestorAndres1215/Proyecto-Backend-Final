package com.naat.proyectofutbol.controladores;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/sunat")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")
public class SunatController {


	private static final int MAX_RETRIES = 3;
	private static final long BASE_DELAY = 1000; // 1 segundo
	@GetMapping(value = { "/moneda/{anio}/{mes}" })
	@ResponseBody
	public List<Object> swCrearTcb(
			@PathVariable("mes") String mes,
			@PathVariable("anio") String anio) throws Exception {
		String url = "https://api.apis.net.pe/v1/tipo-cambio-sunat?month=" + mes + "&year=" + anio;

		RestTemplate restTemplate = new RestTemplate();

		int attempt = 0;
		while (attempt < MAX_RETRIES) {
			try {
				Object[] monedas = restTemplate.getForObject(url, Object[].class);
				return Arrays.asList(monedas);
			} catch (HttpClientErrorException e) {
				if (e.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
					attempt++;
					long delay = BASE_DELAY * (long) Math.pow(2, attempt); // Exponential backoff
					Thread.sleep(delay);
				} else {
					throw e;
				}
			}
		}

		throw new Exception("Error al obtener datos después de varios intentos.");
	}
}
