package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "Linear Actuator Position Measurements")
@Disabled
public class LA_Motor_Pos extends OpMode {

    DcMotor actuatorleft_motor;
    DcMotor actuatorright_motor;
    DcMotor actuator;
    private Servo claw = null;

    @Override
    public void init() {
        // Initialize motor
        actuatorleft_motor = hardwareMap.get(DcMotor.class, "Left_LA");
        actuatorleft_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        actuatorleft_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        actuatorright_motor = hardwareMap.get(DcMotor.class, "Right_LA");
        actuatorright_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        actuatorright_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        actuator = hardwareMap.get(DcMotor.class, "LA_motor");
        actuator.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        actuator.setMode((DcMotor.RunMode.STOP_AND_RESET_ENCODER));
        claw = hardwareMap.get(Servo.class, "Claw");


    }

    @Override
    public void loop() {
        int leftposition = actuatorleft_motor.getCurrentPosition();
        int actPosition = actuator.getCurrentPosition();
        int rightPosition = actuatorright_motor.getCurrentPosition();

        telemetry.addData("Left Motor Position", leftposition);
        telemetry.addData("Right Motor Position", rightPosition);
        telemetry.addData("Vertical Motor Position", actPosition);

    }
}
