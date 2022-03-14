package prodando.leonel.tareas.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import prodando.leonel.tareas.model.tarea;

public interface TareaRepository extends MongoRepository<tarea, String>{
    
}
