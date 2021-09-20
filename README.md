# Generación de modelos de variabilidad con diferente expresividad mediante transformación de modelos - Proyecto Rhea

## Requisitos
- [Java JDK 11+](https://www.oracle.com/java/)
- [Git](https://git-scm.com/)
- [Eclipse for Java & DSL](https://www.eclipse.org/):
  - [Henshin]( http://download.eclipse.org/modeling/emft/henshin/updates/nightly)
  - Ecore Tools (from the Marketplace)

### Instalación
1. Instalar Java JDK 11 o superior (recomendamos 13.0.2).
2. Descargar e instalar Eclipse for Java & DSL.
3. Instalar Ecore Tools, desde el marketplace de Eclipse.
4. Instalar Henshin.
5. Clonar este repositorio en un espacio de trabajo de Eclipse.
6. Importar el proyecto a Eclipse.
7. Modificar las rutas absolutas del proyecto "rhea", para adaptarlas a las propias.

## Estructura del proyecto
* [rhea](https://github.com/CAOSD-group/rhea/tree/main/rhea). El proyecto principal. Es donde se encuentran ubicadas las rutas relativas y absolutas de ficheros, carpetas, modelos etc.

* [rhea.aafm](https://github.com/CAOSD-group/rhea/tree/main/rhea.aafm). Contiene un modulo que permite analizar los modelos de características de manera automática (obteniendo productos, configuraciones etc.).

* [rhea.evaluation](https://github.com/CAOSD-group/rhea/tree/main/rhea.evaluation). Contiene las pruebas y los ficheros que usan las transformaciones. Es donde debemos acudir para probarlas y generar los datos de los modelos (más en detalle, en siguientes secciones).

* [rhea.metamodels](https://github.com/CAOSD-group/rhea/tree/main/rhea.metamodels). Contiene todos los metamodelos de la sintaxsis abstracta necesarios para el funcionamiento de la aplicación, así como las clases generadas a partir de los mismos.

* [rhea.transformations](https://github.com/CAOSD-group/rhea/tree/main/rhea.transformations). Contiene las transformaciones de modelos, tanto mediante Henshin como mediante Java.

* [rhea.parsers](https://github.com/CAOSD-group/rhea/tree/main/rhea.parsers). Contiene los parsers y en definitiva, las herramientas necesarias para poder traducir los modelos desde un lenguaje externo a nuestra sintaxis abstracta.

* [rhea.generators](https://github.com/CAOSD-group/rhea/tree/main/rhea.generators). Similar al proyecto rhea.parsers, pero en su lugar, es el necesario para poder traducir modelos desde nuestra sintaxis a un lenguaje externo.

* [rhea.languageanalysis](https://github.com/CAOSD-group/rhea/tree/main/rhea.languageanalysis). Contiene un modulo para analizar la expresividad de los lenguajes.

* [rhea.thirdpartyplugins](https://github.com/CAOSD-group/rhea/tree/main/rhea.thirdpartyplugins). Contiene un conjunto de utilidades y librerías externas necesarias para el funcionamiento del proyecto.

## Artefactos
* Un conjunto de [metamodelos](https://github.com/CAOSD-group/rhea/tree/main/rhea.metamodels/metamodels) (.ecore) que especifican los constructores del lenguaje para el modelado de características.
* [Código Java](https://github.com/CAOSD-group/rhea/tree/main/rhea.metamodels/src/rhea/metamodels) generado con la implementación de las clases de los metamodelos.
* Transformaciones de modelo en Henshin (archivos .henshin y .henshin_diagram) que implementan los [generadores](https://github.com/CAOSD-group/rhea/tree/main/rhea.transformations/languagegenerators) para los constructores del lenguaje, así como [refactorizaciones](https://github.com/CAOSD-group/rhea/tree/main/rhea.transformations/refactorings).
* Traductor de modelos para el lenguaje Clafer, de [clafer a nuestra sintaxis](https://github.com/CAOSD-group/rhea/tree/main/rhea.parsers/src/rhea/parsers/clafer) y de [nuestra sintaxis a clafer](https://github.com/CAOSD-group/rhea/tree/main/rhea.generators/src/rhea/generators).
* Transformaciones de modelos que permiten llevar los contructores del lenguaje de MutexGroup y GroupCardinality, a constructores más simples, en [Java](https://github.com/CAOSD-group/rhea/tree/main/rhea.transformations/src/rhea/transformations/refactoringJava) y [Henshin](https://github.com/CAOSD-group/rhea/tree/main/rhea.transformations/src/rhea/transformations/refactoringHenshin).

## Ejecución
Para poder ejecutar alguna transformación, debemos acudir al proyecto *rhea.evaluation->src*. Allí, encontraremos varios paquetes, pero el que nos interesa es refactorings. Dentro podremos encontrar las clases MainJava y MainHenshin, para poder ejecutar las transformaciones. En la carpeta *inputs->clafer* del mismo proyecto, podemos encontrar modelos clasificados en carpetas. En la carpeta *outputs*, es donde encontraremos los modelos ya transformados en una clasificación identica a la carpeta *inputs*. Por último, los resultados de las transformaciones, podemos encontrarlos en el directorio raíz *temp->Evaluation*.

La configuración actual permite realizar transformaciones en GroupCardinalities mediante Java, y MutexGroup mediante Henshin, ambos sobre un subconjunto de pruebas, para evitar que el tiempo de ejecución pueda ser excesivo. En caso de querer probar otras transformaciones, solo hay que cambiar la variable *modelType* por el nombre de la carpeta contenedora de otros feature models, y cambiar la regla que se está ejecutando (cambiar el código de la línea 41 por el de la línea 42, tan solo comentando el que no lo este y descomentando el otro) acorde a la carpeta (es decir, si ejecutamos la regla para MutexGroup, la carpeta deberá ser una que contenga FM solo con MutexGroup).

En nuestro equipo, las pruebas que hemos dejado preparadas no han tardado apenas unos segundos. Rogamos que si pasa dicho límite, tenga paciencia y espere a que finalice. Por el contrario, es posible eliminar modelos de las carpetas para aligerar el proceso de transformación.

Por último, en caso de querer replicar las pruebas, los conjuntos seleccionados son las carpetas *MutexGroup* y *GroupCardinality*, pero desaconsejamos su uso como prueba debido al alto coste computacional.
