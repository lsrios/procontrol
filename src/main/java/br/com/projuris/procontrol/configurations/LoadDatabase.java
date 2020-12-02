package br.com.projuris.procontrol.configurations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.projuris.procontrol.models.Brand;
import br.com.projuris.procontrol.models.Category;
import br.com.projuris.procontrol.models.Client;
import br.com.projuris.procontrol.repositories.BrandRepository;
import br.com.projuris.procontrol.repositories.CategoryRepository;
import br.com.projuris.procontrol.repositories.ClientRepository;

@Configuration
public class LoadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
        ClientRepository clientRepository, 
        BrandRepository brandRepository,
        CategoryRepository categoryRepository) {

        return args -> {
            logger.info("Populating tables");

            var clients = List.of(
                new Client("Ana", "Brasília - DF", "(61) 1111-1111", "email@gmail.com"),
                new Client("Bruno", "Rio de Janeiro - RJ", "(61) 1111-1111", "email@gmail.com"),
                new Client("Carla", "São Paulo - SP", "(61) 1111-1111", "email@gmail.com"),
                new Client("Daniel", "Joinville - SC", "(61) 1111-1111", "email@gmail.com"),
                new Client("Estefani", "Londrina - PR", "(61) 1111-1111", "email@gmail.com")
            );

            clientRepository.saveAll(clients);

            var brands = List.of(
                new Brand("Arno"),
                new Brand("Philco")
            );

            brands = brandRepository.saveAll(brands);

            var categories = List.of(
                new Category("Ventilador", brands.get(0)),
                new Category("Cafeteira", brands.get(1))
            );

            categoryRepository.saveAll(categories);
        };
    }
}