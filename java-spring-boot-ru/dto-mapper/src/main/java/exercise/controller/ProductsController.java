package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

import exercise.repository.ProductRepository;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    /*
    Создайте в контроллере обработчики, которые будут обрабатывать следующие запросы:
        GET /products – вывод списка всех товаров
        GET /products/{id} – просмотр конкретного товара
        POST /products – создание нового товара
        PUT /products/{id} – редактирование товара
     */
    @Autowired
    private ProductMapper productMapper;

    @GetMapping(path = "")
    public List<ProductDTO> index() {
        return productRepository.findAll().stream()
                .map(product -> productMapper.show(product))
                .toList();
    }

    @GetMapping(path = "/{id}")
    public ProductDTO show(@PathVariable Long id) {
        var product =  productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found!"));
        return productMapper.show(product);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO productData) {
        var product = productMapper.create(productData);
        productRepository.save(product);
        return productMapper.show(product);
    }

    @PutMapping(path = "/{id}")
    public ProductDTO update(@RequestBody ProductUpdateDTO productData, @PathVariable Long id) {
        var product =  productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found!"));
        product = productMapper.update(productData, product);
        productRepository.save(product);
        return productMapper.show(product);
    }

    // END
}
