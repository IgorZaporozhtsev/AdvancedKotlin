package main.object_features

import java.util.*


fun main(){
    val entity4:Entity4 = EntityFactory4.create(EntityType4.EASY)
    val msg = when(entity4){
        Entity4.Help -> "Help class"
        is Entity4.Easy -> "Easy class"
        is Entity4.Medium -> "Medium class"
        is Entity4.Hard -> "Hard class"
    }

    println(msg)
}


object EntityFactory4{
    fun create(type: EntityType4) : Entity4{
        val id = UUID.randomUUID().toString()

        val name = when(type){
            EntityType4.EASY -> type.name //1st approach
            EntityType4.MEDIUM -> type.getFormattedName() //2nd approach
            EntityType4.HARD -> "Hard"      //3nd approach
            EntityType4.HELP -> type.getFormattedName()
        }

        return when(type){
            EntityType4.EASY -> Entity4.Easy(id, name)
            EntityType4.MEDIUM -> Entity4.Medium(id, name)
            EntityType4.HARD -> Entity4.Hard(id, name, 2f)
            EntityType4.HELP -> Entity4.Help
        }
    }
}

sealed class Entity4 (){
    object Help: Entity4() { val name = "Help" }
    data class Easy(val id:String, val name :String): Entity4()
    data class Medium(val id:String, val name :String): Entity4()
    data class Hard(val id:String, val name :String, val multiplier: Float): Entity4()
}

enum class EntityType4{
    HELP,
    EASY,
    MEDIUM,
    HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()

}
