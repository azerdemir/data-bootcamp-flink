package com.trendyol.bootcamp

package object flink {

  sealed trait EventType
  case object AddToFavorites      extends EventType
  case object RemoveFromFavorites extends EventType
  case object AddToBasket         extends EventType
  case object RemoveFromBasket    extends EventType
  case object GoToBasket          extends EventType
  case object CompletePurchase    extends EventType

  val eventTypes =
    List(AddToFavorites, RemoveFromFavorites, AddToBasket, RemoveFromBasket, GoToBasket, CompletePurchase)

  case class Event(productId: Int, userId: Int, eventType: EventType, timestamp: Long) {

    def toEnhanced: EnhancedEvent =
      EnhancedEvent(s"Product #{$productId}", s"User #{$userId}", eventType, timestamp)

  }

  case class EnhancedEvent(productName: String, userFullName: String, eventType: EventType, timestamp: Long)

  case class UserStats(userId: Int, eventCount: Int, windowStart: Long, windowEnd: Long)

}
