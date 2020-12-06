import RPLCD as RPLCD
from RPLCD.gpio import CharLCD
import RPi.GPIO as GPIO
import time
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

cred = credentials.Certificate('firebasekey.json')

firebase_admin.initialize_app(cred,{
'databaseURL': "https://raspberrytmj-1.firebaseio.com/" 
})

ref = db.reference('LCD')

GPIO.setmode(GPIO.BOARD)
GPIO.setup(36, GPIO.OUT)

GPIO.setwarnings(False)

lcd = CharLCD(numbering_mode=GPIO.BOARD,
              cols=16, rows=2,
              pin_rs=37, pin_e=35,
              pins_data=[33,31,29,26])

while True:
    lcd.clear()
    get_kata = ref.get()
    katabaru = get_kata[u'pesan'][u’pesan]
    lcd.write_string(katabaru)
    time.sleep(3)

GPIO.cleanup()