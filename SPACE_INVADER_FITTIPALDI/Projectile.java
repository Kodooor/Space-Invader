class Projectile{
  double positionX;
  double positionY;
  Dessin dessin;

Projectile(double positionX, double positionY){
  dessin = new Dessin();
  this.positionX=positionX;
  this.positionY=positionY;
}

  Dessin getDessin(){
    this.dessin.vider();
    this.dessin.ajouteChaine(this.positionX,this.positionY+3,  " █   █");
    this.dessin.ajouteChaine(this.positionX,this.positionY+2,  "█  █  █ ");
    this.dessin.ajouteChaine(this.positionX,this.positionY+1,  " █   █ ");
    this.dessin.ajouteChaine(this.positionX,this.positionY,  "   █    ");

    return dessin;

}
  void evolue(){
    this.positionY+=0.9;

  }


  double getPosY(){
    return this.positionY;
  }
}
