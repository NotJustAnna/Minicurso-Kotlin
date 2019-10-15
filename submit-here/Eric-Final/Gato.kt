data class Gato(val nome: String, var estado: Estado, val sexo: Sexo, val nomeDono: String) {
    override fun toString(): String {
            return when(sexo) {
                Sexo.MACHO -> when(estado) {
                    Estado.DORMINDO -> "ROONC"
                    Estado.COMENDO -> "Crunch Crunch"
                    Estado.MOSCANDO -> "..."
                    Estado.OLHANDO -> "FSSSK"
                    Estado.MIANDO -> "Miaauu Miauuu..."
                    Estado.BRINCANDO -> "Crash"
                    Estado.ANDANDO -> "*andando*"
                    Estado.PARADO -> TODO()
                }
                Sexo.FEMEA -> when(estado) {
                    Estado.DORMINDO -> "Ronc"
                    Estado.COMENDO -> "Crunsh"
                    Estado.MOSCANDO -> "..."
                    Estado.OLHANDO -> "Nya"
                    Estado.MIANDO -> "Nya Nya"
                    Estado.BRINCANDO -> "FSSK"
                    Estado.ANDANDO -> "*andando*"
                    Estado.PARADO -> TODO()
                }
            }
    }
    enum class Sexo {
        MACHO, FEMEA
    }
    enum class Estado(val onomatopeia: String) {
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
    val thor = Gato(  "Thor", Gato.Estado.COMENDO, Gato.Sexo.MACHO, "oi")
    val lela = Gato(  "Lela", Gato.Estado.ANDANDO, Gato.Sexo.FEMEA, "oi")
    println("Meus Gatos")
    println(thor)
    println(lela)
}
