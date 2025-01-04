package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOP")
public class All_Code extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        LinearActuatorAndClaw Controler2 = new LinearActuatorAndClaw(hardwareMap);
        Drivetrain Controler1 = new Drivetrain(hardwareMap);
        SensorSparkFunOTOS Controler = new SensorSparkFunOTOS(hardwareMap);
        Controler.configureOtos(telemetry);
        Led_lights control = new Led_lights(hardwareMap);


        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("Left Motor Position", Controler2.LAL_motor.getCurrentPosition());
            telemetry.addData("Right Motor Position", Controler2.LAR_motor.getCurrentPosition());
            telemetry.addData("Vertical Motor Position", Controler2.LA_motor.getCurrentPosition());

            Controler1.Driving(gamepad1);
            Controler2.claw_servo(gamepad1);
            Controler2.LA_Vert(gamepad1,gamepad1);
            Controler2.LA_move(gamepad1,gamepad1, telemetry);
            Controler.OTOS(gamepad1,telemetry);
            control.LED_pattern(Controler2.LA_motor.getCurrentPosition());

        }
    }
}