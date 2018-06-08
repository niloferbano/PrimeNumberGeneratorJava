package primenumbergenerator.prime;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class InputSanityCheck {
   public boolean checkInputs(int lowRange, int highRange){

        if (highRange < 0) {
            System.out.print("Please enter valid inputs. numbers can't be negative");
            return false;
        }
        if(lowRange >= highRange){
            System.out.print("High range should not be less than low range\n");
            return false;
        }
        return true;
    }
}
