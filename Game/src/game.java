import java.awt.*;
import java.awt.event.*;

public class game extends GameEngine {
    public static void main(String args[]) {
        createGame(new game());
    }

    //-------------------------------------------------------
    // Variables
    //-------------------------------------------------------
    boolean left, right, lefthu, righthu;
    double platformX[], platformY[];
    double platformW[], platformH[];
    double platformVX[];
    int numPlatforms;
    int numhands;
    int currentLetter;
    int textX, textY, text2X, text2Y, text3X, text3Y;
    int scoreHu=0, scorePlayer=0;
    boolean correctPlayer, correctHu;
    boolean huWin, playerWin;
    double trampolineX, trampolineY;
    double trampolineW, trampolineH;
    Image background, goverhu, goverhugh;

    // Initialise the game
    public void init() {
        // Initialise Window Size
        setWindowSize(1000, 500);

        // Initialise Platforms
        initPlatforms();

        // Initialise Player
        initPlayer();

        // Initialise Human
        inithu();

        initTrampoline();

        inithands();

        currentLetter=rand(25)+1;

        textX=rand(1000);
        textY=rand(250)+200;

        text2X=rand(1000);
        text2Y=rand(250)+200;

        text3X=rand(1000);
        text3Y=rand(250)+200;

        goverhu = loadImage ("Images/huwon.png");
        goverhugh = loadImage ("Images/hughwon.png");
        background = loadImage ("Images/spacebg.png");
    }

    // Updates the game
    public void update(double dt) {
        // Update Player
        updatePlayer(dt);
        // Update Human
        updatehu(dt);
        // Update Platforms
        updatePlatforms(dt);

        updateGameover(dt);

        if ((correctPlayer)||(correctHu)) {
            updatecurrentletter(dt);
        }
        if (scoreHu>4){
            huWin=true;
        }
        if (scorePlayer>4){
            playerWin=true;
        }
    }

    Image hands[] = new Image[26];

    public void inithands(){
        numhands=26;
        int i;
        for(i=1; i<numhands; i++){
            hands[i]=loadImage("Images/"+i+".jpg");
        }
    }

    public void paintComponent() {
        drawImage(background, 0, 0, 1000, 500);

        drawHands();

        // Draw Platforms
        drawPlatforms();

        // Draw Player
        drawPlayer();

        //draw Human
        drawhu();

        drawTrampoline();


        drawLetters();

        drawBoldText(195, 125, ""+scoreHu, "Arial", 20);
        drawBoldText(785, 125, ""+scorePlayer, "Arial", 20);

        if (huWin) {
            drawImage(goverhu, 0, 0, 1000, 500);
        }


        if (playerWin){
            drawImage(goverhugh, 0, 0, 1000, 500);
        }
    }

    public void updateGameover(double dt) {

    }

    public void updatecurrentletter(double dt){
        currentLetter=rand(25)+1;

        textX=rand(950);
        textY=rand(295)+200;

        text2X=rand(950);
        text2Y=rand(295)+200;

        text3X=rand(950);
        text3Y=rand(295)+200;

        if (correctPlayer) {
            scorePlayer+=1;
        }
        if (correctHu) {
            scoreHu+=1;
        }

        correctPlayer=false;
        correctHu=false;
    }

