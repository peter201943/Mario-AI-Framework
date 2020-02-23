package agents.peterMangelsdorf;

import java.util.ArrayList;
import java.util.Random;

import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioTimer;

public class Agent implements MarioAgent {
    
    private Random rnd;

    private ArrayList<boolean[]> choices;

    //private Task bt = new Task();

    @Override
    public void initialize(MarioForwardModel model, MarioTimer timer) {
        
        rnd = new Random();
        choices = makeChoices();
    }

    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
        return choices.get(rnd.nextInt(choices.size()));
    }

    @Override
    public String getAgentName() {
        return "PeterAgent";
    }

    /**
     * Constructs the list of random choices
     */
    private ArrayList makeChoices()
    {
        // init
        choices = new ArrayList<>();

        //right run
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});

        //right jump and run
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});

        // right
        choices.add(new boolean[]{false, true, false, false, false});
        choices.add(new boolean[]{false, true, false, false, false});
        choices.add(new boolean[]{false, true, false, false, false});
        choices.add(new boolean[]{false, true, false, false, false});

        // right jump
        choices.add(new boolean[]{false, true, false, false, true});
        choices.add(new boolean[]{false, true, false, false, true});
        choices.add(new boolean[]{false, true, false, false, true});
        choices.add(new boolean[]{false, true, false, false, true});

        //left
        choices.add(new boolean[]{true, false, false, false, false});

        //left run
        choices.add(new boolean[]{true, false, false, true, false});

        //left jump
        choices.add(new boolean[]{true, false, false, false, true});

        //left jump and run
        choices.add(new boolean[]{true, false, false, true, true});

        // Return
        return choices;
    }

}
