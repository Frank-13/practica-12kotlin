data class Tarea(val nombre: String, val prioridad: int)

class NodoArbol(val tarea: Tarea){
    var izquierda: NodoArbol? = null
    var derecha: NodoArbol? = null
}

class ArbolTarea{
    private var raiz: NodoArbol? = null
    fun insertar(tarea: Tarea){
        raiz = insertarRecursivo(raiz, tarea)
    }

    private fun insertarRecursivo(actual: NodoArbol?, tarea: Tarea): NodoArbol{
        if(actual==null){
        return NodoArbol(tarea)
        }
        if (tarea.prioridad <actual.tarea.prioridad){
            actual.izquierda = insertarRecursivo(actual.izquierda, tarea)
        }else{
            actual.derecha = insertarRecursivo(actual.derecha, tarea)
        }
        return actual
    }
    fun mostrarEnOrden(){

    }

    private fun mostrarEnOrdenRecursivo(nodo: NodoArbol?){
        if(nodo != null){
            mostrarEnOrdenRecursivo(nodo.izquierda)
            println("tarea: ${nodo.tarea.nombre}, prioridad: ${nodo.tarea.prioridad}")
            mostrarEnOrdenRecursivo(nodo.derecha)
        }
    }
}

//getion de tareas
class customList<T> {
    private val elements = mutablelistOf<T>()

    fun add(element: T): Bolean {
        return if (element | in elements) {
            elements.add(element)
            println("Tarea agregada exitosamente")
            true
        }else {
            println("La tarea ya existe")
            false
        }
    }

    fun remove(element: T): Boolean{
        return if (element in elements){
            elements.remove(element)
            println("Tarea eliminada!")
            true
        }else {
            println("La tarea no se encontro en la lista")
            false
        }
    }
    fun showAll(){
        if(elements.isEmpaty()){
            println("La lista esta vacia")
        }else{
            println("Lista de tareas")
            elements.forEach {println("- $it")}
        }
    }
    fun size(): int{
        return elements.size
    }
    fun getAll(): List<T>{
        return elements
    }
}

    //main
    fun main(args: Array<String>){
        val listaTareas = customList<String>()
        var option: int 

        do {
            println("\nGestor de tareas")
            println("1. agregar tarea")
            println("2. eliminar tarea")
            println("3. ver lista de tareas")
            println("salir")
            println("seleccionar una opcion:")

            when (opcion){
                1->{
                    println("Ingresar la nueva tarea:")
                    val nuevaTarea = readLine()?: ""
                    listaTareas.add(nuevaTarea)
                }
                2->{
                    if (listaTareas.size() > 0){
                        println("Seleccionar la tarea que desea eliminar!")
                        listaTareas.showAll()
                        println("Ingresar el nomnbre exacto de la tarea:")
                        val eliminarTarea = readLine()?: ""
                        listaTareas.remove(eliminarTarea)
                    }else{
                        println("La tarea no esta en la lista")
                    }
                }
                3->{
                    listaTareas.showAll()
                }
                4-> println("saliendo del programa...")
                else -> println("Opcion no valida, Ingrese una opcion valida.")
            }
        } while (opcion != 4)
    }