class Alien{
  double positionX;
  double positionY;
  Dessin dessin;


Alien(int x, int y){
  dessin = new Dessin();
  this.positionX=x;
  this.positionY=y;
}

Dessin getDessin(){
  this.dessin.vider();
  this.dessin.ajouteChaine(positionX+1, positionY+4,"▄▄████▄▄");
  this.dessin.ajouteChaine(positionX, positionY+3,"██████████" );
  this.dessin.ajouteChaine(positionX, positionY+2,"██▄▄██▄▄██" );
  this.dessin.ajouteChaine(positionX+1, positionY+1,"▄▀▄▀▀▄▀▄ " );
  this.dessin.ajouteChaine(positionX+4, positionY,"▀▀" );
  return dessin;
}

void evolueX(double vitesseXalien){
      this.positionX+=vitesseXalien;
}

void evolueY(double vitesseYalien){
      this.positionY-=vitesseYalien;
    }

double getPosX(){return positionX;}

boolean contient(double posproX, double posproY){
    if(posproX>this.positionX && posproX< this.positionX+9 && posproY>this.positionY && posproY<posproY+4){return true;}
    return false;
}
}
