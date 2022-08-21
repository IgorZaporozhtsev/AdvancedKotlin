package examples


fun main() {
    val matchProcessor = MatchProcessorRank("1234", listOf(Triple(34, 43, listOf("dasd"))))
    val bestMatch = TariffBestMatchRank(12312, Pair(4,35))

    //add TariffBestMatch
    val bestRepo =  BestRepo()
    val service1 = RankCacheService(bestRepo)
    service1.add(bestMatch)

    //add Match processor
    val processorRepo = ProcessorRepo()
    val service2 = RankCacheService(processorRepo)
    service2.add(matchProcessor)

}

class RankCacheService(private val repository: RankRepoInterface){
    fun add(rank: RankInterface?): RankInterface? {
       return rank?.let { repository.save(it) }
    }

}

interface RankRepoInterface{
    fun save(rank: RankInterface): RankInterface?
}

interface RankInterface

class ProcessorRepo: RankRepoInterface {
    val map = mutableMapOf<String, RankInterface>()
    override fun save(rank: RankInterface): RankInterface? {
        return map.put("", rank)
    }
}

class BestRepo: RankRepoInterface{
   val map = mutableMapOf<String, RankInterface>()

    override fun save(rank: RankInterface): RankInterface? {
        return map.put("", rank)
    }

}

 class MatchProcessorRank (
    val id: String,
    val triples: List<Triple<Int, Int, List<String>>>
): RankInterface


 class TariffBestMatchRank(
    val id: Int,
    val pair: Pair<Int, Int>
): RankInterface

// TODO 1. через абстрактный класс
// TODO 2. interface имеет метод add