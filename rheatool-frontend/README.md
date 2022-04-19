# rheatool-frontend

## Pasos previos
Hay que tener instalado Node en una version entre 12.0.0 y 14.0.0
```
# Hay que instalar npm y node
sudo apt install npm

sudo apt install curl
# Instalar un gestor de versiones de node (nvm), necesario para Vue
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.35.3/install.sh | bash
source ~/.bashrc

nvm list-remote
nvm install v12.22.12
nvm use v12.22.12
# Se pueden listar las versiones instaladas con nvm list
```

## Instalación del proyecto
Dentro de la carpeta 'rheatool-frontend' ejecutar los siguientes comandos
```
npm install
npm rebuild node-sass
```

### Lanzar el proyecto en local con detección de cambios de código en tiempo real
```
npm run serve
```

### Compilar el proyecto y minificarlo para producción
```
npm run build
```

### Lints y reparación de ficheros
```
npm run lint
```
