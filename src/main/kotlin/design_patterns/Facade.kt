package design_patterns
/**
 * Фасад - название само за себя говорит.
 * в нашем случаи реализация скрыта за фосадом UserRepository
 * сама же реализация находиться в ComplexSystemStore
 *
 * в тесте FacadeTest мы обращаемся только к userRepository
 * UserRepository содержит ссылку на реализцию
 *
 * Что то подобное реализовано в Spring, мы не напрямую обращаемся к репозиторию сохранить Entity
 * а через Service
 *
 * Так же выгляит это как некая инкапсуляция
 *
 * */

class ComplexSystemStore(private val filePath: String) {

    private val cache: HashMap<String, String>

    init {
        print("Reading data from file: $filePath")
        cache = HashMap()
        //read properties from file and put to cache
    }

    fun store(key: String, payload: String) {
        cache[key] = payload
    }

    fun read(key: String): String = cache[key] ?: "" //if there is no key it won't throw NPE instead of this just set default value as empty " "

    fun commit() = println("Storing cached data: $cache to file: $filePath")
}

data class User(val login: String)

//Facade:
class UserRepository {

    private val systemPreferences = ComplexSystemStore("/data/default.prefs")

    fun save(user: User) {
        systemPreferences.store("USER_KEY", user.login)
        systemPreferences.commit()
    }

    fun findFirst(): User = User(systemPreferences.read("USER_KEY"))
}