    public void drawHands() {
        if (currentLetter==1) {
            drawImage(hands[1], 420, 20, 150, 150);
        }
        if (currentLetter==2) {
            drawImage(hands[2], 420, 20, 150, 150);
        }
        if (currentLetter==3) {
            drawImage(hands[3], 420, 20, 150, 150);
        }
        if (currentLetter==4) {
            drawImage(hands[4], 420, 20, 150, 150);
        }
        if (currentLetter==5) {
            drawImage(hands[5], 420, 20, 150, 150);
        }
        if (currentLetter==6) {
            drawImage(hands[6], 420, 20, 150, 150);
        }
        if (currentLetter==7) {
            drawImage(hands[7], 420, 20, 150, 150);
        }
        if (currentLetter==8) {
            drawImage(hands[8], 420, 20, 150, 150);
        }
        if (currentLetter==9) {
            drawImage(hands[9], 420, 20, 150, 150);
        }
        if (currentLetter==10) {
            drawImage(hands[10], 420, 20, 150, 150);
        }
        if (currentLetter==11) {
            drawImage(hands[11], 420, 20, 150, 150);
        }
        if (currentLetter==12) {
            drawImage(hands[12], 420, 20, 150, 150);
        }
        if (currentLetter==13) {
            drawImage(hands[13], 420, 20, 150, 150);
        }
        if (currentLetter==14) {
            drawImage(hands[14], 420, 20, 150, 150);
        }
        if (currentLetter==15) {
            drawImage(hands[15], 420, 20, 150, 150);
        }
        if (currentLetter==16) {
            drawImage(hands[16], 420, 20, 150, 150);
        }
        if (currentLetter==17) {
            drawImage(hands[17], 420, 20, 150, 150);
        }
        if (currentLetter==18) {
            drawImage(hands[18], 420, 20, 150, 150);
        }
        if (currentLetter==19) {
            drawImage(hands[19], 420, 20, 150, 150);
        }
        if (currentLetter==20) {
            drawImage(hands[20], 420, 20, 150, 150);
        }
        if (currentLetter==21) {
            drawImage(hands[21], 420, 20, 150, 150);
        }
        if (currentLetter==22) {
            drawImage(hands[22], 420, 20, 150, 150);
        }
        if (currentLetter==23) {
            drawImage(hands[23], 420, 20, 150, 150);
        }
        if (currentLetter==24) {
            drawImage(hands[24], 420, 20, 150, 150);
        }
        if (currentLetter==25) {
            drawImage(hands[25], 420, 20, 150, 150);
        }
        if (currentLetter==26) {
            drawImage(hands[26], 420, 20, 150, 150);
        }
    }

