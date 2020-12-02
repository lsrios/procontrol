package br.com.projuris.procontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projuris.procontrol.models.Category;
import br.com.projuris.procontrol.repositories.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
