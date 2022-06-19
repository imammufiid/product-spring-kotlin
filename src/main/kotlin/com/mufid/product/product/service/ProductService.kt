package com.mufid.product.product.service

import com.mufid.product.product.entity.Product

interface ProductService {
    fun getAll(): List<Product>
    fun getById(id: String?): Product?
    fun search(name: String): List<Product>
    fun add(product: Product): List<Product>
    fun update(id: String?, product: Product): Product?
    fun delete(id: String?): Product?
}