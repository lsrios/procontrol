package br.com.projuris.procontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projuris.procontrol.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    
}
