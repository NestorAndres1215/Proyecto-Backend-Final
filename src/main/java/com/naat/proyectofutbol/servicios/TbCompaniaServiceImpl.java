package com.naat.proyectofutbol.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.naat.proyectofutbol.constrainst.UsuarioError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.naat.proyectofutbol.entidades.TbCompania;
import com.naat.proyectofutbol.repositorios.TbCompaniaRepository;

@Service
public class TbCompaniaServiceImpl implements TbCompaniaService {

	private final TbCompaniaRepository repository;

	@Autowired
	public TbCompaniaServiceImpl(TbCompaniaRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<TbCompania> findAll() {
		return repository.findAll();
	}

	@Override
	public TbCompania guardarImagen(String com_codigo, TbCompania obj, MultipartFile archivo) throws IOException {
		Optional<TbCompania> usuarioOptional = repository.findById(com_codigo);
		TbCompania usuario;
		if (usuarioOptional.isPresent()) {
			usuario = usuarioOptional.get();
		} else {
			usuario = new TbCompania();
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
