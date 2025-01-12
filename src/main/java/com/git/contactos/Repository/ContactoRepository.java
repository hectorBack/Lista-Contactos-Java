package com.git.contactos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.git.contactos.Entity.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

}
