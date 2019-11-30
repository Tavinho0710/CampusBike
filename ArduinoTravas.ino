#include <Servo.h>

#define INPUT_SIZE 30
char input[INPUT_SIZE + 1];
    
int pino_servo[6];
Servo servo[6];
int command;
String position;

void setup()
{
  Serial.begin(9600);
  for (int i=0;i<6;i++){pino_servo[i] = (i+2);}
  for (int i=0;i<6;i++){
    servo[i].attach(pino_servo[i]);
    servo[i].write(0);
  }
}

void loop(){

  if(Serial.available()){
    byte size = Serial.readBytes(input, INPUT_SIZE);
    input[size] = 0; // Adicione o 0 final para finalizar a string C
    
    char* command = strtok(input, "&"); // Leia cada par de comandos 
    char* action = strtok(command, '|');
    char* pin = strchr(command, '|');
    
    Serial.println(action[0]);
    Serial.println(pin[1]);

    if(action[0] == 'E'){
      
      enableLock( convertCharToInt((int) pin[1]) );
      
    }else if(action[0] == 'D'){
      
      disableLock(convertCharToInt( (int) pin[1] ));
      
    }
  }
}
void disableLock(int p){

  Serial.println(p);
   servo[(p-1)].write(0);
}

void enableLock(int p){
   
   Serial.println(p);
   servo[(p-1)].write(90);
}

int convertCharToInt(int c){
  int a;
  switch(c){
      case 48: a = 0; break;
      case 49: a = 1; break;
      case 50: a = 2; break;
      case 51: a = 3; break;
      case 52: a = 4; break;
      case 53: a = 5; break;
      case 54: a = 6; break;
      case 55: a = 7; break;
      case 56: a = 8; break;
      case 57: a = 9; break;
    }
    return a;
}
