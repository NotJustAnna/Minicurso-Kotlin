import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.plugin.json.JavalinJackson

fun main() {
    val mapper = jacksonObjectMapper()
    val thor = Gato(  "Thor", Gato.Estado.COMENDO, Gato.Sexo.MACHO, "oi")
    val lela = Gato(  "Lela", Gato.Estado.ANDANDO, Gato.Sexo.FEMEA, "oi")
    val gatos = mapOf(
        "thor" to thor,
        "lela" to lela
    )

    val app = Javalin.create()
    app.routes {
        get{ctx ->
            val json = mapper.writeValueAsString(
            listOf(thor, lela)
        )
            ctx.contentType("application/json")
            ctx.result(json)
        }
        get("thor") {ctx ->
            val jsonThor = mapper.writeValueAsString(thor)
            ctx.contentType("application/json")
            ctx.result(jsonThor)
        }
        get("lela") {ctx ->
            val jsonLela = mapper.writeValueAsString(lela)
            ctx.contentType("application/json")
            ctx.result(jsonLela)
        }
        get("estado") { ctx ->
            val nome = ctx.queryParam("nome")
            val valor = ctx.queryParam("valor")
            val gato = gatos[nome]
            val estado = Gato.Estado.values().firstOrNull { it.name.equals(valor, true) }
            if (gato != null && estado != null) {
                gato.estado = estado
            }
            ctx.result((estado ?:gato?.estado)?. onomatopeia ?: "Gato não encontrado")
        }
    }
    app.start(9000)
}
