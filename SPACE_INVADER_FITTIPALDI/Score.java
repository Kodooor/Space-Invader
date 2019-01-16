class Score{
  Dessin dessin;
  double positionX;
  double positionY;
  int score;
Score(){
  dessin = new Dessin();
  this.score=0;
  this.positionX=3;
  this.positionY=78;
}
Dessin getDessin(){
  this.dessin.vider();
  this.dessin.ajouteChaine(this.positionX,this.positionY,"score : "+this.score);
  return dessin;
}

void ajoute(int x){
  this.score+=x;
}

int retourne(){
  return this.score;
}
}