    public void drawLetters() {
        changeColor(176, 155, 97);
        if (currentLetter==1) {
            drawBoldText(textX, textY, "A", "Arial", 20);
            drawBoldText(text2X, text2Y, "Z", "Arial", 20);
            drawBoldText(text3X, text3Y, "F", "Arial", 20);
        }
        if (currentLetter==2) {
            drawBoldText(textX, textY, "B", "Arial", 20);
            drawBoldText(text2X, text2Y, "T", "Arial", 20);
            drawBoldText(text3X, text3Y, "X", "Arial", 20);
        }
        if (currentLetter==3) {
            drawBoldText(textX, textY, "C", "Arial", 20);
            drawBoldText(text2X, text2Y, "A", "Arial", 20);
            drawBoldText(text3X, text3Y, "P", "Arial", 20);
        }
        if (currentLetter==4) {
            drawBoldText(textX, textY, "D", "Arial", 20);
            drawBoldText(text2X, text2Y, "J", "Arial", 20);
            drawBoldText(text3X, text3Y, "L", "Arial", 20);
        }
        if (currentLetter==5) {
            drawBoldText(textX, textY, "E", "Arial", 20);
            drawBoldText(text2X, text2Y, "Y", "Arial", 20);
            drawBoldText(text3X, text3Y, "F", "Arial", 20);
        }
        if (currentLetter==6) {
            drawBoldText(textX, textY, "F", "Arial", 20);
            drawBoldText(text2X, text2Y, "Q", "Arial", 20);
            drawBoldText(text3X, text3Y, "M", "Arial", 20);
        }
        if (currentLetter==7) {
            drawBoldText(textX, textY, "G", "Arial", 20);
            drawBoldText(text2X, text2Y, "W", "Arial", 20);
            drawBoldText(text3X, text3Y, "N", "Arial", 20);
        }
        if (currentLetter==8) {
            drawBoldText(textX, textY, "H", "Arial", 20);
            drawBoldText(text2X, text2Y, "E", "Arial", 20);
            drawBoldText(text3X, text3Y, "B", "Arial", 20);
        }
        if (currentLetter==9) {
            drawBoldText(textX, textY, "I", "Arial", 20);
            drawBoldText(text2X, text2Y, "R", "Arial", 20);
            drawBoldText(text3X, text3Y, "V", "Arial", 20);
        }
        if (currentLetter==10) {
            drawBoldText(textX, textY, "J", "Arial", 20);
            drawBoldText(text2X, text2Y, "T", "Arial", 20);
            drawBoldText(text3X, text3Y, "C", "Arial", 20);
        }
        if (currentLetter==11) {
            drawBoldText(textX, textY, "K", "Arial", 20);
            drawBoldText(text2X, text2Y, "Y", "Arial", 20);
            drawBoldText(text3X, text3Y, "X", "Arial", 20);
        }
        if (currentLetter==12) {
            drawBoldText(textX, textY, "L", "Arial", 20);
            drawBoldText(text2X, text2Y, "U", "Arial", 20);
            drawBoldText(text3X, text3Y, "Z", "Arial", 20);
        }
        if (currentLetter==13) {
            drawBoldText(textX, textY, "M", "Arial", 20);
            drawBoldText(text2X, text2Y, "I", "Arial", 20);
            drawBoldText(text3X, text3Y, "L", "Arial", 20);
        }
        if (currentLetter==14) {
            drawBoldText(textX, textY, "N", "Arial", 20);
            drawBoldText(text2X, text2Y, "O", "Arial", 20);
            drawBoldText(text3X, text3Y, "K", "Arial", 20);
        }
        if (currentLetter==15) {
            drawBoldText(textX, textY, "O", "Arial", 20);
            drawBoldText(text2X, text2Y, "P", "Arial", 20);
            drawBoldText(text3X, text3Y, "J", "Arial", 20);
        }
        if (currentLetter==16) {
            drawBoldText(textX, textY, "P", "Arial", 20);
            drawBoldText(text2X, text2Y, "Z", "Arial", 20);
            drawBoldText(text3X, text3Y, "F", "Arial", 20);
        }
        if (currentLetter==17) {
            drawBoldText(textX, textY, "Q", "Arial", 20);
            drawBoldText(text2X, text2Y, "A", "Arial", 20);
            drawBoldText(text3X, text3Y, "H", "Arial", 20);
        }
        if (currentLetter==18) {
            drawBoldText(textX, textY, "R", "Arial", 20);
            drawBoldText(text2X, text2Y, "S", "Arial", 20);
            drawBoldText(text3X, text3Y, "G", "Arial", 20);
        }
        if (currentLetter==19) {
            drawBoldText(textX, textY, "S", "Arial", 20);
            drawBoldText(text2X, text2Y, "D", "Arial", 20);
            drawBoldText(text3X, text3Y, "F", "Arial", 20);
        }
        if (currentLetter==20) {
            drawBoldText(textX, textY, "T", "Arial", 20);
            drawBoldText(text2X, text2Y, "W", "Arial", 20);
            drawBoldText(text3X, text3Y, "P", "Arial", 20);
        }
        if (currentLetter==21) {
            drawBoldText(textX, textY, "U", "Arial", 20);
            drawBoldText(text2X, text2Y, "Z", "Arial", 20);
            drawBoldText(text3X, text3Y, "G", "Arial", 20);
        }
        if (currentLetter==22) {
            drawBoldText(textX, textY, "V", "Arial", 20);
            drawBoldText(text2X, text2Y, "P", "Arial", 20);
            drawBoldText(text3X, text3Y, "A", "Arial", 20);
        }
        if (currentLetter==23) {
            drawBoldText(textX, textY, "W", "Arial", 20);
            drawBoldText(text2X, text2Y, "O", "Arial", 20);
            drawBoldText(text3X, text3Y, "I", "Arial", 20);
        }
        if (currentLetter==24) {
            drawBoldText(textX, textY, "X", "Arial", 20);
            drawBoldText(text2X, text2Y, "L", "Arial", 20);
            drawBoldText(text3X, text3Y, "I", "Arial", 20);
        }
        if (currentLetter==25) {
            drawBoldText(textX, textY, "Y", "Arial", 20);
            drawBoldText(text2X, text2Y, "Z", "Arial", 20);
            drawBoldText(text3X, text3Y, "F", "Arial", 20);
        }
        if (currentLetter==26) {
            drawBoldText(textX, textY, "Z", "Arial", 20);
            drawBoldText(text2X, text2Y, "N", "Arial", 20);
            drawBoldText(text3X, text3Y, "O", "Arial", 20);
        }
    }

