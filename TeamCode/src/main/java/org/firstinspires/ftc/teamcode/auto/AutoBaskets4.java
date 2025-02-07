package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ProfileAccelConstraint;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.teleop.LinearActuatorAndClaw;
import org.firstinspires.ftc.teamcode.teleop.LinearActuatorAndClaw223RPM;
import org.firstinspires.ftc.teamcode.tuning.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.tuning.TuningOpModes;

@Autonomous(name = "AutoBaskets4")
public class AutoBaskets4 extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        LinearActuatorAndClaw arm = new LinearActuatorAndClaw(hardwareMap);

        if (TuningOpModes.DRIVE_CLASS.equals(SparkFunOTOSDrive.class)) {

            SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, new Pose2d(-64, 36, 0));

            arm.clawServoActions("close");

            waitForStart();

            FirstBlock(drive, arm);

            SecondBlock(drive, arm);

            ThirdBlock(drive, arm);

            FourthBlock(drive, arm);

            Park(drive, arm);

        }
    }

    private void FirstBlock(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {

        arm.armVert("top basket");
        Pose2d position = new Pose2d(-64, 36, 0);

        Actions.runBlocking(
                drive.actionBuilder(position)
                        .strafeTo(new Vector2d(-45, 40), new TranslationalVelConstraint(90), new ProfileAccelConstraint(-90, 90))
                        .turn(Math.toRadians(-32))
                        .strafeTo(new Vector2d(-46, 44), new TranslationalVelConstraint(90), new ProfileAccelConstraint(-20, 90))
                        .build());
        arm.clawServoActions("super open");
        sleep(300);
        Pose2d pos3 = new Pose2d(-46, 44, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(pos3)
                        .strafeTo(new Vector2d(-43,40),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.armVert("zero");
        sleep(900);
    }
    private void SecondBlock(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {
        Pose2d position = new Pose2d(-46, 46, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .turn(Math.toRadians(32))
                        .strafeTo(new Vector2d(-52,45),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.armPivot("pick up");
        sleep(800);
        arm.clawServoActions("close");
        sleep(600);
        arm.armPivot("Crest");
        arm.armVert("top basket");
        sleep(300); // 500
        Pose2d pos2 = new Pose2d(-52, 45, 0);
        Actions.runBlocking(
                drive.actionBuilder(pos2)
                        .strafeTo(new Vector2d(-43,40),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .turn(Math.toRadians(-32))
                        .strafeTo(new Vector2d(-46, 44), new TranslationalVelConstraint(90), new ProfileAccelConstraint(-20, 90))
                        .build());
        arm.clawServoActions("super open");
        sleep(300);
        Pose2d pos3 = new Pose2d(-46, 44, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(pos3)
                        .strafeTo(new Vector2d(-43,40),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.armVert("zero");
        sleep(700);

    }
    private void ThirdBlock(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {

        Pose2d position = new Pose2d(-43, 40, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .turn(Math.toRadians(32))
                        .strafeTo(new Vector2d(-53,52),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.armPivot("pick up");
        sleep(800);
        arm.clawServoActions("close");
        sleep(600);
        arm.armPivot("Crest");
        arm.armVert("top basket");
        sleep(300);
        Pose2d pos2 = new Pose2d(-53, 52, 0);
        Actions.runBlocking(
                drive.actionBuilder(pos2)
                        .strafeTo(new Vector2d(-43,40),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .turn(Math.toRadians(-32))
                        .strafeTo(new Vector2d(-46, 44), new TranslationalVelConstraint(90), new ProfileAccelConstraint(-20, 90))
                        .build());
        arm.clawServoActions("super open");
        sleep(200);
        Pose2d pos3 = new Pose2d(-46, 44, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(pos3)
                        .strafeTo(new Vector2d(-43,40),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.clawServoActions("super open");
        arm.armVert("zero");
        sleep(700);
    }
    private void FourthBlock(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {
        Pose2d position = new Pose2d(-43, 40, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .turn(Math.toRadians(52))
                        .build());
        arm.armPivot("hover");
        Pose2d pos4 = new Pose2d(-43, 40, Math.toRadians(24));
        Actions.runBlocking(
                drive.actionBuilder(pos4)
                        .strafeTo(new Vector2d(-54.7,54),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.armPivot("pick up");
        sleep(800);
        arm.clawServoActions("close");
        sleep(600);
        arm.armPivot("Crest");
        arm.armVert("top basket");
        sleep(300);
        Pose2d pos2 = new Pose2d(-54.7, 54, Math.toRadians(24));
        Actions.runBlocking(
                drive.actionBuilder(pos2)
                        .strafeTo(new Vector2d(-43,40),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .turn(Math.toRadians(-52))
                        .strafeTo(new Vector2d(-46, 44), new TranslationalVelConstraint(90), new ProfileAccelConstraint(-20, 90))
                        .build());
        arm.clawServoActions("super open");
        sleep(200);
        Pose2d pos3 = new Pose2d(-46, 44, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(pos3)
                        .strafeTo(new Vector2d(-43,40),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.armVert(-934,1.0);

    }
    private void Park(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {
        Pose2d position = new Pose2d(-43, 40, Math.toRadians(-32));
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .strafeToSplineHeading(new Vector2d(-9,7),Math.toRadians(-100),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.armPivot("vertical");
        sleep(1000);


    }

}
