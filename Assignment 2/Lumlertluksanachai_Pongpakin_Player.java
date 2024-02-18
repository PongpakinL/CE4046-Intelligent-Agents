class Lumlertluksanachai_Pongpakin_Player extends Player {
    // Initialize variables
    boolean defected = false; // boolean variable to keep track of whether this player has defected
    int forgivenAfter = 5; // the number of rounds after which this player is forgiven for defecting
    int roundsSinceDefection = 0; // the number of rounds since this player last defected
    
    int selectAction(int n, int[] myHistory, int[] oppHistory1, int[] oppHistory2) {

        // Defect in the last few rounds
        if (n >= 107) return 1;

        // If this player has defected before, check if it has been enough rounds to be forgiven
        if (defected) {

            // Increment the roundsSinceDefection variable
            roundsSinceDefection++;
                
            // If the player has been forgiven, reset the defected variable and roundsSinceDefection variable
            if (roundsSinceDefection >= forgivenAfter) {
                defected = false;
                roundsSinceDefection = 0;
            }
            
            // Always return 1 if this player has defected before
            return 1;
        }
            
        // If this player has not defected before, check if its opponents have defected in the past
        for (int i = 0; i < n; i++) {
            if (oppHistory1[i] == 1 || oppHistory2[i] == 1) {
                // If either opponent has defected, set this player's defected variable to true
                // and reset the roundsSinceDefection variable to 0
                defected = true;
                roundsSinceDefection = 0;
                return 1;
            }
        }
            
        // If neither this player nor its opponents have defected, return 0
        return 0;
    }
}