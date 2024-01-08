

fun main() {
    val movimientosPosibles = listOf("POSITIVEY", "NEGATIVEX", "NEGATIVEY", "POSITIVEX")

    val listaMovimientos = listOf(intArrayOf(10, 5, -2), intArrayOf(0, 0, 0), intArrayOf(), intArrayOf(-10, -5, 2), intArrayOf(-10, -5, 2, 4, -8))
    var movimientos: Array<Int>

    for (movimiento in listaMovimientos) {
        movimientos = moverRobot(movimiento)
        println("x: ${movimientos[0]}, y: ${movimientos[1]}, dirección: ${movimientosPosibles[movimientos[2]]}")
    }
}

/**
 * Devuelve la posición final del robot dado un Array de movimientos.
 *
 * @param movimientos Array de movimientos que debe realizar el robot.
 * @return posicionFinal Array de posicion y dureccion finales del robot.
 */
fun moverRobot(movimientos: IntArray): Array<Int> {
    var posX = 0
    var posY = 0
    var direccion = 0

    if (movimientos.isEmpty()) {
        println("El robot no puede hacer nada.")
    } else {
        for (elemento in movimientos) {

            when (direccion) {
                0 -> posY += elemento
                1 -> posX -= elemento
                2 -> posY -= elemento
                3 -> posX += elemento
            }
            if (direccion == 3) {
                direccion = 0
            } else {
                ++direccion
            }
        }
    }
    val posicionFinal = arrayOf(posX, posY, direccion)

    return posicionFinal
}