package com.example.shoppinglist

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoriesTest {

    @get:Rule
    var mainActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun quandoAbrirOAppDeveCarregarUmaListaComTituloCategorias(){
        Espresso.onView(ViewMatchers.withId(R.id.categories_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.categories_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Categorias")))
    }

    @Test
    fun quandoAbrirOAppDeveCarregarAListaDeCategorias() {
        Espresso.onView(ViewMatchers.withText("Pizza"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Lanches"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Hotdog"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Bebidas"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Doces"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun quandoListarAsCategoriasDeveSerPossivelArrastarParaVerOFimDaLista(){
        Espresso.onView(ViewMatchers.withId(R.id.categories_view))
            .perform(RecyclerViewActions.scrollToPosition<CategoryAdapter.ViewHolder>(4))
    }
}