package com.sksamuel.avro4k

import kotlinx.serialization.SerialDescriptor

class AnnotationExtractor(private val annotations: List<Annotation>) {

  companion object {
    fun entity(descriptor: SerialDescriptor) = AnnotationExtractor(descriptor.getEntityAnnotations())
  }

  fun namespace(): String? = annotations.filterIsInstance<AvroNamespace>().firstOrNull()?.name
  fun name(): String? = annotations.filterIsInstance<AvroName>().firstOrNull()?.name
}
