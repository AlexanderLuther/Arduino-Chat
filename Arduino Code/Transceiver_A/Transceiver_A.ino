#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>

#define CE_PIN 48
#define CSN_PIN 49

const byte W_ADDRESS[6] = "00001";
const byte R_ADDRESS[6] = "00002";

RF24 transceiver(CE_PIN, CSN_PIN);

void setup() {
  Serial.begin(9600);
  transceiver.begin();                
  transceiver.setChannel(115); 
  transceiver.setPALevel(RF24_PA_MAX);     //RF24_PA_MIN,/ RF24_PA_LOW,/ RF24_PA_HIGH,/ RF24_PA_MAX
  transceiver.setDataRate(RF24_250KBPS);   //RF24_1MBPS,/ RF24_2MBPS,/ RF24_250KBPS  
  transceiver.openWritingPipe(W_ADDRESS);
  transceiver.openReadingPipe(1, R_ADDRESS);
}

void loop() {
  //Verificar si se ha escrito algun mensaje en el monitor serial, de ser asi se establece el transceptor como emisor. 
  if (Serial.available()){
      transceiver.stopListening();
      char data[50] = "";
      size_t count = Serial.readBytesUntil('\n', data, 50);
      transceiver.write(&data, sizeof(data));      
      //Serial.print("Enviado: ");
      //Serial.println(data);
  } 

  //Establecer el transceptor como receptor.     
  else{
    transceiver.startListening(); 
    if (transceiver.available()) {
      char data[50] = "";
      transceiver.read(&data, sizeof(data));
      //Serial.print("Recibido: ");
      Serial.println(data);
    }
  }    
}

  
  //Rojo     VCC
  //Negro    GND
  //Verde    49   CSN  
  //Azul     48   CE
  //Blanco   50   MISO
  //Narnaja  51   MOSI
  //Amarillo 52   SCK
