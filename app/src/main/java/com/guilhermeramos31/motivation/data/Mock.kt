package com.guilhermeramos31.motivation.data

import com.guilhermeramos31.motivation.infra.MotivationConstants
import java.io.FileDescriptor
import kotlin.random.Random

class Phrase(val description: String,val categoryID: Int)
class Mock {
    companion object{
        private val SUNNY = MotivationConstants.FILTER.SUNNY
        private val ALL = MotivationConstants.FILTER.ALL
        private val FACE = MotivationConstants.FILTER.FACE
        private val mListPhrase = listOf(
            Phrase("Não sabendo que era impossível, foi lá e fez.", FACE),
            Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", FACE),
            Phrase("Quando está mais escuro, vemos mais estrelas!", FACE),
            Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", FACE),
            Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", FACE),
            Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", FACE),
            Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUNNY),
            Phrase("Você perde todas as chances que você não aproveita.", SUNNY),
            Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUNNY),
            Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUNNY),
            Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUNNY),
            Phrase("Se você acredita, faz toda a diferença.", SUNNY),
            Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUNNY)
        )
        fun getPhrase(value: Int): String{
            val filtered = mListPhrase.filter { (it.categoryID == value || value == ALL) }
            val rand = Random.nextInt(filtered.size)

            return filtered[rand].description
        }
    }
}