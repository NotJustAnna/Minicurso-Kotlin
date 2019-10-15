import java.time.LocalDate
import java.time.Period

data class Gato(val nome: String, val sexo: Sexo, val nomeDono: String, var estado: Estados, val dataNasc: LocalDate) {
    fun falar() {
        println(this)
        estadoAtual()
    }

    override fun toString(): String {
        return "$nome, sou ${sexo.descricao}"
    }

    fun estadoAtual() {
        println("[$nome]: ${estado.onomatopeia}")
    }

    enum class Sexo(val descricao: String) {
        MACHO("um gato"), FEMEA("uma gata")
    }

    enum class Estados(val onomatopeia: String) {
        DORMINDO("ZZzzZZ"),
        COMENDO("NhomNhomNhom"),
        ANDANDO("*tap* *tap* *tap*"),
        BRINCANDO("*purr*"),
        PARADO("/existindo/"),
        OLHANDO("/vendo espíritos pela casa/"),
        MOSCANDO("BzzBzz"),
        MIANDO("Meooow!")
    }
    val idade: Int
        get() {
            return Period.between(dataNasc, LocalDate.now()).years
        }
}

fun main() {
    val thor = Gato("Thor", Gato.Sexo.MACHO, "Beatriz", Gato.Estados.DORMINDO, LocalDate.of(2016, 7, 12))
    val lela = Gato("Lela", Gato.Sexo.FEMEA, "Beatriz", Gato.Estados.OLHANDO, LocalDate.of(2016, 7, 12))

    println("Meus gatos:")
    thor.falar()
    lela.falar()
}
