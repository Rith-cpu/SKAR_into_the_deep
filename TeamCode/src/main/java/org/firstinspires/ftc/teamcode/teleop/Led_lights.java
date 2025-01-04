package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Led_lights  {
    public RevBlinkinLedDriver lights;

    public Led_lights(HardwareMap hardware) {

        lights = hardware.get(RevBlinkinLedDriver.class, "Lights");
        lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BREATH_RED);
    }

    public void LED_pattern(double pos ) {
        if ( pos < -100 ){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.STROBE_RED);
        }
        else{
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
        }

    }
}
