package CMEPPS.practicaScrum.repositories;

import CMEPPS.practicaScrum.models.Usuario;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public interface UsuarioRepository
{
    Usuario findById(Long id);
}
