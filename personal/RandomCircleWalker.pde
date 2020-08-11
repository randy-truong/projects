//People myPeople1;
//People myPeople2;

People[] peopleArray;
int numPeople = 2;
//int X, Y;
//int nX, nY;
int delay = 16;

void setup() {
  size(400,400);
  
  peopleArray = new People[numPeople];
  for (int i = 0; i < numPeople; i++) {
    //peopleArray[i] = new People(random(width), random(height));
    peopleArray[i] = new People(random(100), random(100));
  }

  strokeWeight(10);
  frameRate(60);
  //X = width / 2;
  //Y = width / 2;
  //nX = X;
  //nY = Y;
}

void draw() {
  background(100);
  
  for (int i = 0; i < peopleArray.length; i++) {
    peopleArray[i].display();
    peopleArray[i].move();
    
    if (peopleArray[0].intersect(peopleArray[1])) {
      peopleArray[0].highlight();
      peopleArray[0].highlight();
    }
  }
  
}


class People {
   float Xpos;
   float Ypos;
   float radius = 12.5;
  
  People(float tempXpos, float tempYpos) {
    Xpos = tempXpos;
    Ypos = tempYpos;
  }
 
  
  void display() {
    radius = radius + sin(frameCount/4);
    
    // Below breaks animation
    //background(100);
    
    fill(0, 121, 184);
    stroke(255);
    ellipse(Xpos, Ypos, radius*2, radius*2);
    
  }
  
  boolean intersect(People p) {
    float distance = dist(Xpos, Ypos, p.Xpos, p.Ypos); // Calculate distance
    if (distance < radius + p.radius) {  // compare distance to sum of radii
      return true;
    } else {
      return false;
    }
    
  }
  
  void highlight() {
    fill(0, 121, 120);
    System.out.println("Two people have crossed!");
  }
  
  // Method for determining movement
  void move() {
    int choice = int(random(6));
    
    if (choice == 0) {
      Xpos += 0;
      Ypos += 0;
      
    } else if (choice == 1) {
      Xpos = constrain(Xpos+1, 0, width);
      //Xpos++;    // step right
    } else if (choice == 2) {
      Xpos = constrain(Xpos-1, 0, width);
      //Xpos--;    // step left
    } else if (choice == 3) {
      Ypos = constrain(Ypos+1, 0, height);
      //Ypos++;    // step up
    } else if (choice == 4){
      Ypos = constrain(Ypos-1, 0, height);
      //Ypos--;    // step down
    } else {
      Xpos += 0;
      Ypos += 0;
    }
    
    //int stepX = int(random(3))-1;
    //int stepY = int(random(3))-1;
    
    //Xpos += stepX;
    //Ypos += stepY;
    
  }
  
}
