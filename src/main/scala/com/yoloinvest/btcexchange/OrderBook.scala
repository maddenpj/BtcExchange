package com.yoloinvest.btcexchange


class OrderBook {
  var bids = scala.collection.mutable.Map[Double, List[BuyOrder]]()
  var offers = scala.collection.mutable.Map[Double, List[SellOrder]]()

  def placeOrder(order: BuyOrder) {
    if(!bids.contains(order.price)) {
      bids(order.price) = List[BuyOrder]()
    }
    bids(order.price) = bids(order.price) ++ List(order)
  }

  def placeOrder(order: SellOrder) {
    if(!offers.contains(order.price)) {
      offers(order.price) = List[SellOrder]()
    }
    offers(order.price) = offers(order.price) ++ List(order)
  }

  def aggregateBook(book: scala.collection.mutable.Map[Double, _ <: List[_ <: Order]]): List[Tuple2[Double, Int]] =
    book.toList.sortBy(_._1).reverse.map { case (price, orders) =>
      (price, orders.map(_.size).sum)
    }

  override def toString(): String = {
    val aggregatedBids = aggregateBook(bids)
    val aggregatedOffers = aggregateBook(offers)
    var out = "Offers\n"

    aggregatedOffers.foreach { case (price, size) =>
      out += price + "\t" + size + "\n"
    }
    out += "\nBids\n"
    aggregatedBids.foreach { case (price, size) =>
      out += price + "\t" + size + "\n"
    }
    out
  }
}


