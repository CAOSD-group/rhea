#!/bin/bash
cd /home/usuario/rhea
source env/bin/activate
pip install -r requirements.txt
cd rhea-backend
python server.py
