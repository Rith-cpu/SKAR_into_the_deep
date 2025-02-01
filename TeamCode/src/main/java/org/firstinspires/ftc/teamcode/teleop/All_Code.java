package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOP")
public class TeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        LinearActuatorAndClaw linearActuatorAndClaw = new LinearActuatorAndClaw(hardwareMap);
        Drivetrain driveTrainControl = new Drivetrain(hardwareMap);
        SensorSparkFunOTOS sparkFunControl = new SensorSparkFunOTOS(hardwareMap);
        sparkFunControl.configureOtos(telemetry);
        telemetry.addLine("Akshay is a bum");
        telemetry.addLine("Samar is a bum");
        telemetry.addLine("Akshay is a bum");
        telemetry.addLine("Samar is a bum");
        telemetry.addLine("Akshay is a bum");
        telemetry.addLine("Samar is a bum");
        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("Left Motor Position", linearActuatorAndClaw.LAL_motor.getCurrentPosition());
            telemetry.addData("Right Motor Position", linearActuatorAndClaw.LAR_motor.getCurrentPosition());
            telemetry.addData("Vertical Motor Position", linearActuatorAndClaw.LA_motor.getCurrentPosition());

            driveTrainControl.driving(gamepad1);
            linearActuatorAndClaw.clawServoActions(gamepad2);
            linearActuatorAndClaw.linearActuatorVert(gamepad2);
            linearActuatorAndClaw.linearActuatorMove(gamepad2, telemetry);
            sparkFunControl.OTOS(gamepad1,telemetry);
        }
    }
}
