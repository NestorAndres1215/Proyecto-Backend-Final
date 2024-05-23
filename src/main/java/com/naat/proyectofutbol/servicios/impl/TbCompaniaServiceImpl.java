package com.naat.proyectofutbol.servicios.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naat.proyectofutbol.entidades.TbCompania;
import com.naat.proyectofutbol.entidades.TbUsuario;
import com.naat.proyectofutbol.repositorios.TbCompaniaRepository;
import com.naat.proyectofutbol.servicios.TbCompaniaService;
@Service
public class TbCompaniaServiceImpl implements TbCompaniaService {

    private final TbCompaniaRepository repository;

    @Autowired
    public TbCompaniaServiceImpl(TbCompaniaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Map<String, Object[]>> listaCompania(int opcion, TbCompania obj) {
        return repository.listaCompania(opcion, obj.getCom_codigo(), obj.getCom_nombre(), 
                                        obj.getCom_ruc(), obj.getCom_telefono(), obj.getCom_correo(), 
                                        obj.getCom_direccion(), obj.getCom_pais(), obj.getCom_sector(), 
                                        obj.getCom_fecha_de_fundacion(), obj.getCom_descripcion());
    }

	@Override
	public TbCompania guardarImagen(String com_codigo, TbCompania obj, MultipartFile archivo) throws IOException {
		
		Optional<TbCompania> usuarioOptional = repository.findById(com_codigo);
		TbCompania usuario;
		if (usuarioOptional.isPresent()) {
			usuario = usuarioOptional.get();
		} else {
			usuario = new TbCompania();
			 // Update all fields


			usuario.setCom_codigo(com_codigo);
		}	        usuario.setCom_nombre(obj.getCom_nombre());
	        usuario.setCom_direccion(obj.getCom_direccion());
	        usuario.setCom_telefono(obj.getCom_telefono());
	        usuario.setCom_correo(obj.getCom_correo());
	        usuario.setCom_pais(obj.getCom_pais());
	        usuario.setCom_sector(obj.getCom_sector());
	        usuario.setCom_ruc(obj.getCom_ruc());
	        usuario.setCom_descripcion(obj.getCom_descripcion());
	        usuario.setCom_fecha_de_fundacion(obj.getCom_fecha_de_fundacion());
		usuario.setCom_logo(archivo.getBytes());
		return repository.save(usuario);
	}
	
	
	 
}
