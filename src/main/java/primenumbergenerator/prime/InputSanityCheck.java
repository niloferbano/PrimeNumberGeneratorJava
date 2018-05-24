package primenumbergenerator.prime;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class InputSanityCheck {
   public int checkInputs(int lowRange, int highRange){

        if (highRange < 0 || lowRange < 0) {
            System.out.print("Please enter valid inputs. numbers can't be negative");
            return -1;
        }
        if(lowRange >= highRange){
            System.out.print("Low range should not be less than high range\n");
            return -1;
        }
        return lowRange;
    }
}
