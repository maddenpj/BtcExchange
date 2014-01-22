package com.yoloinvest.btcexchange

object App {
  def main(args: Array[String]) {
    println("Hello World")
    val ob = new SimExchange

    ob.placeOrder(BuyOrderRequest(100, 10.10))
    ob.placeOrder(BuyOrderRequest(50, 10.00))
    ob.placeOrder(BuyOrderRequest(150, 10.10))
    ob.placeOrder(SellOrderRequest(200, 10.30))
    ob.placeOrder(SellOrderRequest(100, 10.40))
    ob.placeOrder(SellOrderRequest(10, 10.50))

    println(ob.showBook)
  }
}
