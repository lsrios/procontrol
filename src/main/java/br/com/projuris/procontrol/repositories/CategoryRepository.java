package br.com.projuris.procontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projuris.procontrol.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
