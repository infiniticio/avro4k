@file:UseSerializers(UUIDSerializer::class)

package com.sksamuel.avro4k.schema

import com.sksamuel.avro4k.Avro
import com.sksamuel.avro4k.serializer.UUIDSerializer
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.util.UUID

class UUIDSchemaTest : FunSpec({

   test("support UUID logical types") {

      @Serializable
      data class UUIDTest(val uuid: UUID)

      val expected = org.apache.avro.Schema.Parser().parse(javaClass.getResourceAsStream("/uuid.json"))
      val schema = Avro.default.schema(UUIDTest.serializer())
      schema.toString(true) shouldBe expected.toString(true)
   }

})