    // Initialise Platforms
    public void initPlatforms() {
        // Create 6 platforms
        numPlatforms = 6;

        // Allocate Arrays
        platformX = new double[numPlatforms];
        platformY = new double[numPlatforms];
        platformW = new double[numPlatforms];
        platformH = new double[numPlatforms];
        platformVX = new double[numPlatforms];

        // Initialise values
        platformX[0] = 100;
        platformY[0] = 435;
        platformW[0] = 80;
        platformH[0] = 4;
        platformVX[0] = rand(40)+10;

        platformX[1] = 900;
        platformY[1] = 385;
        platformW[1] = 80;
        platformH[1] = 4;
        platformVX[1] = rand(40)+10;

        platformX[2] = 100;
        platformY[2] = 335;
        platformW[2] = 80;
        platformH[2] = 4;
        platformVX[2] = rand(40)+10;

        platformX[3] = 900;
        platformY[3] = 285;
        platformW[3] = 80;
        platformH[3] = 4;
        platformVX[3] = rand(40)+10;

        platformX[4] = 100;
        platformY[4] = 235;
        platformW[4] = 80;
        platformH[4] = 4;
        platformVX[4] = rand(40)+10;

        platformX[5] = 900;
        platformY[5] = 185;
        platformW[5] = 80;
        platformH[5] = 4;
        platformVX[5] = rand(40)+10;
    }

    public void updatePlatforms(double dt){
        for (int i = 0; i < numPlatforms; i++) {
            //platform velocity
            platformX[i] += platformVX[i] * dt;
            if(platformX[i]>=950){
                platformVX[i]*=-1;
            }
            if(platformX[i]<=50){
                platformVX[i]*=-1;
            }
        }
    }
    // Draw Platforms
    public void drawPlatforms() {
        // Draw all Platforms
        for (int i = 0; i < numPlatforms; i++) {
            // Draw
            changeColor(red);
            drawSolidRectangle(platformX[i] - platformW[i] / 2, platformY[i] - platformH[i] / 2, platformW[i], platformH[i]);
        }
    }

  // Initialise trampoline
    public void initTrampoline() {
        trampolineX=500;
        trampolineY=300;
        trampolineW=200;
        trampolineH=10;
    }

    // Draw Trampoline
    public void drawTrampoline() {
        changeColor(185,137,120);
        drawSolidRectangle(trampolineX - trampolineW / 2, trampolineY - trampolineH / 2, trampolineW, trampolineH);
    }
    //-------------------------------------------------------

    //-------------------------------------------------------
    // Player
    //-------------------------------------------------------
    double playerX, playerY;
    double playerW, playerH;
    double playerVX, playerVY;
    //-------------------------------------------------------

    // Player Falling
    boolean playerFalling;

    // Player Sprites
    Image playerSpriteSheet;
    Image playerFallingImage;
    Image playerFallingSideImage;
    Image playerStandingImage;
    Image playerRunning[];

    int playerFrame;

        // Initialise Player
    public void initPlayer() {
        // Set Size
        playerW = 37.5;
        playerH = 50;

        // Start position
        playerX = 750;
        playerY = 500 - playerH / 2;

        // Start Velocity
        playerVX = 0;
        playerVY = 0;

        // Not Falling
        playerFalling = false;

        // Load Spritesheet
        playerSpriteSheet = loadImage("Images/hughsprites.png");

        // Load sprites
        playerStandingImage = subImage(playerSpriteSheet, 0, 0, 175, 200);
        playerFallingSideImage = subImage(playerSpriteSheet, 175, 0, 175, 200);
        playerFallingImage = subImage(playerSpriteSheet, 175, 0, 175, 200);

        playerRunning = new Image[2];

        // Load Running Sprites
        for (int i = 0; i < 2; i++) {
            int y = i / 6;
            int x = i;

            playerRunning[i] = subImage(playerSpriteSheet, x * 175, 0, 175, 200);
        }

        playerFrame = 0;
    }

