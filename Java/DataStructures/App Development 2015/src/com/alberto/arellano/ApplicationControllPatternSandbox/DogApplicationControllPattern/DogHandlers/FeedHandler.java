package com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.DogHandlers;

import com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.Dog.Dog;

/**
 * Created by rome on 12/1/2015.
 */
public class FeedHandler implements DogHandler {
    @Override
    public void handleCommand(Dog aDog) {
        // Execute respective Function
        aDog.eat();
    }
}
