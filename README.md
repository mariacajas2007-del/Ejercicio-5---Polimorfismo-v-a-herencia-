# Defensa de QTZ2

## Descripción

Defensa de QTZ2 es un simulador de consola desarrollado en Java para administrar los componentes de una misión espacial.

La misión utiliza tres tipos de módulos:

- Módulos de energía: generan energía para la misión.
- Módulos de vuelo: consumen energía y recolectan datos científicos.
- Módulos de tierra: consumen energía y descargan los datos almacenados en órbita.

El proyecto aplica programación orientada a objetos, herencia, polimorfismo, encapsulación y el patrón Modelo-Vista-Controlador (MVC).

## Funcionalidades

El programa permite:

1. Listar todos los módulos de la misión.
2. Buscar un módulo por ID o nombre.
3. Mostrar el catálogo ordenado por costo de construcción.
4. Avanzar un ciclo del simulador.
5. Consultar el resumen de comunicaciones.
6. Conservar los recursos y acumulados entre ciclos.

## Estructura del proyecto

```text
src
├── App.java
├── Controlador
│   └── ControladorMision.java
├── Vista
│   └── VistaConsola.java
└── modelo
    ├── EstadoMision.java
    ├── Mision.java
    ├── Modulo.java
    ├── ModuloEnergia.java
    ├── ModuloVuelo.java
    └── ModuloTierra.java