    public int getFrame(double d, int num_frames) {
        return (int) Math.floor(((getTime() / 1000.0 % d) / d) * num_frames);
    }

    // Update Player
    public void updatePlayer(double dt) {

        double playerLeft = playerX - playerW / 2;
        double playerRight = playerX + playerW / 2;
        double playerTop = playerY - playerH / 2;
        double playerBottom = playerY + playerH / 2;

        // Select player frame
        playerFrame = getFrame(0.5, 2);

        playerVX = 0;

        // Move Left
        if (left) {
            playerVX -= 150;
        }

        // Move Right
        if (right) {
            playerVX += 150;
        }

        // Apply gravity
        playerVY += 250 * dt;

        // Move Player
        playerX += playerVX * dt;
        playerY += playerVY * dt;


        // ground
        if (playerY >= 500 - playerH / 2) {
            // Set vertical velocity to zero
            playerVY = 0;

            // Move player up to stop collision
            playerY = 500 - playerH / 2;

            // Player is not falling
            playerFalling = false;
        }

        // Horizontal Boundaries
        if (playerX <= playerW / 2) {
            // Prevent player leaving screen
            playerX = playerW / 2;
        }
        if (playerX >= 1000 - playerW / 2) {
            // Prevent player leaving screen
            playerX = 1000 - playerW / 2;
        }

        // For all Platforms
        for (int i = 0; i < numPlatforms; i++) {
            // Calculate edges of the platform
            double platformLeft = platformX[i] - platformW[i] / 2;
            double platformRight = platformX[i] + platformW[i] / 2;
            double platformTop = platformY[i] - platformH[i] / 2;
            double platformBottom = platformY[i] + platformH[i] / 2;

            // Check if player and platform are colliding
            if ((playerLeft < platformRight) && (playerRight > platformLeft) &&
                    (playerTop < platformBottom) && (playerBottom > platformTop)) {
                // Process Collision
                double tx = 1000000;
                double ty = 1000000;

                // If player is going left
                if (playerVX < 0) {
                    // Calculate time since collision in X
                    tx = (playerLeft - platformRight) / playerVX;
                } else if (playerVX > 0) {
                    // Calculate time since collision in X
                    tx = (playerRight - platformLeft) / playerVX;
                }

                // If player is going up
                if (playerVY < 0) {
                    // Calculate time since collision in Y
                    ty = (playerTop - platformBottom) / playerVY;
                } else if (playerVY > 0) {
                    // Calculate time since collision in Y
                    ty = (playerBottom - platformTop) / playerVY;
                }

                // Work out which collision to apply
                if (tx < ty) {
                    // Collided horizontally first
                    if (playerVX < -10) {
                        // Stop player moving
                        playerVX = 0;

                        // Correct position
                        playerX = platformRight + playerW / 2;
                    } else {
                        // Stop player moving
                        playerVX = 0;

                        // Correct position
                        playerX = platformLeft - playerW / 2;
                    }
                } else {
                    // Collided vertically first
                    if (playerVY < -30) {
                        // Stop player moving
                        playerVY = 0;

                        // Correct position
                        playerY = platformBottom + playerH / 2;
                    } else {
                        // Stop player moving
                        playerVY = 0;

                        // Correct position
                        playerY = platformTop - playerH / 2;

                        // Player is not falling
                        playerFalling = false;

                    }
                }
            }
        }

        // Trampoline
        // Calculate edges of the trampoline
        double trampolineLeft = trampolineX - trampolineW / 2;
        double trampolineRight = trampolineX + trampolineW / 2;
        double trampolineTop = trampolineY - trampolineH / 2;
        double trampolineBottom = trampolineY + trampolineH / 2;

        // Check if player and trampoline are colliding
        if ((playerLeft < trampolineRight) && (playerRight > trampolineLeft) &&
                (playerTop < trampolineBottom) && (playerBottom > trampolineTop)) {


            // Process Collision
            double tx = 1000000;
            double ty = 1000000;

            // If player is going left
            if (playerVX < 0) {
                // Calculate time since collision in X
                tx = (playerLeft - trampolineRight) / playerVX;
            } else if (playerVX > 0) {
                // Calculate time since collision in X
                tx = (playerRight - trampolineLeft) / playerVX;
            }

            // If player is going up
            if (playerVY < 0) {
                // Calculate time since collision in Y
                ty = (playerTop - trampolineBottom) / playerVY;
            } else if (playerVY > 0) {
                // Calculate time since collision in Y
                ty = (playerBottom - trampolineTop) / playerVY;
            }

            // Work out which collision to apply
            if (tx < ty) {
                // Collided horizontally first
                if (playerVX < 0) {
                    // Stop player moving
                    playerVX = 0;

                    // Correct position
                    playerX = trampolineRight + playerW / 2;
                } else {
                    // Stop player moving
                    playerVX = 0;

                    // Correct position
                    playerX = trampolineLeft - playerW / 2;
                }
            } else {
                // Collided vertically first
                if (playerVY < 0) {
                    // Stop player moving
                    playerVY = 0;

                    // Correct position
                    playerY = trampolineBottom + playerH / 2;

                } else {
                    // Stop player moving
                    playerVY = 0;

                    // Correct position
                    playerY = trampolineTop - playerH / 2;

                    // Player is not falling
                    playerFalling = false;

                    //Bounce
                    playerVY = -300;
                    playerFalling = true;

                }
            }
        }
        if ((playerLeft < textX+4) && (playerRight > textX-4) &&
                (playerTop <textY+4) && (playerBottom >textY-4)) {
            correctPlayer=true;
        }
    }



