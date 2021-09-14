package basic.generics

data class Dog(val id: Int, val name: String, val furColor: FurColor)
data class Cat(val id: Int, val name: String, val eyesColor: EyesColor)
enum class FurColor { BLACK, PATCHED }
enum class EyesColor { GREEN }

class Cage1(var dog: Dog, val size: Double)
class Cage2<T>(var animal: T, val size: Double)


fun main() {

    //1 without generics
    val dog1 = Dog(id = 0, name = "Doglin", furColor = FurColor.BLACK)
    val cage = Cage1(dog = dog1, size = 6.0)

    //2 but if we want one Cage but set for different animal with different age
    // A new redefinition of Cage is necessary if classifying other species, i.e. cats.
    // You could use something like CatCage, for example. However, this looks rather native and not convenient, since it introduces code duplication.

    val dog2: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val cat: Cat = Cat(id = 4, name = "Peter", eyesColor = EyesColor.GREEN)
    //same Cage but with different type in generic <>
    val cageDog: Cage2<Dog> = Cage2(animal = dog2, size = 6.0)
    val cageCat: Cage2<Cat> = Cage2(animal = cat, size = 3.0)
}