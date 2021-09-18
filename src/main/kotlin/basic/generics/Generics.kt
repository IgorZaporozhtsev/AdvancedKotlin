package basic.generics

open class Animal
data class Dog(val id: Int, val name: String, val furColor: FurColor): Animal()
data class Cat(val id: Int, val name: String, val eyesColor: EyesColor): Animal()
data class Car(val id: Int, val name: String, val color: String)
enum class FurColor { BLACK, PATCHED }
enum class EyesColor { GREEN }

class Cage1(var dog: Dog, val size: Double)
class Cage2<T>(var animal: T, val size: Double)


fun main() {

    //1 step
    // without generics
    val dog1 = Dog(id = 0, name = "Doglin", furColor = FurColor.BLACK)
    val cage = Cage1(dog = dog1, size = 6.0)

    //2 step
    // but if we want one Cage but set for different animal with different age
    // A new redefinition of Cage is necessary if classifying other species, i.e. cats.
    // You could use something like CatCage, for example. However, this looks rather native and not convenient, since it introduces code duplication.

    val dog2: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val cat2: Cat = Cat(id = 4, name = "Peter", eyesColor = EyesColor.GREEN)
    //same Cage but with different type in generic <>
    val cageDog: Cage2<Dog> = Cage2(animal = dog2, size = 6.0)
    val cageCat: Cage2<Cat> = Cage2(animal = cat2, size = 3.0)

    //3 step
    //if we use Cage<String> - String is no suitable type here we have to protect of it
    //val cageString: Cage<String> =
    //Cage(animal = "This cage hosts a String?", size = 0.1)

    //Cage only permits data types inheriting from Animal
    //A Cage can only contain what IS-A Animal
    class Cage<T : Animal>(var animal: T, val size: Double)

    var animal: Animal = Dog(id = 0, name = "Doglin", furColor = FurColor.BLACK)
    var dog3: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val car: Car = Car(id = 4, name = "Ford", color = "BLUE")
    animal = dog3
    //animal = car //type mismatch Car is not IS-Animal not extend Animal

    val cageDog2:Cage<Dog> = Cage(dog3, 12.0)
    //val cageCar:Cage<Car> = Cage(car, 1344.0) //it doesn't work Car is not Animal, not extend Animal


}

