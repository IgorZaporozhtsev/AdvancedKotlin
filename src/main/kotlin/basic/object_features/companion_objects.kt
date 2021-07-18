package main.object_features

fun main(){
    val entity = Entity1.create()
    Entity1.id
}

interface IdProvider{
    fun getId(): String
}

class Entity1 private constructor(val id: String){

    companion object Factory: IdProvider{

        override fun getId(): String {
            return "123"
        }

        const val id = "id"
        fun create() = Entity1(getId());
    }
}