package CMEPPS.practicaScrum.services.configuration;

import CMEPPS.practicaScrum.models.TareaServiceImpl;
import CMEPPS.practicaScrum.models.UsuarioServiceImpl;
import CMEPPS.practicaScrum.repositories.TareaRepository;
import CMEPPS.practicaScrum.repositories.UsuarioRepository;
import CMEPPS.practicaScrum.services.TareaService;
import CMEPPS.practicaScrum.services.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
@Configuration
public class Configurador
{
    @Bean
    TareaService tareaService(final TareaRepository tareaRepository) {
        return new TareaServiceImpl(tareaRepository);
    }
    
    @Bean
    UsuarioService usuarioService(final UsuarioRepository usuarioRepository) {
        return new UsuarioServiceImpl(usuarioRepository);
    }
}
