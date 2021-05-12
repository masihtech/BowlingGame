package Game;

public class Game {

    private int rollsArray[] = new int[21];

    private int framePointer = 0;
    private int rollsCtr = 0;

    public void roll(int pins) {
        rollsArray[rollsCtr] = pins;
        rollsCtr++;

    }

    public int score() {
        int gameScore = 0;
        int framePointer = 0;
        for (int i = 0; i < 10; i++) {
            //Is it a spare?
            if(isSpare(framePointer)){
                gameScore += 10+rollsArray[framePointer+2];
                framePointer+=2;
            } else if(isStrike(framePointer)){
                gameScore+= 10+rollsArray[framePointer+1]+rollsArray[framePointer+2];
                framePointer+=1;
            }
            else {
                gameScore += rollsArray[framePointer] +rollsArray[framePointer+1];
                framePointer+=2;
            }
        }

        return gameScore;
    }

    private boolean isStrike(int framePointer) {
        return rollsArray[framePointer] ==10;
    }

    private boolean isSpare(int framePointer) {
        return rollsArray[framePointer]+rollsArray[framePointer+1]==10;
    }
}

/*
10 frames
each frame / 2 chances to knock down 10 pins

score : total number pins + bonuses for strike and spare

spare : 10 , next turn ,first roll

strike : 10+ next 2 rolls

10 frame :
if strked , allowed 2 more roll
if spare , alowed one more

method : roll(int pins)

total scores : score

 */
