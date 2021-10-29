package com.example.shoppinglist

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserInformationTest {

    @get:Rule
    var mainActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun quandoAbrirDeveMostrarSaudacaoParaOUsuario() {
        Espresso.onView(ViewMatchers.withId(R.id.greeting))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.greeting))
            .check(ViewAssertions.matches(ViewMatchers.withText("Olá, Jefferson")))
    }

    @Test
    fun quandoAbrirDeveMostrarFotoDoUsuario() {
        Espresso.onView(ViewMatchers.withId(R.id.user_avatar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun quandoAbrirTituloDaPagina() {
        Espresso.onView(ViewMatchers.withId(R.id.page_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.page_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Lista de compras")))
    }

}