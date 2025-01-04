package org.firstinspires.ftc.teamcode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LinearActuatorAndClaw {

    public DcMotor LA_motor, LAR_motor, LAL_motor;
    double ticks = 537.7;
    double position = 0;
    int countVert = 0;
    int countPivot = 0;
    int countTouchVert = 0;
    int countTouchPivot = 0;
    LinearOpMode opMode;
    Servo claw_servo;

    public LinearActuatorAndClaw(HardwareMap initThings) {
        claw_servo = initThings.get(Servo.class, "Claw");
        LAL_motor = initThings.get(DcMotor.class, "Left_LA");
        LAR_motor = initThings.get(DcMotor.class, "Right_LA");
        LA_motor = initThings.get(DcMotor.class, "LA_motor");
        LAL_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LAR_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LA_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    public void LA_Vert(Gamepad gamepad1, Gamepad gamepad ) {

        if (gamepad.dpad_left) {
            LA_motor.setTargetPosition(-1005);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (gamepad.dpad_right) {
            LA_motor.setTargetPosition(-1790);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (gamepad.dpad_down) {
            LA_motor.setTargetPosition(0);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (LAL_motor.getCurrentPosition() < -370 && LAL_motor.getCurrentPosition() > -380) {
            if (gamepad.dpad_up) {
                LA_motor.setTargetPosition(-5050);
                LA_motor.setPower(1);
                LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

        /*if (LA_motor.getCurrentPosition() > -50 && LA_motor.getCurrentPosition() < 50) {
            LA_motor.setPower(0);
        }
        if (gamepad1.touchpad || countTouchVert == 1) {
            LA_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            if (gamepad.dpad_down){
                countVert = 1;
                countTouchVert = 1;
            }
            if (countVert == 1) {
                LA_motor.setTargetPosition(15);
                LA_motor.setPower(0.8);
                LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
        }*/
        }
    }




    public void LA_move(Gamepad gamepad1,Gamepad gamepad , Telemetry telemetry) {
        if (LA_motor.getCurrentPosition() > -50) {
            if (gamepad.b) {
                LAL_motor.setTargetPosition(-0);
                LAR_motor.setTargetPosition(0);
                LAL_motor.setPower(0.6);
                LAR_motor.setPower(-0.6);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            }
            if (gamepad.options) {
                LAL_motor.setTargetPosition(-1050);
                LAR_motor.setTargetPosition(1048);
                LAL_motor.setPower(0.6);
                LAR_motor.setPower(-0.6);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (gamepad.x) {
                LAL_motor.setTargetPosition(-375);
                LAR_motor.setTargetPosition(369);
                LAL_motor.setPower(0.5);
                LAR_motor.setPower(-0.5);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }


            if (gamepad.y) {
                LAL_motor.setTargetPosition(-1100);
                LAR_motor.setTargetPosition(1111);
                LAL_motor.setPower(0.5);
                LAR_motor.setPower(-0.5);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            if (gamepad.a) {
                LAL_motor.setTargetPosition(-1175);
                LAR_motor.setTargetPosition(1175);
                LAL_motor.setPower(0.5);
                LAR_motor.setPower(-0.5);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (gamepad.share) {
                LAL_motor.setTargetPosition(-667);
                LAR_motor.setTargetPosition(667);
                LAL_motor.setPower(0.6);
                LAR_motor.setPower(-0.6);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

                /*if (LAL_motor.getCurrentPosition() > -15 && LAR_motor.getCurrentPosition() < 15) {
                    LAL_motor.setPower(0);
                    LAR_motor.setPower(0);
                }
            //}
        if (gamepad1.touchpad || countTouchPivot == 1) {
            LA_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            if (gamepad.b) {
                countPivot = 1;
                countTouchPivot = 1;
            }
            if (countPivot == 1) {
                LAL_motor.setTargetPosition(0);
                LAR_motor.setTargetPosition(0);
                LAL_motor.setPower(0.5);
                LAR_motor.setPower(-0.5);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
        }*/
        }
    }




    public void claw_servo(Gamepad gamepad) {
        if (gamepad.right_bumper) {
            claw_servo.setPosition(1);
        }
        if (gamepad.left_bumper) {
            claw_servo.setPosition(0.45);
        }
        if (gamepad.left_bumper && gamepad.right_bumper) {
            claw_servo.setPosition(0.3);
        }

    }

    public void claw_servo(String pos) {
        pos.toLowerCase();

        if (pos == "close") {
            claw_servo.setPosition(1.0);
        }
        if (pos == "open") {
            claw_servo.setPosition(0.4);
        }
        if (pos == "super open") {
            claw_servo.setPosition(0.3);
        }
    }
    public void moveClaw(double pos) {
        claw_servo.setPosition(pos);
    }
    public void armPivot(int LeftMotorPos, int RightMotorPos, double speed){
        LAL_motor.setTargetPosition(LeftMotorPos);
        LAR_motor.setTargetPosition(RightMotorPos);
        LAL_motor.setPower(speed);
        LAR_motor.setPower(-speed);
        LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void armPivot(String posType){
        posType.toLowerCase();

        if (posType == "Basket Back") {
            LAL_motor.setTargetPosition(-174);
            LAR_motor.setTargetPosition(199);
            LAL_motor.setPower(0.2);
            LAR_motor.setPower(-0.2);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
        if (posType == "vertical") {
            LAL_motor.setTargetPosition(-375);
            LAR_motor.setTargetPosition(369);
            LAL_motor.setPower(0.5);
            LAR_motor.setPower(-0.5);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        if (posType == "hover"){
            LAL_motor.setTargetPosition(-1100);
            LAR_motor.setTargetPosition(1111);
            LAL_motor.setPower(0.5);
            LAR_motor.setPower(-0.5);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (posType == "pick up"){
            LAL_motor.setTargetPosition(-1175);
            LAR_motor.setTargetPosition(1175);
            LAL_motor.setPower(0.5);
            LAR_motor.setPower(-0.5);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        if (posType == "rest"){
            LAL_motor.setTargetPosition(-0);
            LAR_motor.setTargetPosition(0);
            LAL_motor.setPower(0.6);
            LAR_motor.setPower(-0.6);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (posType == "wall") {
            LAL_motor.setTargetPosition(-666);
            LAR_motor.setTargetPosition(666);
            LAL_motor.setPower(0.6);
            LAR_motor.setPower(-0.6);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

    }

    public void armVert(int VerticalPos, double speed){
        LA_motor.setTargetPosition(VerticalPos);
        LA_motor.setPower(speed);
        LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void armVert(String height){
        height.toLowerCase();

        if (height == "top basket"){
            LA_motor.setTargetPosition(-5050);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (height == "off wall"){
            LA_motor.setTargetPosition(-50);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (height == "touch bar"){
            LA_motor.setTargetPosition(-1000);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        if (height == "high chamber"){
            LA_motor.setTargetPosition(-1910);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (height == "zero"){
            LA_motor.setTargetPosition(0);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (height == "hang"){
            LA_motor.setTargetPosition(-1005);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }
}






