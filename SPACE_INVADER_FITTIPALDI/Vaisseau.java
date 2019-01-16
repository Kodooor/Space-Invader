class Vaisseau{
    double positionX;
    double positionY;
    Dessin dessin;

Vaisseau(){
  dessin = new Dessin();
  this.positionX=0;
  this.positionY=1;

}


  void deplacer(double dx){
    this.positionX+=dx;
  }

  Dessin getDessin(){
    this.dessin.vider();
    this.dessin.ajouteChaine(positionX, 0,"◥☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲☻▲☺▲◤");
    this.dessin.ajouteChaine(positionX, 1,"[███████████████████]" );
    this.dessin.ajouteChaine(positionX, 2,"▂▄▅█████████▅▄▃▂" );
    this.dessin.ajouteChaine(positionX, 3,"    ███████  " );
    this.dessin.ajouteChaine(positionX, 4,"       █      " );
    this.dessin.ajouteChaine(positionX, 5,"       █      " );
    this.dessin.ajouteChaine(positionX, 6,"       ▃      " );
    return dessin;
  }

  Double getPosCanon(){
    return this.positionX+6;
  }
}
