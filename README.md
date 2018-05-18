
MANUAL DE ADMINISTRADOR Y USUARIO


1- Antes de iniciar la aplicación:


- Cargar el scrypt en la base de datos de oracle, para ello se puede utilizar Oracle SQL Developer.


- Ejecutar reto2018.jar.


- Introducir la informacion de la base de datos.


- Entrar en el programa con los siguientes datos:




2- Actores de la aplicación:



Grupo 2 E-Sport ha diseñando una aplicación donde intervienen cuatro actores diferentes y cuyas acciones, funciones también serán distintas.


La figura principal va a ser la del SUPERUSUARIO cuyas funciones principales serán la de crear administradores y la del control del sistema de seguridad interno de la aplicación diseñado por Grupo 2 E-Sport.


En segundo plano va a intervenir la figura del ADMINISTRADOR que va a ser quien gestione las funciones principales de la aplicación y tendrá la potestad de acceder y modificar los datos de los que se sirve el programa de la aplicación.

En tercer lugar estará el DUEÑO que podrá hacer uso de esos datos para poder desarrollar sus funciones. Asi pues podrá configurar su equipo y otras acciones que se mostrará más detenidamente en los siguientes puntos.

Y por último estará la figura del USUARIO el cual simplemente tendrá acceso a funciones de consulta y en ningún caso a manipulación de datos o acceso a ellos.


3- Inicio de la aplicación: 


La aplicación arrancará mostrando la siguiente vista:






Ventana de Inicio-Login en la cual se deberán introducir los datos de la BD con la que se esté trabajando, en este caso Oracle. Además de esto, habrá que introducir los datos de usuario, password que bien serán proporcionados por Grupo 2 E-Sport al administrador, y al SUPERUSUARIO en este caso, y en el caso del resto de actores se podrán confeccionar desde la propia aplicación o a través del actor con dicha potestad.


4- SUPERUSUARIO:


El SUPERUSUARIO, una vez introducidas correctamente sus credenciales y como bien muestra la siguiente imagen tendrá acceso a su menú principal:





Desde aquí podrá crear, actualizar o eliminar a los administradores del sistema introduciendo los datos requeridos en los Texfields ( espacios en blanco ) y pulsando los botones con el ratón en los botones correspondientes (Anyadir, Actualizar, Eliminar ),como primera función.

Como segunda función podrá tener acceso al sistema de seguridad de la aplicación clicando con el botón izdo. Del ratón sobre la pestaña Triggers. Una vez hecho esto tendrá acceso a la ventana siguiente:





Desde aquí podrá ver qué acciones como por ejemplo actualizar, borrar o crear, se han hecho sobre los datos de la aplicación pertenecientes a equipos, duenyos, resultados, jugadores o usuarios. Simplemente habrá que pinchar con el ratón, botón izdo sobre la pestaña correspondiente y podrá visualizar qué acción fecha y qué administrador lo ha realizado.


Por último accediendo a la pestaña Configuración visualizará la siguiente ventana:






Aquí podrá modificar sus credenciales y podrá añadir datos de prueba en la aplicación.




5- Administrador:


El administrador una vez introducidas correctamente sus credenciales accederá a la ventana correspondiente a su menú:





Como bien se ha indicado anteriormente podrá manipular datos de la aplicación por lo que tanto en la pestaña de Equipos, como bien indica la imagen, y en las de Duenyos, Partidos, Jugadores y Usuarios podrá realizar las operaciones CRUD a las que Grupo 2 E-Sport ha habilitado en su codigo de programación. 


Por lo tanto podrá Insertar nuevos equipos, actualizar los datos o bien borrarlos. Esto mismo podrá hacerlo en el resto de pestañas accediendo a ellas haciendo doble click con el botón izdo del ratón sobre la pestaña correspondiente.


Por último el Administrador tendrá acceso a la pestaña de Configuración haciendo nuevamente doble click con el botón izdo del ratón. En esta pestaña como bien muestra la siguiente imagen podrá cambiar sus datos de usuario y contraseña.






6- Dueño:


En lo que respecta al actor Dueño (Duenyo en la aplicación), como bien se ha comentadoa anteriormente sólo tendrá acceso a la utilización de ciertos datos, en este caso la de jugadores para confeccionar su equipo, pero en ningún caso podrá manipular dichos datos. Podrá visualizar los jugadores libres para así poder fichar o darlos de baja de su equipo y siempre tendrá que cumplir las restricciones que le va a ir marcando la aplicación. En este caso van a ser que su equipo no puede exceder de 6 jugadores y el total del presupuesto del equipo non podrá exceder de la cantidad de 200.000.


Como se muestra en la siguiente imagen, así quedaría la ventana donde podrá hacer las acciones anteriromente indicadas.





Por otro lado podría consultar los últimos resultados de la jornada haciendo click en la pestaña de últimos resultados,







También podría consultar la calsificación de la última jornada,





Y por último como en el resto de opciones de las ventanas de los actores,la opción de configuración de sus datos,





7- Usuario:


En el caso de Usuario y a diferencia del resto de actores de la aplicación sólo tendrá acceso a funciones de consulta, pero en ningún caso a modificación o ultilización de los datos.


Por lo tanto tendrá acceso a un menú de usuario como el que se muestra a continuación donde podrá consultar accediendo a través de las pestañas a los resultados de cada jornada, a la clasificación, a los datos de los equipos y plantillas, así como al gráfico que muestra al evolución durante la temporada de los equipos. Por último también tendrá opción de modificar su datos de usuario y contraseña.












Proyecto DAM 2018 – Grupo 2 E-Sport

7


