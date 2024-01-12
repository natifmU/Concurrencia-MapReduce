# Concurrencia-MapReduce
Programación Concurrente y Distribuida


Implementar un modelo MapReduce que permita interpretar los log de salida de una aplicación
basada en servicios API REST, los log tienen una salida como la que se muestra a continuación:

<img width="651" alt="Captura de Pantalla 2024-01-12 a las 6 01 07 p  m" src="https://github.com/natifmU/Concurrencia-MapReduce/assets/150955864/2c9282a5-7ffc-4b03-a000-4a67ebb1db84">

Como se puede observar de inicio cada liana de log tienen el nombre de la aplicación
“wallet-rest-api” y luego de la fecha tiene una etiqueta [INFO], la etiqueta varia y puede llegar
a tener los siguientes valores [SEVERE] para errores y [WARN] para Warning.
El programa desarrollado debe contar la cantidad de [INFO] [SEVERE] y [WARN] en un archivo
de log dado.


