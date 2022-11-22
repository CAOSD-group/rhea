# Rhea v. 2022
#Conectar git hub al sevidor
git clone https://github.com/CAOSD-group/rhea.git
#entrar desde la terminal en la carpeta del la web : rhea-web
cd rhea/rhea-web
#instalar y/o actualizar npm
npm install
#ejecutar el servidor 
ng serve
Control+ C 
#Salimos del servidor 
#abrir nueva terminal
#llegar a la carpeta que contenga la carpeta rhea y los ficheros .bash
# cd .. para retroceder, dir para ver las carpetas y cd "nombre" para entrar en una carpeta
#comprobar que paython 3.10 o superior este instalado
sudo python -V
# Creamos un enviroment propio
python -m venv env
# Activamos el enviroment si no se ha activado automaticamente
source env/bin/activate
# Una vez activo entramos en la carpeta del la aplicacion e instalamos las dependencias
(env)'''' cd rhea  //si no se ve (env) al principio de la linea es que el enviroment no esta activo
pip install -r requirements.txt
# Entramos en el server y lo ejecutamos
cd rhea-backend
python server.py
Control+C 
# para salir del servidor
# Automatizacion del inicio de los servidores
# desde la terminal llegamos a la parte 
cd 
cd ..
cd ..
# Sabremos que hemos llegado cuando repitiendo el comando cd .. no cambie el directorio

# creamos dos servicio en el sistema, uno para el server y otro para la web
cd /etc/systemd/system
sudo nano startweb.service 
 // deberia pedir la contraseña 
# copiamos el contenido 
[Unit]
Description=My custom startup script

[Service]
ExecStart=/home/caosd/Escritorio/rhea-project/startWebApp.bash start

[Install]
WantedBy=multi-user.target

# Donde pone Service modicifar los nombres de la carpeta para que coincida con la localizacion del proyecto 
control+O para guardar -> enter /intro para guardarlo manteniendo el nombre
#repetimos para el servidor
sudo nano startserver.service 

[Unit]
Description=My custom startup script

[Service]
ExecStart=/home/caosd/Escritorio/rhea-project/startServerApp.bash start

[Install]
WantedBy=multi-user.target
# Modificamos de nuevo la direccion de la carpeta

# Ya no se escribe el .service a partir de aqui

# Para comprobar que funcionen podemos hacer 
systemctl start startserver
systemctl status startserver
systemctl start startweb
systemctl status startweb
# Si no cerramos antes los servidores no funcionara
# Si todo ha funcionado correctamente ya se vera en el localhost:4200

# Para automatizar el proceso solo faltara hacer
systemctl enable startserver
systemctl enable startweb
# Si todo a salido bien ya deberiamos tener que el servidor y la pagina web se ejecuten automaticamente nada mas encender el ordenador
