package com.alberto.arellano.MVC;

import com.alberto.arellano.MVC.ModelBank;
import com.alberto.arellano.MVC.ViewBank;

/**
 * Created by rome on 10/11/2015.
 */
public class MVC {
    public static void main(String[] args){

            // Create instance of View
            ViewBank bankView = new ViewBank();
            // Create instance Model
            ModelBank bankModal = new ModelBank();
            // Create instance of Controller
            ControllerBank mvcController = new ControllerBank(bankView,bankModal);
            // IMPORTANT to have this method otherwise its not going to show up
            bankView.setVisible(true);

    }

}
