package org.firstinspires.ftc.teamcode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
@TeleOp(name = "Override")
public class LA_PosOverride extends OpMode {

    public DcMotor LA_motor, LAR_motor, LAL_motor;
    double ticks = 537.7;
    double position = 0;
    int countVert = 0;
    int countPivot = 0;
    int countTouchVert = 0;
    int countTouchPivot = 0;
    LinearOpMode opMode;

    @Override
    public void init() {
        LA_motor = hardwareMap.get(DcMotor.class, "LA_motor");
        LAL_motor = hardwareMap.get(DcMotor.class, "Left_LA");
        LAR_motor = hardwareMap.get(DcMotor.class, "Right_LA");
    }

    @Override
    public void loop() {
        LAL_motor.setPower(0.7);
        LAR_motor.setPower(-0.7);
        LA_motor.setPower(0.7);
    }
}





