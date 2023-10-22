data class Cursos(val nome: String, val nivel: Nivel) {
    val usuarios = mutableListOf<Usuario>()
}

data class Usuario(val nome: String) {
    val CursosIncritos = mutableListOf<Cursos>()
    fun matricular(Cursos: Cursos) {
        CursosIncritos.add(Cursos)
        Cursos.usuarios.add(this)
    }
}

enum class Nivel { Basico, Intermediario, Avaçado }

fun main() {
    val usuario1 = Usuario("Caroline")
    val usuario2 = Usuario("Fabio")
    val usuario3 = Usuario("Miguel")
    val CursosGit = Cursos("Conhecimentos Git", Nivel.Basico)
    val CursosCSharp = Cursos("Programação C#", Nivel.Intermediario)
    val CursosJava = Cursos("Programação Java", Nivel.Avaçado)

    usuario1.matricular(CursosGit)
    usuario2.matricular(CursosCSharp)
    usuario3.matricular(CursosJava)

    for (usuario in listOf(usuario1, usuario2, usuario3)) {
        println("Nome: ${usuario.nome}")
        println("Cursos Inscritos:")
    	for (Cursos in usuario.CursosIncritos) {
            println("${Cursos.nome}, Nível: ${Cursos.nivel}")
            println()
        }
    }
}