    public void jumpPlayer() {
        // If player is not falling
        if (playerFalling != true) {
            // Set player velocity
            playerY-=5;
            playerVY = -250;
            playerFalling = true;
        }
    }

    // Draw Player
    public void drawPlayer() {
        // Draw player with animation
        if (playerFalling) {
            // Draw Player falling
            if (playerVX > 0) {
                // If player is falling right
                drawImage(playerFallingSideImage, playerX - playerW / 2, playerY - playerH / 2, playerW, playerH);
            } else if (playerVX < 0) {
                // If player is falling left
                drawImage(playerFallingSideImage, playerX + playerW / 2, playerY - playerH / 2, -playerW, playerH);
            } else {
                // If player is falling straight down
                drawImage(playerFallingImage, playerX - playerW / 2, playerY - playerH / 2, playerW, playerH);
            }
        } else if (playerVX != 0) {
            // Draw the Player running
            if (playerVX > 0) {
                // If player is moving right
                drawImage(playerRunning[playerFrame], playerX - playerW / 2, playerY - playerH / 2, playerW, playerH);
            } else {
                // If player is moving left
                drawImage(playerRunning[playerFrame], playerX + playerW / 2, playerY - playerH / 2, -playerW, playerH);
            }
        } else {
            // Draw Player standing
            drawImage(playerStandingImage, playerX - playerW / 2, playerY - playerH / 2, playerW, playerH);
        }
    }

    //-------------------------------------------------------

    // KeyPressed
    public void keyPressed(KeyEvent event) {
        // Left Arrow
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        // Right Arrow
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        // up arrow
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            jumpPlayer();
        }

