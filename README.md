# Generación de modelos de variabilidad con diferente expresividad mediante transformación de modelos - Proyecto Rhea

## Requisitos
- [Java JDK 11+](https://www.oracle.com/java/)
- [Git](https://git-scm.com/)
- [Eclipse for Java & DSL](https://www.eclipse.org/):
  - [Henshin](https://www.eclipse.org/henshin/) (Nightly builds)
  - Ecore Tools (from the Marketplace)

## Estructura del proyecto
* [rhea](https://github.com/CAOSD-group/rhea/tree/main/rhea). El proyecto principal. Es donde se encuentran ubicadas las rutas relativas y absolutas de ficheros, carpetas, modelos etc.

* [rhea.aafm](https://github.com/CAOSD-group/rhea/tree/main/rhea.aafm). Contiene un modulo que permite analizar los modelos de características de manera automática (obteniendo productos, configuraciones etc.).

* [rhea.evaluation](https://github.com/CAOSD-group/rhea/tree/main/rhea.evaluation). Contiene las pruebas y los ficheros que usan las transformaciones. Es donde debemos acudir para probarlas y generar los datos de los modelos (más en detalle, en la siguiente sección).

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
* Traductor de modelos para el lenguaje Clafer. De [clafer a nuestra sintaxis](https://github.com/CAOSD-group/rhea/tree/main/rhea.parsers/src/rhea/parsers/clafer) y de [nuestra sintaxis a clafer](https://github.com/CAOSD-group/rhea/tree/main/rhea.generators/src/rhea/generators).
* Transformacionesde modelos que permiten llevar los contructores del lenguaje de MutexGroup y GroupCardinality, a constructores más simples, para [Java](https://github.com/CAOSD-group/rhea/tree/main/rhea.transformations/src/rhea/transformations/refactoringJava) y [Henshin](https://github.com/CAOSD-group/rhea/tree/main/rhea.transformations/src/rhea/transformations/refactoringHenshin).

## Ejecución
Para poder ejecutar alguna transformación, debemos acudir al proyecto *rhea.evaluation->src*. Allí, encontraremos varios paquetes, pero el que nos interesa es refactorings. Dentro podremos encontrar las clases MainJava y MainHenshin, para poder ejecutar las transformaciones. En la carpeta *inputs->clafer* del mismo proyecto, podemos encontrar modelos clasificados en carpetas. En la carpeta *outputs*, es donde encontraremos los modelos ya transformados en una clasificación identica a la carpeta *inputs*. Por último, los resultados de las transformaciones, podemos encontrarlos en en directorio raíz *temp->Evaluation*.
