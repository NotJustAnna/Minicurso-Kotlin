import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.plugin.json.JavalinJackson

fun main() {
    val mapper = jacksonObjectMapper()
    val thor = Gato(  "Thor", Gato.Estado.COMENDO, Gato.Sexo.MACHO, "oi")
    val lela = Gato(  "Lela", Gato.Estado.ANDANDO, Gato.Sexo.FEMEA, "oi")

    val app = Javalin.create()
    app.routes {
        get{ctx ->
            ctx.result( "Hello, World")
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
    }
    app.start(9000)
}
