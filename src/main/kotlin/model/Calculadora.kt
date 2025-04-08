package org.example.model

class Calculadora: ICalculadora {


    override fun realizarCalculo(operador: Operadores, num: Double, num2: Double) : Double {

        return when (operador) {
            Operadores.SUMA -> {
                Calculadora().suma(num, num2)
            }
            Operadores.RESTA -> {
                Calculadora().resta(num, num2)
            }
            Operadores.DIVISION -> {
                Calculadora().division(num, num2)
            }
            Operadores.MULTIPLICACION -> {
                Calculadora().multiplicacion(num, num2)
            }
        }
    }

    override fun suma(num: Double, num2: Double): Double {
        return num + num2
    }

    override fun resta(num: Double, num2: Double): Double {
        return num - num2
    }

    override fun division(num: Double, num2: Double): Double {
        return num / num2
    }

    override fun multiplicacion(num: Double, num2: Double): Double {
        return num * num2
    }
}