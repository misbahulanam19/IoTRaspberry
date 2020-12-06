import RPLCD as RPLCD
from RPLCD.gpio import CharLCD
import RPi.GPIO as GPIO
import time
GPIO.setwarnings(False)

lcd = CharLCD(numbering_mode=GPIO.BOARD,
              cols=16, rows=2,
              pin_rs=37, pin_e=35,
              pins_data=[33,31,29,26])
lcd.clear()
kata = input('ketikkan karakter atau kata: ')
lcd.write_string(kata)
time.sleep(3)
GPIO.cleanup()