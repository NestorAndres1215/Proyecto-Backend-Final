package com.naat.proyectofutbol.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;

public class CustomGrantedAuthorityDeserializer extends StdDeserializer<GrantedAuthority> {

  
	private static final long serialVersionUID = 1L;

	public CustomGrantedAuthorityDeserializer() {
        super(GrantedAuthority.class);
    }

    @Override
    public GrantedAuthority deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        // Implementa la lógica de deserialización según tus necesidades
        // Puedes crear instancias de clases concretas que implementen GrantedAuthority
        return null; // Debes reemplazar esto con tu lógica
    }
}
