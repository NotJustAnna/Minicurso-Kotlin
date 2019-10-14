class Gato(val nome: String, val estado: Estado, val sexo: Sexo, val nomeDono: String) {
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
                }
                Sexo.FEMEA -> when(estado) {
                    Estado.DORMINDO -> "Ronc"
                    Estado.COMENDO -> "Crunsh"
                    Estado.MOSCANDO -> "..."
                    Estado.OLHANDO -> "Nya"
                    Estado.MIANDO -> "Nya Nya"
                    Estado.BRINCANDO -> "FSSK"
                    Estado.ANDANDO -> "*andando*"
                }
            }
    }
    enum class Sexo {
        MACHO, FEMEA
    }
    enum class Estado {
        DORMINDO, COMENDO, MOSCANDO, OLHANDO , MIANDO, BRINCANDO, ANDANDO
    }
}
fun main() {
    val thor = Gato(  "Thor", Gato.Estado.COMENDO, Gato.Sexo.MACHO, "oi")
    val lela = Gato(  "Lela", Gato.Estado.ANDANDO, Gato.Sexo.FEMEA, "oi")
    println("Meus Gatos")
    println(thor)
    println(lela)
}
