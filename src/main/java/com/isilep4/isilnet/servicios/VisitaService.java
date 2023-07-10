package com.isilep4.isilnet.servicios;

import com.isilep4.isilnet.entidades.Visita;
import com.isilep4.isilnet.exception.VisitaNoEncontrada;
import com.isilep4.isilnet.repositorios.VisitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VisitaService {

    private final VisitaRepository visitaRepository;
    public List<Visita> obtenerVisitas(){
        return visitaRepository.findAll();
    }

    public Visita obtenerPorId(Long id) throws Exception{
        Optional<Visita> visita = visitaRepository.findById(id);
        if (visita.isPresent()){
            return visita.get();
        }else {
            throw new Exception("La visita no existe");
        }
    }

    public  Visita addVisita(Visita visita){
        return visitaRepository.save(visita);
    }

    public Visita obtenerPorDniAfiliado(String dniAfiliado) {
        return visitaRepository.findByDniAfiliado(dniAfiliado);
    }
    public boolean existeVisitaConDniAfiliado(String dniAfiliado) {
        return visitaRepository.existsByDniAfiliado(dniAfiliado);
    }
    public void eliminar(Long id){
        visitaRepository.delete(visitaRepository.findById(id).orElseThrow(
                ()-> new VisitaNoEncontrada(id)
        ));
    }
}
