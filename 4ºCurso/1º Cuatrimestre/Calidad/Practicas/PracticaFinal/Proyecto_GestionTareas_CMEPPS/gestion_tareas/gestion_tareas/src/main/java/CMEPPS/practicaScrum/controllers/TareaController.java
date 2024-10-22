package CMEPPS.practicaScrum.controllers;

import CMEPPS.practicaScrum.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
@Controller
public class TareaController
{
    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService)
    {
        this.tareaService = tareaService;
    }  
}
