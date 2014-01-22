package com.yoloinvest.btcexchange

trait OrderRequest {
  val size: Int
}

trait LimitOrderRequest extends OrderRequest {
  val price: Double
}

case class BuyOrderRequest(val size: Int, val price: Double) extends LimitOrderRequest
case class SellOrderRequest(val size: Int, val price: Double) extends LimitOrderRequest

