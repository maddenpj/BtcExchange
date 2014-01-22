package com.yoloinvest.btcexchange

trait Order {
  val id: Int
  val size: Int
}

trait LimitOrder extends Order {
  val price: Double
}

case class BuyOrder(val id: Int, val size: Int, val price: Double) extends LimitOrder
case class SellOrder(val id: Int, val size: Int, val price: Double) extends LimitOrder

/*case class MarketOrder(val size: Int) extends Order*/

