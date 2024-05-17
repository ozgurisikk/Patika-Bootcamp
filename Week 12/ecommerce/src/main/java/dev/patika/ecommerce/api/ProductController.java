package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.CategoryService;
import dev.patika.ecommerce.business.abstracts.ProductService;
import dev.patika.ecommerce.business.abstracts.SupplierService;
import dev.patika.ecommerce.core.config.modelMapper.ModelMapperService;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilities.ResultHelper;
import dev.patika.ecommerce.dto.request.category.CategorySaveRequest;
import dev.patika.ecommerce.dto.request.product.ProductSaveRequest;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.dto.response.category.CategoryResponse;
import dev.patika.ecommerce.dto.response.product.ProductResponse;
import dev.patika.ecommerce.dto.response.supplier.SupplierResponse;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Product;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapperService modelMapperService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    public ProductController(ProductService productService, ModelMapperService modelMapperService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.modelMapperService = modelMapperService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest ){ // burda valid category anatasyonlarini uyandirip gecerli bir obje mi diye kontrol ediyor
        Product saveProduct = this.modelMapperService.forRequest().map(productSaveRequest, Product.class);
        Category category = this.categoryService.get(productSaveRequest.getCategoryId());
        saveProduct.setCategory(category);

        Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());
        saveProduct.setSupplier(supplier);
        this.productService.save(saveProduct);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveProduct, ProductResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> get(@PathVariable("id")long id){
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(product, ProductResponse.class));
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<ProductResponse>> cursor(
            @RequestParam(name = "page", required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<Product> productPage = this.productService.cursor(page,pageSize);
        Page<ProductResponse> productResponsePage = productPage.
                map(product -> this.modelMapperService.forResponse().map(product, ProductResponse.class));

        return ResultHelper.cursor(productResponsePage);
    }

    @GetMapping("/{id}/supplier")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> getSupplier(@PathVariable("id")long id){
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(product.getSupplier(), SupplierResponse.class));
    }

}
