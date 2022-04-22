package jd.sistemas.android.desviopadrao

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculaEstatisticasTest {

    private lateinit var calcula: Calcula

    @Before
    fun setUp() {
        calcula = Calcula()
    }

    @Test
    fun calculaMedia() {
        val media = calcula.calculaMedia(listOf(1.0, 2.0, 3.0))
        assertEquals(2.0, media, 0.0)
    }

    @Test
    fun calculaVariancia() {
        val ativos = listOf(1.0, 2.0, 3.0, 4.0)
        val variancia = calcula.calculaVariancia(ativos)
        assertEquals(1.04, variancia, 0.6)
    }

    @Test
    fun calculaDesvioPadrao() {
        val ativos = listOf(1.0, 2.0, 3.0, 4.0)
        val dp = calcula.calculaDesvioPadrao(ativos)
        assertEquals(1.019, dp, 0.6)
    }
}