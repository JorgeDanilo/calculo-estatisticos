package jd.sistemas.android.desviopadrao

import kotlin.math.pow
import kotlin.math.sqrt

class Calcula {

    fun calculaMedia(ativo: List<Double>): Double {
        return ativo.average()
    }

    fun calculaVariancia(ativo: List<Double>): Double {
        val media = this.calculaMedia(ativo)
        val desvio = mutableListOf<Double>()
        val desvioPow = mutableListOf<Double>()
        calculaDesvio(ativo, media, desvio)
        calculaRaizDesvio(desvio, desvioPow)
        return desvioPow.sum().div(ativo.size)
    }

    private fun calculaRaizDesvio(
        desvio: MutableList<Double>,
        desvioPow: MutableList<Double>
    ) {
        desvio.forEach { diff ->
            desvioPow.add(diff.pow(diff))
        }
    }

    private fun calculaDesvio(
        ativo: List<Double>,
        media: Double,
        desvio: MutableList<Double>
    ) {
        ativo.forEach { valorAtivo ->
            if (valorAtivo >= media)
                desvio.add(valorAtivo.minus(media))
            else
                desvio.add(media.minus(valorAtivo))
        }
    }

    fun calculaDesvioPadrao(ativo: List<Double>): Double {
        return sqrt(calculaVariancia(ativo))
    }

}