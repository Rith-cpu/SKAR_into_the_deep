package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ProfileAccelConstraint;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.TurnConstraints;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.OtosStuff.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.OtosStuff.tuning.TuningOpModes;
import org.firstinspires.ftc.teamcode.teleop.Led_lights;
import org.firstinspires.ftc.teamcode.teleop.LinearActuatorAndClaw;
import org.firstinspires.ftc.teamcode.teleop.SparkFunOTOS;


@Autonomous(name = "AutoSpecimens3")
public class AutoSpecimens3 extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        LinearActuatorAndClaw arm = new LinearActuatorAndClaw(hardwareMap);
        Led_lights lights = new Led_lights(hardwareMap);

        if (TuningOpModes.DRIVE_CLASS.equals(SparkFunOTOSDrive.class)) {

            lights.LED_pattern(0);
            SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, new Pose2d(-70, -12, 0));

            arm.claw_servo("close");

            waitForStart();

            hangFirstSpecimen(drive, arm);

            getandhangSecondSpecimen(drive, arm);

            moveThirdBlockToHome(drive, arm);

            pickUpThirdSpecimen(drive, arm);

            hangThirdSpecimen(drive, arm);

            //goToObservationZone(drive,arm);

            pushandgoToObservationZone(drive,arm);
        }
    }

    private void hangFirstSpecimen(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {

        arm.armPivot(-375, 369, 0.5);
        arm.armVert("high chamber");
        Pose2d position = new Pose2d(-70, -12, 0);
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .splineTo(new Vector2d(-46.5, -12), 0, new TranslationalVelConstraint(100), new ProfileAccelConstraint(-20, 100))
                        .build());
        telemetry.addLine("x value -- " + position.position.x);
        telemetry.addLine("y value -- " + position.position.y);
        telemetry.update();
        int count = 0;
        while (count == 0) {
            arm.armVert(-1700, 1);
            count++;
        }

        while (count == 1) {
            arm.armVert(0, 0.7);
            count++;
        }
        sleep(750);
        arm.claw_servo("open");
        arm.armVert("zero");
        //arm.armPivot("rest");
        //sleep(1500);

    }
    private void getandhangSecondSpecimen(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm){
        Pose2d position = new Pose2d(-46.5, -12, 0);
        Pose2d pos2 = new Pose2d(-62, -52, Math.toRadians(180));
        Pose2d pos3 = new Pose2d(-73, -52,Math.toRadians(180));
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .strafeTo(new Vector2d(-50, -12), new TranslationalVelConstraint(80), new ProfileAccelConstraint(-20, 70))
                        .strafeTo(new Vector2d(-62, -52),new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .turnTo(Math.toRadians(180),new TurnConstraints(100,-90,90))
                        .build());
        arm.armPivot("wall");

        Actions.runBlocking(
                drive.actionBuilder(pos2)
                        .strafeTo(new Vector2d(-73, -52), new TranslationalVelConstraint(10), new ProfileAccelConstraint(-9, 9))
                        .build());
        arm.claw_servo("close");
        sleep(600);
        arm.armVert("off wall");
        //sleep(200);
        arm.armPivot("vertical");
        sleep(400);
        arm.armVert("high chamber");
        Actions.runBlocking(
                drive.actionBuilder(pos3)
                        .splineTo(new Vector2d(-53, -8), 0, new TranslationalVelConstraint(100), new ProfileAccelConstraint(-100, 100))
                        .strafeTo(new Vector2d(-48, -8), new TranslationalVelConstraint(80),new ProfileAccelConstraint(-20,70))
                        .build());
        arm.armVert(0, 0.7);
        sleep(750);
        arm.claw_servo("open");
    }

    private void moveThirdBlockToHome(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {

        Pose2d position = new Pose2d(-49, -8, 0);
        arm.armVert(0, 0.7);
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .strafeTo(new Vector2d(-49, -38), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .strafeTo(new Vector2d(-20, -40), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .turnTo(Math.toRadians(180),new TurnConstraints(100,-90,90))
                        .strafeTo(new Vector2d(-23.5,-59), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .strafeTo(new Vector2d(-67, -59), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .strafeTo(new Vector2d(-60, -59), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .build());
        arm.claw_servo("open");

    }


    private void pickUpThirdSpecimen(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {

        Pose2d position = new Pose2d(-50, -55, Math.toRadians(180));
        sleep(500);
        arm.armPivot("wall");
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .strafeTo(new Vector2d(-72, -55), new TranslationalVelConstraint(50), new ProfileAccelConstraint(-9, 9))
                        .build());

        arm.claw_servo("close");
        sleep(500);
        arm.armVert("off wall");
        //sleep(200);
        arm.armPivot("vertical");
        arm.armVert("high chamber");
    }

    private void hangThirdSpecimen(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {

        Pose2d position = new Pose2d(-73, -55, Math.toRadians(180));
        telemetry.addLine("Start of hanging third specimen");
        telemetry.update();
        Actions.runBlocking(
                drive.actionBuilder(position)
                        .splineTo(new Vector2d(-53, -10), 0, new TranslationalVelConstraint(80), new ProfileAccelConstraint(-20, 70))
                        .strafeTo(new Vector2d(-46, -10))
                        .build());
        arm.armVert(0, 0.7);
        sleep(750);
        arm.claw_servo("open");

    }
    private void pushandgoToObservationZone(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm){

        Pose2d positionThree = new Pose2d(-46,-10,Math.toRadians(0));
        arm.armVert("zero");
        arm.armPivot("rest");
        Actions.runBlocking(
                drive.actionBuilder(positionThree)
                        .strafeTo(new Vector2d(-49, -47), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .strafeTo(new Vector2d(-22, -47), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .strafeTo(new Vector2d(-22, -59), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-90, 90))
                        .strafeTo(new Vector2d(-60,-59), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-100, 100))
                        .build());
        //sleep(1000);
    }

    private void goToObservationZone(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm){

        Pose2d positionThree = new Pose2d(-49,-8,Math.toRadians(0));
        arm.armVert("zero");
        arm.armPivot("rest");
        Actions.runBlocking(
                drive.actionBuilder(positionThree)
                        .strafeTo(new Vector2d(-74,-57), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-100, 100))
                        //.strafeTo(new Vector2d(-75,-57), new TranslationalVelConstraint(100), new ProfileAccelConstraint(-100, 100))
                        .build());
        //sleep(1000);
    }
    /*private void pickUpThirdSpecimen(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {
        //coming back to home area to pick third block
        telemetry.addLine("coming back to home area to pick third block");
        telemetry.update();
        Pose2d position = new Pose2d(-48, -9, Math.toRadians(0));

        Actions.runBlocking(
                drive.actionBuilder(position)
                        .strafeTo(new Vector2d(-55, -9), new TranslationalVelConstraint(80), new ProfileAccelConstraint(-60, 60))
                        .strafeToLinearHeading(new Vector2d(-45, -55), Math.toRadians(180), new TranslationalVelConstraint(80), new ProfileAccelConstraint(-60, 60))
                        .build());

        arm.claw_servo("super open");
        arm.armPivot(-1100, 1111, 0.5);
        sleep(1000);

        arm.armPivot(-1195, 1207, 0.5);

    }

    private void hangThirdSpecimen(SparkFunOTOSDrive drive, LinearActuatorAndClaw arm) {

        Pose2d positionOne = new Pose2d(-60, -55, Math.toRadians(180));


        Actions.runBlocking(
                drive.actionBuilder(positionOne)
                        .strafeToConstantHeading(new Vector2d(-67.5, -55), new TranslationalVelConstraint(3), new ProfileAccelConstraint(-2, 2))
                        .build());

        arm.claw_servo("close");
        sleep(500);

        arm.armPivot(-375, 369, 0.5);
        sleep(500);

        // hang the third specimen
        Pose2d positionTwo = new Pose2d(-67.5, -55, Math.toRadians(180));

        arm.armVert(-2150, 1);
        sleep(500);

        telemetry.addLine("trying to raise the la");
        telemetry.update();


        Actions.runBlocking(
                drive.actionBuilder(positionTwo)
                        .splineTo(new Vector2d(-52, -9), 0)
                        .strafeTo(new Vector2d(-48, -9))
                        .build());

        telemetry.addLine("In count 7 while loop");
        telemetry.update();


        arm.armVert(-1700, 0.8);
        arm.armVert(0, 0.7);

        arm.claw_servo("open");

        telemetry.addLine("Autonomous:Specimens Complete!");
        telemetry.update();

    }*/


}






