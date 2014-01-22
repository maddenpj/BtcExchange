package com.yoloinvest.btcexchange

/*trait Exchange {*/
/*  def placeOrder(order: A): Int*/
/*}*/

class SimExchange {
  var currentId = 0;
  val orderBook = new OrderBook

  def placeOrder(orderRequest: BuyOrderRequest): Int = {
    val order = BuyOrder(_getId, orderRequest.size, orderRequest.price)
    orderBook.placeOrder(order)
    order.id
  }

  def placeOrder(orderRequest: SellOrderRequest): Int = {
    val order = SellOrder(_getId, orderRequest.size, orderRequest.price)
    orderBook.placeOrder(order)
    order.id
  }

  def _getId(): Int = {
    val tmp = currentId
    currentId += 1
    tmp
  }


  def showBook(): String =
    orderBook.toString
}