        // a key
        if (event.getKeyCode() == KeyEvent.VK_A) {
            lefthu = true;
        }
        // d key
        if (event.getKeyCode() == KeyEvent.VK_D) {
            righthu = true;
        }
        // w key
        if (event.getKeyCode() == KeyEvent.VK_W) {
            jumphu();
        }
    }

    // KeyReleased
    public void keyReleased(KeyEvent event) {
        // Left Arrow
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        // Right Arrow
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_A) {
            lefthu = false;
        }
        // Right Arrow
        if (event.getKeyCode() == KeyEvent.VK_D) {
            righthu = false;
        }
    }

        // Hu
        //-------------------------------------------------------
        double huX, huY;
        double huW, huH;
        double huVX, huVY;
        //-------------------------------------------------------

        // Hu Falling
        boolean huFalling;

        // Hu Sprites
        Image huSpriteSheet;
        Image huFallingImage;
        Image huFallingSideImage;
        Image huStandingImage;
        Image huRunning[];

        int huFrame;

        // Initialise Hu
    public void inithu() {
        // Set Size
        huW = 37.5;
        huH = 50;

        // Start position
        huX = 250;
        huY = 500 - huH / 2;

        // Start Velocity
        huVX = 0;
        huVY = 0;

        // Not Falling
        huFalling = false;

        // Load Spritesheet
        huSpriteSheet = loadImage("Images/husprites.png");

        // Load sprites
        huStandingImage = subImage(huSpriteSheet, 0, 0, 130, 200);
        huFallingSideImage = subImage(huSpriteSheet, 130, 0, 130, 200);
        huFallingImage = subImage(huSpriteSheet, 130, 0, 130, 200);

        huRunning = new Image[2];

        // Load Running Sprites
        for (int i = 0; i < 2; i++) {
            int y = i / 6;
            int x = i;

            huRunning[i] = subImage(huSpriteSheet, x * 130, 0, 130, 200);
        }

        huFrame = 0;
    }

    public int getFramehu(double d, int num_frames) {
        return (int) Math.floor(((getTime() / 1000.0 % d) / d) * num_frames);
    }

    // Update Human
    public void updatehu(double dt) {
        // Select Hu frame
        huFrame = getFramehu(0.5, 2);

        huVX = 0;

        double huLeft = huX - huW / 2;
        double huRight = huX + huW / 2;
        double huTop = huY - huH / 2;
        double huBottom = huY + huH / 2;

        // Move Left
        if (lefthu) {
            huVX -= 150;
        }

        // Move Right
        if (righthu) {
            huVX += 150;
        }

        // Apply gravity
        huVY += 250 * dt;

        // Move Hu
        huX += huVX * dt;
        huY += huVY * dt;

        // Vertical Boundaries
        if (huY >= 500 - huH / 2) {
            // Set vertical velocity to zero
            huVY = 0;

            // Move hu up to stop collision
            huY = 500 - huH / 2;

            // Hu is not falling
            huFalling = false;
        }

        // Horizontal Boundaries
        if (huX <= huW / 2) {
            // Prevent hu leaving screen
            huX = huW / 2;
        }
        if (huX >= 1000 - huW / 2) {
            // Prevent hu leaving screen
            huX = 1000 - huW / 2;
        }

        // For all Platforms
        for (int i = 0; i < numPlatforms; i++) {
            // Calculate edges of the platform
            double platformLeft = platformX[i] - platformW[i] / 2;
            double platformRight = platformX[i] + platformW[i] / 2;
            double platformTop = platformY[i] - platformH[i] / 2;
            double platformBottom = platformY[i] + platformH[i] / 2;

            // Check if hu and platform are colliding
            if ((huLeft < platformRight) && (huRight > platformLeft) &&
                    (huTop < platformBottom) && (huBottom > platformTop)) {
                // Process Collision
                double tx = 1000000;
                double ty = 1000000;

                // If hu is going left
                if (huVX < 0) {
                    // Calculate time since collision in X
                    tx = (huLeft - platformRight) / huVX;
                } else if (huVX > 0) {
                    // Calculate time since collision in X
                    tx = (huRight - platformLeft) / huVX;
                }

                // If hu is going up
                if (huVY < 0) {
                    // Calculate time since collision in Y
                    ty = (huTop - platformBottom) / huVY;
                } else if (huVY > 0) {
                    // Calculate time since collision in Y
                    ty = (huBottom - platformTop) / huVY;
                }

                // Work out which collision to apply
                if (tx < ty) {
                    // Collided horizontally first
                    if (huVX < 0) {
                        // Stop hu moving
                        huVX = 0;

                        // Correct position
                        huX = platformRight + huW / 2;
                    } else {
                        // Stop hu moving
                        huVX = 0;

                        // Correct position
                        huX = platformLeft - huW / 2;
                    }
                } else {
                    // Collided vertically first
                    if (huVY < 0) {
                        // Stop hu moving
                        huVY = 0;

                        // Correct position
                        huY = platformBottom + huH / 2;
                    } else {
                        // Stop hu moving
                        huVY = 0;

                        // Correct position
                        huY = platformTop - huH / 2;

                        // hu is not falling
                        huFalling = false;
                    }
                }
            }
        }
        // Trampoline
        // Calculate edges of the trampoline
        double trampolineLeft = trampolineX - trampolineW / 2;
        double trampolineRight = trampolineX + trampolineW / 2;
        double trampolineTop = trampolineY - trampolineH / 2;
        double trampolineBottom = trampolineY + trampolineH / 2;

        // Check if hu and trampoline are colliding
        if ((huLeft < trampolineRight) && (huRight > trampolineLeft) &&
                (huTop < trampolineBottom) && (huBottom > trampolineTop)) {
            // Process Collision
            double tx = 1000000;
            double ty = 1000000;

            // If hu is going left
            if (huVX < 0) {
                // Calculate time since collision in X
                tx = (huLeft - trampolineRight) / huVX;
            } else if (huVX > 0) {
                // Calculate time since collision in X
                tx = (huRight - trampolineLeft) / huVX;
            }

            // If hu is going up
            if (huVY < 0) {
                // Calculate time since collision in Y
                ty = (huTop - trampolineBottom) / huVY;
            } else if (huVY > 0) {
                // Calculate time since collision in Y
                ty = (huBottom - trampolineTop) / huVY;
            }

            // Work out which collision to apply
            if (tx < ty) {
                // Collided horizontally first
                if (huVX < 0) {
                    // Stop hu moving
                    huVX = 0;

                    // Correct position
                   huX = trampolineRight + huW / 2;
                } else {
                    // Stop hu moving
                    huVX = 0;

                    // Correct position
                    huX = trampolineLeft - huW / 2;
                }
            } else {
                // Collided vertically first
                if (huVY < 0) {
                    // Stop hu moving
                    huVY = 0;

                    // Correct position
                    huY = trampolineBottom + huH / 2;
                } else {
                    // Stop hu moving
                    huVY = 0;

                    // Correct position
                  huY = trampolineTop - huH / 2;

                    // hu is not falling
                    huFalling = false;

                    // Bounce
                    huVY = -300;
                    huFalling = true;

                }
            }
        }
            if ((huLeft < textX+4) && (huRight > textX-4) &&
                    (huTop <textY+4) && (huBottom >textY-4)) {
                correctHu=true;
        }
    }

    public void jumphu() {
        // If hu is not falling
        if (huFalling != true) {
            // Set hu velocity
            huY-=5;
            huVY = -250;
            huFalling = true;
        }
    }

    // Draw hu
    public void drawhu() {
        // Draw hu with animation
        if (huFalling) {
            // Draw hu falling
            if (huVX > 0) {
                // If hu is falling right
                drawImage(huFallingSideImage, huX - huW / 2, huY - huH / 2, huW, huH);
            } else if (huVX < 0) {
                // If hu is falling left
                drawImage(huFallingSideImage, huX + huW / 2, huY - huH / 2, -huW, huH);
            } else {
                // If hu is falling straight down
                drawImage(huFallingImage, huX - huW / 2, huY - huH / 2, huW, huH);
            }
        } else if (huVX != 0) {
            // Draw the hu running
            if (huVX > 0) {
                // If hu is moving right
                drawImage(huRunning[huFrame], huX - huW / 2, huY - huH / 2, huW, huH);
            } else {
                // If hu is moving left
                drawImage(huRunning[huFrame], huX + huW / 2, huY - huH / 2, -huW, huH);
            }
        } else {
            // Draw hu standing
            drawImage(huStandingImage, huX - huW / 2, huY - huH / 2, huW, huH);
        }
    }

    //-------------------------------------------------------
}
