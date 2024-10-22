package CMEPPS.practicaScrum.repositories;

import CMEPPS.practicaScrum.models.Tarea;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public interface TareaRepository
{
    Tarea findById(Long id);
}
