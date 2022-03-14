package prodando.leonel.tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import prodando.leonel.tareas.model.tarea;
import prodando.leonel.tareas.repo.TareaRepository;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class tareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("")
    List<tarea> index(){

        return tareaRepository.findAll();
    }
//CREAR TAREA
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    tarea create(@RequestBody tarea tarea){
        return tareaRepository.save(tarea);
    }
//ACTULIZAR TAREA
    @PutMapping("{id}")
    tarea update(@PathVariable String id, @RequestBody tarea tarea){

        tarea tareaFromDb = tareaRepository
                    .findById(id)
                    .orElseThrow(RuntimeException::new);

        tareaFromDb.setNombre(tarea.getNombre());
        tareaFromDb.setCompletado(tarea.isCompletado());
        
        return tareaRepository.save(tareaFromDb);
    }

//ELIMINAR TAREA
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("{id}")
void delete(@PathVariable String id){
    tarea tarea = tareaRepository
                    .findById(id)
                    .orElseThrow(RuntimeException::new);
    
    tareaRepository.delete(tarea);
}
}
