package com.example.shoppinglist

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductDetailTest {
    @get:Rule
    var mainActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun quandoClicarParaAumentarAQuantidadeDoProdutoDeveSomarUmAoNumeroAtual(){
        Espresso.onView(ViewMatchers.withId(R.id.products_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ProductAdapter.ViewHolder>(
                4,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_quantity))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))

        Espresso.onView(ViewMatchers.withId(R.id.product_detail_increase_quantity))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_quantity))
            .check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }

    @Test
    fun quandoClicarParaDiminuirAQuantidadeDoProdutoDeveSubtrairUmAoNumeroAtual(){
        Espresso.onView(ViewMatchers.withId(R.id.products_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ProductAdapter.ViewHolder>(
                4,
                ViewActions.click()
            )
        )

        Espresso.onView(ViewMatchers.withId(R.id.product_detail_increase_quantity))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_quantity))
            .check(ViewAssertions.matches(ViewMatchers.withText("2")))

        Espresso.onView(ViewMatchers.withId(R.id.product_detail_decrease_quantity))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_quantity))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }
}