package com.isilep4.isilnet.controladores;

import com.isilep4.isilnet.entidades.Visita;
import com.isilep4.isilnet.repositorios.VisitaRepository;
import com.isilep4.isilnet.servicios.VisitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller

public class VisitaController {
    private final VisitaService visitaService;


    @GetMapping("/visitas")
    public String listarVisitas(Model model) {
        List<Visita> visitas = visitaService.obtenerVisitas();
        model.addAttribute("visitas", visitas);
        return "listar_visitas";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("visita", new Visita());
        return "crear_visitas";
    }

    @PostMapping("/crear")
    public String add(@ModelAttribute("visita") Visita visita) {
        if (visitaService.existeVisitaConDniAfiliado(visita.getDniAfiliado())) {
            return "Dni_duplicado";
        }
        visitaService.addVisita(visita);
        return "redirect:/visitas";
    }



    @PutMapping("/crear")
    public String actualizar(@ModelAttribute("visita") Visita visita) {
        visitaService.addVisita(visita);
        return "redirect:/visitas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) throws Exception {
        Visita visita = visitaService.obtenerPorId(id);

        model.addAttribute("visita", visita);
        return "formulario_edicion";
    }

    @PostMapping("/editar/{id}")
    public String actualizarVisita(@PathVariable("id") Long id, @ModelAttribute("visita") Visita visita) {
        if (visitaService.existeVisitaConDniAfiliado(visita.getDniAfiliado())) {
            return "Dni_duplicado";
        }
        visita.setId(id);
        visitaService.addVisita(visita);
        return "redirect:/visitas";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id){
        visitaService.eliminar(id);
        return "redirect:/visitas";
    }
}