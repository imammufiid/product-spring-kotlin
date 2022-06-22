package com.mufid.product.product.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId

data class Product(
    @BsonId
    var _id: Id<Product> = newId(),
    var name: String,
    var quantity: String,
    var price: Int
)
