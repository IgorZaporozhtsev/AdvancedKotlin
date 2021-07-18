package main.object_features

import java.util.*

fun main(){
    val easyEntity = EntityFactory3.create(EntityType3.EASY)
    val mediumEntity = EntityFactory3.create(EntityType3.MEDIUM)
    val hardEntity = EntityFactory3.create(EntityType3.HARD)
    println(easyEntity)
    println(mediumEntity)
    println(hardEntity)
}


object EntityFactory3{
    fun create(type: EntityType3) : Entity3{
        val id = UUID.randomUUID().toString()

        val name = when(type){
            EntityType3.EASY -> type.name //1st approach
            EntityType3.MEDIUM -> type.getFormattedName() //2nd approach
            EntityType3.HARD -> "Hard"      //3nd approach
        }

        return Entity3(id, name)
    }
}

class Entity3 (val id: String, val name:String){

    override fun toString(): String {
        return "id: $id name: $name"
    }
}

enum class EntityType3{
    EASY,
    MEDIUM,
    HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()

}
