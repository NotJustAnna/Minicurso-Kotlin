data class Gato(val nome: String, val sexo: Sexo, val nomeDono: String, val estado: Estados) {
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
}

fun main() {
    val thor = Gato("Thor", Gato.Sexo.MACHO, "Beatriz", Gato.Estados.DORMINDO)
    val lela = Gato("Lela", Gato.Sexo.FEMEA, "Beatriz", Gato.Estados.OLHANDO)

    println("Meus gatos:")
    thor.falar()
    lela.falar()
}
