package CMEPPS.practicaScrum.models;

import CMEPPS.practicaScrum.repositories.TareaRepository;
import CMEPPS.practicaScrum.services.TareaService;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public class TareaServiceImpl implements TareaService{

    private final TareaRepository tareaRepository;

    public TareaServiceImpl(TareaRepository tareaRepository)
    {
        this.tareaRepository = tareaRepository;
    }
    
    @Override
    public void crearTarea()
    {
        
    }

    @Override
    public void editarTarea()
    {
        
    }

    @Override
    public void eliminarTarea()
    {
        
    }

    @Override
    public void mostrarTareas()
    {
        
    }
}
