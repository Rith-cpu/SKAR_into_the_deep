package org.firstinspires.ftc.teamcode.OtosStuff.tuning.otos;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@Disabled
@TeleOp(name = "DirectionDebuggerOpMode")
public class DirectionDebuggerOpMode extends OpMode {
    // Declare motors
    private DcMotor LeftFront;
    private DcMotor LeftBack;
    private DcMotor RightFront;
    private DcMotor RightBack;

    @Override
    public void init() {
        // Initialize the motors
        LeftFront = hardwareMap.get(DcMotor.class, "LF");
        LeftBack = hardwareMap.get(DcMotor.class, "LB");
        RightFront = hardwareMap.get(DcMotor.class,"RF");
        RightBack = hardwareMap.get(DcMotor.class, "RB");
        // Optionally, reverse motors if needed
        LeftFront.setDirection(DcMotor.Direction.REVERSE);
        // RightFront.setDirection(DcMotor.Direction.REVERSE);
        LeftBack.setDirection(DcMotor.Direction.REVERSE);
        // RightBack.setDirection(DcMotor.Direction.REVERSE);


    }

    @Override
    public void start() {
        // Actions to start the OpMode (e.g., starting motors)

    }

    @Override
    public void loop() {
        // Control motor1 with DPad Up/Down for forward/reverse direction
        if (gamepad1.dpad_up) {
            RightFront.setPower(1.0);  // Full forward power
        } else if (gamepad1.dpad_down) {
            RightFront.setPower(-1.0); // Full reverse power
        } else {
            RightBack.setPower(0.0);  // Stop motor
        }






    }


    }

