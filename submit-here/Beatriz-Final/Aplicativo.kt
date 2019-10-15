import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.plugin.json.JavalinJackson
import java.time.LocalDate

fun main() {
    val mapper = jacksonObjectMapper()

    val thor = Gato("Thor", Gato.Sexo.MACHO, "Beatriz", Gato.Estados.DORMINDO, LocalDate.of(2016, 7, 12))
    val lela = Gato("Lela", Gato.Sexo.FEMEA, "Beatriz", Gato.Estados.OLHANDO, LocalDate.of(2016, 7, 12))

    val gatos = mapOf(
        "thor" to thor,
        "lela" to lela
    )

    val app = Javalin.create()
    app.routes {
        get { ctx ->
            val json = mapper.writeValueAsString(
                listOf(thor, lela)
            )
            ctx.contentType("application/json")
            ctx.result(json)
        }
        get("thor") { ctx ->
            val jsonThor = mapper.writeValueAsString(thor)
            ctx.contentType("application/json")
            ctx.result(jsonThor)
        }
        get("lela") { ctx ->
            val jsonLela = mapper.writeValueAsString(lela)
            ctx.contentType("application/json")
            ctx.result(jsonLela)
        }

        get("estado") { ctx ->
            val nome = ctx.queryParam("nome")
            val valor = ctx.queryParam("valor")
            val gato = gatos[nome]
            val estados = Gato.Estados.values().firstOrNull { it.name.equals(valor, true) }
            if (gato != null && estados != null) {
                gato.estado = estados
            }
            ctx.result((estados ?: gato?.estado)?.onomatopeia ?: "Não encontrado")

        }
    }

    app.start(9000)
}
