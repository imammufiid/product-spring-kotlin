package com.mufid.product.product.repository

import com.mongodb.client.MongoCollection
import com.mufid.product.database.DatabaseComponent
import com.mufid.product.product.entity.Product
import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.lang.IllegalStateException

@Repository
class ProductRepositoryImpl : ProductRepository {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun productCollection(): MongoCollection<Product> =
        databaseComponent.database.getDatabase("product").getCollection()

    override fun getAll(): List<Product> {
        return productCollection().find().toList()
    }

    override fun getById(id: String?): Product? {
        return productCollection().findOneById(ObjectId(id))
    }

    override fun search(name: String): List<Product> {
        return productCollection().find(Product::name regex ".*$name.*").toList()
    }

    override fun add(product: Product): List<Product> {
        val insert = productCollection().insertOne(product)

        return if (insert.wasAcknowledged()) {
            getAll()
        } else {
            throw IllegalStateException("Failed Insert")
        }
    }

    override fun update(idString: String?, product: Product): Product? {
        val update = productCollection().updateOneById(ObjectId(idString), product)
        return if (update.wasAcknowledged()) {
            getById(idString)
        } else {
            throw IllegalStateException("Failed Update")
        }
    }

    override fun delete(id: String?): Product? {
        val delete = productCollection().deleteOneById(ObjectId(id))

        return if (delete.wasAcknowledged()) {
            return null
        } else {
            throw IllegalStateException("Failed Delete")
        }
    }
}