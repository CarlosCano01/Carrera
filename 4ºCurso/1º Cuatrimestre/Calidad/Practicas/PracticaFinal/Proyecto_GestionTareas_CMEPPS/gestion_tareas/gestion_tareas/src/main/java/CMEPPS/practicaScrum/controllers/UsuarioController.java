package CMEPPS.practicaScrum.controllers;

import CMEPPS.practicaScrum.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public class UsuarioController
{
    private final UsuarioService tareaService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService)
    {
        this.tareaService = usuarioService;
    }
}
