# ==============================
# IMPORT LIBRERIE
# ==============================

import RPi.GPIO as GPIO
import time
import Adafruit_CharLCD as LCD
import spidev

# ==============================
# CONFIGURAZIONE LCD
# ==============================

# Dimensioni display LCD
lcd_columns = 16
lcd_rows = 2

# Inizializza LCD
lcd = LCD.Adafruit_CharLCDBackpack(address=0x21)

# Accende retroilluminazione LCD
lcd.set_backlight(0)

# ==============================
# CONFIGURAZIONE SPI
# ==============================

# SPI serve per leggere il keypad matrix
spi = spidev.SpiDev()

# Apri bus SPI
spi.open(0, 1)

# Velocità SPI
spi.max_speed_hz = 1000000

# ==============================
# CLASSE BUTTON MATRIX
# ==============================

class ButtonMatrix():

    def __init__(self):

        # GPIO mode
        GPIO.setmode(GPIO.BCM)

        # Canale analogico usato dal keypad
        self.key_channel = 4

        # Delay lettura
        self.delay = 0.1

        # Valori ADC dei tasti
        self.adc_key_val = [
            30, 90, 160, 230,
            280, 330, 400, 470,
            530, 590, 650, 720,
            780, 840, 890, 960
        ]

        # Numero totale tasti
        self.num_keys = 16

    # ==============================
    # LEGGE VALORE ADC
    # ==============================

    def ReadChannel(self, channel):

        adc = spi.xfer2([1, (8 + channel) << 4, 0])

        data = ((adc[1] & 3) << 8) + adc[2]

        return data

    # ==============================
    # OTTIENE VALORE KEYPAD
    # ==============================

    def GetAdcValue(self):

        adc_key_value = self.ReadChannel(self.key_channel)

        return adc_key_value

    # ==============================
    # CONVERTE ADC IN TASTO
    # ==============================

    def GetKeyNum(self, adc_key_value):

        for num in range(0, 16):

            if adc_key_value < self.adc_key_val[num]:
                return num

        return -1


# ==============================
# INIZIALIZZA BUTTON MATRIX
# ==============================

buttons = ButtonMatrix()

# ==============================
# CODICE SEGRETO
# ==============================

SECRET_CODE = "735"

# Input utente
user_input = ""

# Tempo massimo
time_limit = 30

# Tempo iniziale
start_time = time.time()

# ==============================
# MAPPATURA TASTI
# ==============================

# Trasforma indice keypad in numero reale

key_map = {

    12: "1",
    13: "2",
    14: "3",

    10: "4",
    9: "5",
    8: "6",

    4: "7",
    5: "8",
    6: "9",

    1: "0"
}

# ==============================
# MESSAGGIO INIZIALE
# ==============================

lcd.clear()
lcd.message("DISINNESCA\nLA BOMBA!")

time.sleep(2)

# ==============================
# LOOP PRINCIPALE
# ==============================

while True:

    # Tempo rimasto
    elapsed = int(time.time() - start_time)

    remaining = time_limit - elapsed

    # ==============================
    # TEMPO SCADUTO
    # ==============================

    if remaining <= 0:

        lcd.clear()
        lcd.message("💥 BOOM 💥")

        print("BOOM!")

        break

    # ==============================
    # LEGGE TASTO
    # ==============================

    adc_value = buttons.GetAdcValue()

    key = buttons.GetKeyNum(adc_value)

    # Se un tasto valido è premuto
    if key in key_map:

        # Ottieni carattere reale
        value = key_map[key]

        # Evita doppie letture troppo rapide
        time.sleep(0.3)

        # Aggiunge input utente
        user_input += value

        print("Input:", user_input)

        # ==============================
        # AGGIORNA LCD
        # ==============================

        lcd.clear()

        lcd.message(
            "Code: " + user_input +
            "\nTime: " + str(remaining)
        )

        # ==============================
        # CODICE CORRETTO
        # ==============================

        if user_input == SECRET_CODE:

            lcd.clear()

            lcd.message("BOMBA\nDISINNESCATA!")

            print("VITTORIA!")

            break

        # ==============================
        # CODICE SBAGLIATO
        # ==============================

        if len(user_input) >= len(SECRET_CODE):

            lcd.clear()

            lcd.message("CODICE\nERRATO")

            print("Codice errato")

            time.sleep(2)

            # Reset input
            user_input = ""

            lcd.clear()

    # Piccola pausa CPU
    time.sleep(0.1)

# ==============================
# PULIZIA GPIO
# ==============================

GPIO.cleanup()
