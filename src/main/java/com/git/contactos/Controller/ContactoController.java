package com.git.contactos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.git.contactos.Entity.Contacto;
import com.git.contactos.Service.ContactoService;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
	
	@Autowired
    private ContactoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("contactos", service.listarTodos());
        return "contactos";
    }

    @GetMapping("/nuevo")
    public String nuevoFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario_contacto";
    }

    @PostMapping
    public String guardar(@ModelAttribute Contacto contacto) {
        service.guardar(contacto);
        return "redirect:/contactos";
    }

    @GetMapping("/editar/{id}")
    public String editarFormulario(@PathVariable Long id, Model model) {
        model.addAttribute("contacto", service.buscarPorId(id));
        return "formulario_contacto";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/contactos";
    }

}
