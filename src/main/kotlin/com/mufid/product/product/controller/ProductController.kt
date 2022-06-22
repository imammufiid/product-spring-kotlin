package com.mufid.product.product.controller

import com.mufid.product.BaseResponse
import com.mufid.product.product.entity.Product
import com.mufid.product.product.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/product")
class ProductController {
    @Autowired
    private lateinit var productService: ProductService

    @GetMapping
    fun getProducts(): BaseResponse<List<Product>> {
        return BaseResponse(true, "data product", productService.getAll())
    }

    @GetMapping("/{id}")
    fun getProductById(
        @PathVariable(value = "id") id: String
    ): BaseResponse<Product> {
        return BaseResponse(true, "data product by id", productService.getById(id))
    }

    @PostMapping
    fun addProduct(
        @RequestBody kost: Product
    ): BaseResponse<List<Product>> {
        return BaseResponse(true, "add data product", productService.add(kost))
    }

    @GetMapping("/search")
    fun searchProduct(
        @RequestParam(value = "name") name: String
    ): BaseResponse<List<Product>> {
        return BaseResponse(true, "search data product", productService.search(name))
    }

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: String,
        @RequestBody kost: Product
    ): BaseResponse<Product> {
        return BaseResponse(true, "update data product", productService.update(id, kost))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(
        @PathVariable(value = "id") id: String
    ): BaseResponse<Product> {
        return BaseResponse(true, "delete data product", productService.delete(id))
    }
}