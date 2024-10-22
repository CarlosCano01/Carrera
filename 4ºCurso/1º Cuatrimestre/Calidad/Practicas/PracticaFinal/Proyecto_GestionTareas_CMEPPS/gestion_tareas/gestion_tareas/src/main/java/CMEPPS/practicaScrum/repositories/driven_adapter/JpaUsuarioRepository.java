package CMEPPS.practicaScrum.repositories.driven_adapter;

import CMEPPS.practicaScrum.models.Usuario;
import CMEPPS.practicaScrum.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
@Component
public class JpaUsuarioRepository implements UsuarioRepository
{
    @Autowired
    private HAAJpaRepositoryUsuario haaJpaRepositoryUsuario;

    @Override
    public Usuario findById(Long id)
    {
        return null;
    }
}