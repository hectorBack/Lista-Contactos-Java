package com.git.contactos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.contactos.Entity.Contacto;
import com.git.contactos.Repository.ContactoRepository;

@Service
public class ContactoService {
	
	@Autowired
    private ContactoRepository repository;

    public List<Contacto> listarTodos() {
        return repository.findAll();
    }

    public Contacto guardar(Contacto contacto) {
        return repository.save(contacto);
    }

    public Contacto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
