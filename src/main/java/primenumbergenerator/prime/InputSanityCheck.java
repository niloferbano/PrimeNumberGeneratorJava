package primenumbergenerator.prime;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class InputSanityCheck {
   public int checkInputs(int lowRange, int highRange){
        if (lowRange == 1 || lowRange == 0) {
            return 2;
        }
        if (highRange < 0 || lowRange < 0) {
            System.out.print("Please enter valid inputs. numbers can't be negative");
            return -1;
        }
        return lowRange;
    }
}
