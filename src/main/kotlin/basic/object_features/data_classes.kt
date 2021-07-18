package main.object_features

import java.util.*


fun main(){
    val entity51 = Entity5.Easy("id", "name")
    val entity52 = Entity5.Easy("id", "name")

    if (entity51 == entity52){
        println("they are equal")
    } else {
        println("they are NOT equal")
    }
}


object EntityFactory5{
    fun create(type: EntityType5) : Entity5{
        val id = UUID.randomUUID().toString()

        val name = when(type){
            EntityType5.EASY -> type.name //1st approach
            EntityType5.MEDIUM -> type.getFormattedName() //2nd approach
            EntityType5.HARD -> "Hard"      //3nd approach
            EntityType5.HELP -> type.getFormattedName()
        }

        return when(type){
            EntityType5.EASY -> Entity5.Easy(id, name)
            EntityType5.MEDIUM -> Entity5.Medium(id, name)
            EntityType5.HARD -> Entity5.Hard(id, name, 2f)
            EntityType5.HELP -> Entity5.Help
        }
    }
}

sealed class Entity5 (){
    object Help: Entity5() { val name = "Help" }
    data class Easy(val id:String, val name :String): Entity5()
    data class Medium(val id:String, val name :String): Entity5()
    data class Hard(val id:String, val name :String, val multiplier: Float): Entity5()
}

enum class EntityType5{
    HELP,
    EASY,
    MEDIUM,
    HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()

}
