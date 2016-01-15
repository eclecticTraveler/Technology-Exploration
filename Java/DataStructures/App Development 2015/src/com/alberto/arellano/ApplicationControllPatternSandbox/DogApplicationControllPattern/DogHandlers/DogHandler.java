package com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.DogHandlers;

import com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.Dog.Dog;

/**
 * Created by rome on 12/1/2015.
 */
public interface DogHandler {
    // Method signature
    public void handleCommand(Dog aDog);
}
