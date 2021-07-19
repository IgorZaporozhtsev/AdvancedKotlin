package basic.nullability

class Car(val color: String? = null) {

    fun drive(){
        print("drive")
    }
}


fun main(){
    val car: Car? = null
    car?.drive() //if we run with ? we don;t get NPE just nothing
    car?.color
}