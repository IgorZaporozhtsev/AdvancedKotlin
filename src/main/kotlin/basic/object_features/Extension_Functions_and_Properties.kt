package main.object_features

import java.util.*


fun main(){
    //extension function
    Entity6.Medium("frt32tg3462t245245", "name").printInfo();

    //in case if we don't know direct type we can rely to smart casting
    val entity5 = EntityFactory6.create(EntityType6.MEDIUM)
    if (entity5 is Entity6.Medium) {
        entity5.printInfo()
        entity5.info
    }
}

//extension function/method
fun Entity6.Medium.printInfo(){
    println("Medium class id: $id")
}

//extension properties
val Entity6.Medium.info: String
    get() = "medium info"

object EntityFactory6{
    fun create(type: EntityType6) : Entity6{

        val id = UUID.randomUUID().toString()

        val name = when(type){
            EntityType6.EASY -> type.name //1st approach
            EntityType6.MEDIUM -> type.getFormattedName() //2nd approach
            EntityType6.HARD -> "Hard"      //3nd approach
            EntityType6.HELP -> type.getFormattedName()
        }

        return when(type){
            EntityType6.EASY -> Entity6.Easy(id, name)
            EntityType6.MEDIUM -> Entity6.Medium(id, name)
            EntityType6.HARD -> Entity6.Hard(id, name, 2f)
            EntityType6.HELP -> Entity6.Help
        }
    }
}

sealed class Entity6 (){

    object Help: Entity6() { val name = "Help" }

    data class Easy(val id:String, val name :String): Entity6()

    data class Medium(val id:String, val name :String): Entity6()

    data class Hard(val id:String, val name :String, val multiplier: Float): Entity6()
}

enum class EntityType6{
    HELP,
    EASY,
    MEDIUM,
    HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()

}
