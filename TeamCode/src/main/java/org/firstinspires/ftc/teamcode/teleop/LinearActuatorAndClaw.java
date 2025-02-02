package org.firstinspires.ftc.teamcode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LinearActuatorAndClaw {

    public DcMotor LA_motor, LAR_motor, LAL_motor;
    double ticks = 537.7;
    double position = 0;
    int countVert = 0;
    int countServo = 0;
    int countTouchVert = 0;
    int countTouchPivot = 0;
    LinearOpMode opMode;
    Servo claw_servo, MClaw;
    ElapsedTime timer = new ElapsedTime();

    public LinearActuatorAndClaw(HardwareMap initThings) {
        claw_servo = initThings.get(Servo.class, "Claw");
        MClaw = initThings.get(Servo.class, "MoveClaw");
        LAL_motor = initThings.get(DcMotor.class, "Left_LA");
        LAR_motor = initThings.get(DcMotor.class, "Right_LA");
        LA_motor = initThings.get(DcMotor.class, "LA_motor");
        LAL_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LAR_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LA_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    public void linearActuatorVert(Gamepad gamepad ) {

        if (gamepad.dpad_left) {
            LA_motor.setTargetPosition(-1265);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (gamepad.dpad_right) {
            LA_motor.setTargetPosition(-1544);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (gamepad.dpad_down) {
            LA_motor.setTargetPosition(0);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (gamepad.dpad_up) {
            if (LAL_motor.getCurrentPosition() < -370 && LAL_motor.getCurrentPosition() > -380) {
                LA_motor.setTargetPosition(-3346);
                LA_motor.setPower(1);
                LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            else if (gamepad.dpad_up && (LAL_motor.getCurrentPosition() < 10 && LAL_motor.getCurrentPosition() > -10)){
                LA_motor.setTargetPosition(-3865);
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




    public void linearActuatorMove(Gamepad gamepad , Telemetry telemetry) {
        
            if (gamepad.b) {
                MClaw.setPosition(1);
                LAL_motor.setTargetPosition(-0);
                LAR_motor.setTargetPosition(0);
                LAL_motor.setPower(0.6);
                LAR_motor.setPower(-0.6);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            }

        if (gamepad.left_stick_button) {
            MClaw.setPosition(0);
            LAL_motor.setTargetPosition(-375);
            LAR_motor.setTargetPosition(418);
            LA_motor.setTargetPosition(-410);
            LAL_motor.setPower(0.6);
            LAR_motor.setPower(-0.6);
            LA_motor.setPower(1);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
        if (gamepad.right_stick_button) {

            LA_motor.setTargetPosition(-1556);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
            if (gamepad.y) {
                MClaw.setPosition(0.45);
                LAL_motor.setTargetPosition(-1000);
                LAR_motor.setTargetPosition(1000);
                LAL_motor.setPower(0.6);
                LAR_motor.setPower(-0.6);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (gamepad.x) {
                MClaw.setPosition(0.45);
                LAL_motor.setTargetPosition(-375);
                LAR_motor.setTargetPosition(369);
                LAL_motor.setPower(0.5);
                LAR_motor.setPower(-0.5);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }


            if (gamepad.options) {
                MClaw.setPosition(0.8);
                LAL_motor.setTargetPosition(-1190);
                LAR_motor.setTargetPosition(1222);
                LAL_motor.setPower(0.5);
                LAR_motor.setPower(-0.5);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            if (gamepad.a) {

                LAL_motor.setTargetPosition(-1128);
                LAR_motor.setTargetPosition(1128);
                LAL_motor.setPower(0.5);
                LAR_motor.setPower(-0.5);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                MClaw.setPosition(0.45);
            }

            if (gamepad.share) {
                MClaw.setPosition(0.58);
                LAL_motor.setTargetPosition(-946);
                LAR_motor.setTargetPosition(953);
                LAL_motor.setPower(0.6);
                LAR_motor.setPower(-0.6);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            }

            if ((gamepad.right_trigger > 0) && (LAL_motor.getCurrentPosition() > -10 && LAL_motor.getCurrentPosition() < 10) ) {

                timer.startTime();
                LAL_motor.setTargetPosition(-163);
                LAR_motor.setTargetPosition(165);
                LAL_motor.setPower(0.6);
                LAR_motor.setPower(-0.6);
                LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                LA_motor.setTargetPosition(-1595);
                LA_motor.setPower(1);
                LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if ((gamepad.left_trigger > 0) && (LAL_motor.getCurrentPosition() > -168 && LAL_motor.getCurrentPosition() < -155) && LA_motor.getCurrentPosition() < -1590){
                claw_servo.setPosition(0.54);
                MClaw.setPosition(0.45);
                LA_motor.setTargetPosition(0);
                LA_motor.setPower(0.8);
                LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                if (LA_motor.getCurrentPosition() > -5){
                    LAL_motor.setTargetPosition(0);
                    LAR_motor.setTargetPosition(0);
                    LAL_motor.setPower(0.6);
                    LAR_motor.setPower(-0.6);
                    LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                }
            }
            if (gamepad.touchpad_finger_1){
                MClaw.setPosition(1);
            }
            if (gamepad.touchpad_finger_2){
                MClaw.setPosition(0.5);
            }


                /*if (LAL_motor.getCurrentPosition() > -15 && LAR_motor.getCurrentPosition() < 15) {
                    LAL_motor.setPower(0);
                    LAR_motor.setPower(0);
                }
            //}
        if (gamepad1.touchpad || countTouchPivot == 1) {
            LA_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            if (gamepad.b) {///////////////////////////////////////////////////
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




    public void clawServoActions(Gamepad gamepad) {
        if (gamepad.right_bumper) {
            claw_servo.setPosition(1);
        }
        if (gamepad.left_bumper) {
            claw_servo.setPosition(0.54);
        }
        if (gamepad.left_bumper && gamepad.right_bumper) {
            claw_servo.setPosition(0.3);
        }

    }
    public void claw_pivot(String pos) {
            pos.toLowerCase();

            if (pos == "backward") {
                MClaw.setPosition(1);
            }
            if (pos == "forward") {
                MClaw.setPosition(0.45);
            }
            if (pos == "wall") {
                MClaw.setPosition(0.58);
            }
        }
    public void clawServoActions(String pos) {
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
    public void claw_pivot(double pos){
        MClaw.setPosition(pos);
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
            LAL_motor.setTargetPosition(-1010);
            LAR_motor.setTargetPosition(1010);
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
        if (posType == "drag block"){
            MClaw.setPosition(0.58);
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
        if (posType == "Crest"){
            MClaw.setPosition(1);
            LAL_motor.setTargetPosition(-0);
            LAR_motor.setTargetPosition(0);
            LAL_motor.setPower(1);
            LAR_motor.setPower(-1);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (posType == "wall") {
            MClaw.setPosition(0.58);
            LAL_motor.setTargetPosition(-946);
            LAR_motor.setTargetPosition(953);
            LAL_motor.setPower(0.6);
            LAR_motor.setPower(-0.6);
            LAL_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LAR_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if(posType == "specimen"){
            LAL_motor.setTargetPosition(-85);
            LAR_motor.setTargetPosition(44);
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
            LA_motor.setTargetPosition(-3346);
            LA_motor.setPower(1);
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
            LA_motor.setTargetPosition(-2100);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (height == "front high chamber"){
            LA_motor.setTargetPosition(-500);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (height == "zero"){
            LA_motor.setTargetPosition(0);
            LA_motor.setPower(1);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (height == "hang"){
            LA_motor.setTargetPosition(-1005);
            LA_motor.setPower(0.8);
            LA_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
    }
}






