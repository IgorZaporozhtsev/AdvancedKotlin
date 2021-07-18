package main.object_features

//object declaration
fun main(){
    val entity = EntityFactory2.create()
    println(entity)
}


object EntityFactory2{
    fun create() = Entity2("id", "name");
}

class Entity2 (val id: String, val name:String){

    override fun toString(): String {
        return "id: $id name: $name"
    }
}