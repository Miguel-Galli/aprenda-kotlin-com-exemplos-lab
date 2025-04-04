// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {

        if (!inscritos.contains(usuario)){
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome")
        }

    }

    //Função para calcular o total da carga horaria
    fun cargaHorariaTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }
}

fun main() {

    //Criação de usuários
    val usuario1 = Usuario("Alice", "alice@email.com")
    val usuario2 = Usuario("Bob", "bob@email.com")

    //Criação do conteúdos educaionais
    val conteudo1 = ConteudoEducacional("Introdução ao kotlin", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android Avançado", 180, Nivel.AVANCADO)

    // Criação de Formação
    val formacaoKotlin =  Formacao("Desenvolvimento Kotlin", listOf(conteudo1, conteudo2, conteudo3))

    // Matriculando os usuarios nas formações
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1) // Tentativa de matricula duplicada

    println("Carga horária total de formação ${formacaoKotlin.nome}: ${formacaoKotlin.cargaHorariaTotal()} minutos")
}