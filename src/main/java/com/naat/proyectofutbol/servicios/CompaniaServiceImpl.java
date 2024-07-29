package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.naat.proyectofutbol.entidades.Compania;
import com.naat.proyectofutbol.repositorios.CompaniaRepository;

@Service
public class CompaniaServiceImpl implements CompaniaService {

	private final CompaniaRepository repository;

	@Autowired
	public CompaniaServiceImpl(CompaniaRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Compania> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Map<String, Object>> listar(int opcion, Compania obj) {
		return repository.listar(opcion,obj.getCom_codigo(), obj.getCom_nombre(), obj.getCom_logo(),
				obj.getCom_ruc(),obj.getCom_telefono(),obj.getCom_correo(),obj.getCom_direccion(),
				obj.getCom_pais(),obj.getCom_sector(),obj.getCom_fecha_de_fundacion(),obj.getCom_descripcion());
	}

	@Override
	public Compania guardarImagen(String com_codigo, Compania obj, MultipartFile archivo) throws IOException {
		Optional<Compania> usuarioOptional = repository.findById(com_codigo);
		Compania usuario;
		if (usuarioOptional.isPresent()) {
			usuario = usuarioOptional.get();
		} else {
			usuario = new Compania();
			usuario.setCom_codigo(com_codigo);
		}
		if (archivo.getOriginalFilename().equals("imagen.jpeg")) {
			obj.setCom_logo(obj.getCom_logo());

		}else{
			usuario.setCom_logo(archivo.getBytes());
		}

		usuario.setCom_nombre(obj.getCom_nombre());
		usuario.setCom_direccion(obj.getCom_direccion());
		usuario.setCom_telefono(obj.getCom_telefono());
		usuario.setCom_correo(obj.getCom_correo());
		usuario.setCom_pais(obj.getCom_pais());
		usuario.setCom_sector(obj.getCom_sector());
		usuario.setCom_ruc(obj.getCom_ruc());
		usuario.setCom_descripcion(obj.getCom_descripcion());
		usuario.setCom_fecha_de_fundacion(obj.getCom_fecha_de_fundacion());

		return repository.save(usuario);
	}
	public boolean telefonoEsValido(String telefono) {
		return telefono.matches("\\d{9}");
	}

	@Override
	public boolean rucesValido(String ruc)  {
		return ruc.matches("\\d{11}");
	}
}
