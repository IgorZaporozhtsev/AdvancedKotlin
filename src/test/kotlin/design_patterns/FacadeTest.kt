package design_patterns

import org.junit.jupiter.api.Test

class FacadeTest {

    @Test
    fun Facade() {
        val userRepository = UserRepository()
        val user = User("Dwayne Johnson")
        userRepository.save(user)
        val resultUser = userRepository.findFirst()
        println("Found stored user: $resultUser")
    }
}