package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.CategoryMapper;
import exercise.mapper.ProductMapper;
import exercise.model.Product;
import exercise.repository.CategoryRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping()
    public List<ProductDTO> index() {
        var products = productRepository.findAll();
        var result = products.stream()
                .map(productMapper::map)
                .toList();

        return result;
    }

    @GetMapping("/{id}")
    public ProductDTO show(@PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID + " + id + "not exist"));
        var dto = productMapper.map(product);
        return dto;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody @Valid ProductCreateDTO data) {
        categoryRepository.findById(data.getCategoryId())
                .orElseThrow(() -> new ConstraintViolationException(" ", null));
        var product = productMapper.map(data);
        productRepository.save(product);
        var dto = productMapper.map(product);
        return dto;
    }

    @PutMapping("/{id}")
    public ProductDTO update(@RequestBody @Valid ProductUpdateDTO data, @PathVariable Long id) {
        categoryRepository.findById(data.getCategoryId().get())
                .orElseThrow(() -> new ConstraintViolationException(" ", null));
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID + " + id + "not exist"));
        productMapper.update(data, product);
        productRepository.save(product);
        var dto = productMapper.map(product);;
        return dto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    // END
}


//* *PUT /products/{id}* – редактирование товара. При редактировании мы должны иметь возможность поменять название, цену и категорию товара. При указании *id* несуществующей категории также должен вернуться ответ с кодом *400 Bad request*
//* *DELETE /products/{id}* – удаление товара