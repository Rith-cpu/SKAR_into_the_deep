package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Drivetrain {

    DcMotor LF_motor, RF_motor;
    DcMotor LB_motor, RB_motor;


    public Drivetrain(HardwareMap initMotors) {
        LF_motor = initMotors.get(DcMotor.class, "LF");
        RF_motor = initMotors.get(DcMotor.class, "RF");
        LB_motor = initMotors.get(DcMotor.class, "LB");
        RB_motor = initMotors.get(DcMotor.class, "RB");


    }


    public void driving(Gamepad gamepad) {

        float LeftStickX = gamepad.left_stick_x;
        float RightStickX = gamepad.right_stick_x;
        float LeftStickY = gamepad.left_stick_y;


        double LF_power = 0;
        double LB_power = 0;
        double RF_power = 0;
        double RB_power = 0;

        //if (!gamepad.right_trigger < 0.1 ) {
        // Moving forwards & backwards
        if (LeftStickY != 0) {
            LF_power += LeftStickY;
            LB_power += LeftStickY;
            RF_power -= LeftStickY;
            RB_power -= LeftStickY;
        }

        // Strafing Left and Right
        if (LeftStickX != 0) {

            LF_power -= LeftStickX;
            LB_power += LeftStickX;
            RF_power += LeftStickX;
            RB_power -= LeftStickX;

        }

        //Turning Left and Rightcc
        if (RightStickX != 0) {

            LF_power -= RightStickX;
            LB_power -= RightStickX;
            RF_power -= RightStickX;
            RB_power -= RightStickX;

        }

        /*if (gamepad.right_trigger > 0) {
            if (LeftStickY != 0) {
                LF_power -= LeftStickY;
                LB_power -= LeftStickY;
                RF_power += LeftStickY;
                RB_power += LeftStickY;
            }

            // Strafing Left and Right
            if (LeftStickX != 0) {

                LF_power += LeftStickX;
                LB_power -= LeftStickX;
                RF_power += LeftStickX;
                RB_power -= LeftStickX;

            }

            //Turning Left and Rightcc
            if (RightStickX != 0) {

                LF_power += RightStickX;
                LB_power += RightStickX;
                RF_power += RightStickX;
                RB_power += RightStickX;
            }*/


            // Ensure speed is within valid range (-1 to 1)
            LF_power = Math.max(-1, Math.min(1, LF_power));
            LB_power = Math.max(-1, Math.min(1, LB_power));
            RF_power = Math.max(-1, Math.min(1, RF_power));
            RB_power = Math.max(-1, Math.min(1, RB_power));


            // Now you're setting the values of the power to the motors
            LF_motor.setPower(LF_power);
            LB_motor.setPower(LB_power);
            RF_motor.setPower(RF_power);
            RB_motor.setPower(RB_power);

        }



    }

