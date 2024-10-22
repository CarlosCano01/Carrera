package CMEPPS.practicaScrum.models;

import CMEPPS.practicaScrum.repositories.UsuarioRepository;
import CMEPPS.practicaScrum.services.UsuarioService;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public void crearUsuario()
    {
        
    }

    @Override
    public void validarUsuario()
    {
        
    }

}
