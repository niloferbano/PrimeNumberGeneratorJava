package primenumbergenerator.prime;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class InputSanityCheck {
   public int checkInputs(int lowRange, int highRange){

        if (highRange < 0) {
            System.out.print("Please enter valid inputs. numbers can't be negative");
            return -1;
        }
        if(lowRange >= highRange){
            System.out.print("High range should not be less than low range\n");
            return -1;
        }
        return lowRange;
    }
}
