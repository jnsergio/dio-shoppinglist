package com.example.shoppinglist

import android.os.Parcel
import android.os.Parcelable

class Product(val title: String?, val imageName: String?, val description: String?, val price: Double)
: Parcelable {
    private var _numberOrder: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(imageName)
        parcel.writeString(description)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun setNumberInCart(numberOrder: Int) {
       _numberOrder = numberOrder;
    }

    fun getNumberInCart(): Int {
        return _numberOrder;
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
