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
class ProductTest {
    @get:Rule
    var mainActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun quandoAbrirOAppDeveCarregarUmaListaComTituloCategorias(){
        Espresso.onView(ViewMatchers.withId(R.id.product_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.product_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Pizzas")))
    }

    @Test
    fun quandoAbrirOAppDeveExibirTresPizzasNaTelaAoAbrir(){
        Espresso.onView(ViewMatchers.withText("Pepperoni"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Mussarela"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Calabresa"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun quandoAbrirOAppNaoDeveExibirPizzaPortuguesaEVegana(){
        Espresso.onView(ViewMatchers.withText("Portuguesa")).check(ViewAssertions.doesNotExist())
        Espresso.onView(ViewMatchers.withText("Vegana")).check(ViewAssertions.doesNotExist())
    }

    @Test
    fun quandoArrastarAListaDePizzaParaOLadoDeveAparecerAPortuguesa(){
        Espresso.onView(ViewMatchers.withId(R.id.products_view))
            .perform(RecyclerViewActions.scrollToPosition<ProductAdapter.ViewHolder>(3))

        Espresso.onView(ViewMatchers.withText("Portuguesa"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun quandoArrastarAListaDePizzaParaOLadoDeveAparecerAVegana(){
        Espresso.onView(ViewMatchers.withId(R.id.products_view))
            .perform(RecyclerViewActions.scrollToPosition<ProductAdapter.ViewHolder>(4))

        Espresso.onView(ViewMatchers.withText("Vegana"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun quandoArrastarEClicarNaPizzaVeganaDeveMostrarOsSeusDetalhes(){
        Espresso.onView(ViewMatchers.withId(R.id.products_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ProductAdapter.ViewHolder>(
                    4,
                    ViewActions.click()
                )
            )

        Espresso.onView(ViewMatchers.withId(R.id.product_detail_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_price))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_quantity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_increase_quantity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_decrease_quantity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.product_detail_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Vegana")))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_price))
            .check(ViewAssertions.matches(ViewMatchers.withText("R$58.55")))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_description))
            .check(ViewAssertions.matches(ViewMatchers.withText("olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil")))
        Espresso.onView(ViewMatchers.withId(R.id.product_detail_quantity))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }
}