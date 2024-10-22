package CMEPPS.practicaScrum.repositories.driven_adapter;

import CMEPPS.practicaScrum.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public interface HAAJpaRepositoryUsuario extends JpaRepository<Usuario, Long>
{

}
