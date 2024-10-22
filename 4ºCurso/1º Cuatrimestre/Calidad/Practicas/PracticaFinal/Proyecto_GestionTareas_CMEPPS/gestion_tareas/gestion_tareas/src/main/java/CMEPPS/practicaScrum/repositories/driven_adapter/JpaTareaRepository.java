package CMEPPS.practicaScrum.repositories.driven_adapter;

import CMEPPS.practicaScrum.models.Tarea;
import CMEPPS.practicaScrum.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
@Component
public class JpaTareaRepository implements TareaRepository
{

    @Autowired
    private HAAJpaRepositoryTarea haaJpaRepositoryTarea;

    @Override
    public Tarea findById(Long id)
    {
        return null;
    }
}
