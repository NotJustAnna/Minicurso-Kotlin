import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.plugin.json.JavalinJackson

fun main() {
    val mapper = jacksonObjectMapper()

    val thor = Gato("Thor", Gato.Sexo.MACHO, "Beatriz", Gato.Estados.DORMINDO)
    val lela = Gato("Lela", Gato.Sexo.FEMEA, "Beatriz", Gato.Estados.OLHANDO)

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
    }

    app.start(9000)
}
