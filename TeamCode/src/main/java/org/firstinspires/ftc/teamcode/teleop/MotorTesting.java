package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "testing")
@Disabled
public class MotorTesting extends OpMode {
    DcMotor testMotor;
    @Override
    public void init() {
        testMotor = hardwareMap.get(DcMotor.class,"test");
    }

    @Override
    public void loop() {
        if (gamepad1.right_bumper){
            testMotor.setPower(1);
        }
        if (gamepad1.left_bumper){
            testMotor.setPower(-1);
        }
        testMotor.setPower(0);
    }
}
