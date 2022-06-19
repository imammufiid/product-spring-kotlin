package com.mufid.product.product.service

import com.mufid.product.product.entity.Product
import com.mufid.product.product.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl: ProductService {
    @Autowired
    private lateinit var productRepository: ProductRepository

    override fun getAll(): List<Product> {
        return productRepository.getAll()
    }

    override fun getById(id: String?): Product? {
        return productRepository.getById(id)
    }

    override fun search(name: String): List<Product> {
        return productRepository.search(name)
    }

    override fun add(product: Product): List<Product> {
        return productRepository.add(product)
    }

    override fun update(id: String?, product: Product): Product? {
        return productRepository.update(id, product)
    }

    override fun delete(id: String?): Product? {
        return productRepository.delete(id)
    }
}