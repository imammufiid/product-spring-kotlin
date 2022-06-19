package com.mufid.product.product.repository

import com.mufid.product.product.entity.Product

interface ProductRepository {
    fun getAll(): List<Product>
    fun getById(id: String?): Product?
    fun search(name: String): List<Product>
    fun add(product: Product): List<Product>
    fun update(idString: String?, product: Product): Product?
    fun delete(id: String?): Product?
}