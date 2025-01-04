//package org.firstinspires.ftc.teamcode.Autonomous;
//
//import com.acmerobotics.roadrunner.Pose2d;
//import com.acmerobotics.roadrunner.TranslationalVelConstraint;
//import com.acmerobotics.roadrunner.Vector2d;
//import com.acmerobotics.roadrunner.ftc.Actions;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//
//import org.firstinspires.ftc.teamcode.OtosStuff.SparkFunOTOSDrive;
//import org.firstinspires.ftc.teamcode.teleop.LinearActuatorAndClaw;
//import org.firstinspires.ftc.teamcode.OtosStuff.tuning.TuningOpModes;
//@Disabled
//@Autonomous(name = "AutoBaskets")
//public class AutoBaskets extends LinearOpMode {
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//
//
//        Pose2d firstPose = new Pose2d(-66, 30, Math.toRadians(90));
//        Pose2d secondPose = new Pose2d(-48, 46, Math.toRadians(135));
//        Pose2d thirdPose = new Pose2d(-50, 44.5, Math.toRadians(0));
//        Pose2d fourthPose = new Pose2d(-45, 40, Math.toRadians(0));
//        Pose2d fifthPose = new Pose2d(-63, 42, Math.toRadians(-225));
//        Pose2d sixthPose = new Pose2d(-43, 48, Math.toRadians(-135));
//        Pose2d seventhPose = new Pose2d(-62, 42, Math.toRadians(270));
//
//        int count = 0;
//        if (TuningOpModes.DRIVE_CLASS.equals(SparkFunOTOSDrive.class)) {
//            SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, firstPose);
//
//
//            LinearActuatorAndClaw arm = new LinearActuatorAndClaw(hardwareMap);
//            count = 0;
//            arm.claw_servo("close");
//            waitForStart();
//
//
//            arm.armPivot("vertical");
//            arm.armVert("top basket");
//            while (count == 0) {
//                Actions.runBlocking(
//                        drive.actionBuilder(firstPose)
//                                .strafeTo(new Vector2d(-59, 32))
//                                .turn(Math.toRadians(45))
//                                .splineToConstantHeading(new Vector2d(-63, 37), Math.toRadians(45), new TranslationalVelConstraint(20))
//                                .build());
//                count++;
//            }
//            arm.claw_servo("super open");
//            sleep(500);
//            arm.armPivot("Basket Back");
//
//            while (arm.LAR_motor.isBusy()) {
//                arm.armVert(0, 1);
//            }
//            Actions.runBlocking(
//                    drive.actionBuilder(secondPose)
//                            //.strafeTo(new Vector2d(-53,41))
//                            .strafeTo(new Vector2d(-50, 35), new TranslationalVelConstraint(30))
//                            .turn(Math.toRadians(-135))
//                            //  .strafeTo(new Vector2d(-45, 42))
//                            .build());
//
//            count++;
//
//            while (count == 2) {
//                //  sleep(2000);
//                arm.armPivot("hover");
//                count++;
//            }
//
//
//            Actions.runBlocking(
//                    drive.actionBuilder(thirdPose)
//                            .strafeTo(new Vector2d(-42, 42), new TranslationalVelConstraint(30))
//                            .build());
//            count++;
//
//            arm.armPivot("pick up");
//            sleep(300);
//            arm.claw_servo("close");
//            sleep(800);
//            arm.armPivot("vertical");
//            count++;
//            arm.armVert("top basket");
//
//            while (count == 5) {
//                Actions.runBlocking(
//                        drive.actionBuilder(fourthPose)
//                                .strafeTo(new Vector2d(-45, 30))
//                                .turn(Math.toRadians(135))
//                                .splineToConstantHeading(new Vector2d(-57, 38), Math.toRadians(-225), new TranslationalVelConstraint(30))
//                                .build());
//                count++;
//            }
//            telemetry.addLine("at basket for second time");
//            telemetry.update();
//            arm.claw_servo("super open");
//            sleep(500);
//            arm.armPivot("Basket Back");
//            while (arm.LAR_motor.isBusy()) {
//                arm.armVert(0, 1);
//            }
//
//                    Actions.runBlocking(
//                            drive.actionBuilder(fifthPose)
//                                    .strafeTo(new Vector2d(-45, 35))
//                                    .turn(Math.toRadians(-135))
//                                    .strafeTo(new Vector2d(-39, 46))
//                                    .build());
//                    count++;
//
//                arm.armPivot("pick up");
//                sleep(800);
//                arm.claw_servo("close");
//                sleep(800);
//                arm.armPivot("vertical");
//                arm.armVert("top basket");
//                // sleep(5000);
//
//
//                    Actions.runBlocking(
//                            drive.actionBuilder(sixthPose)
//                                    .strafeTo(new Vector2d(-43, 25))
//                                    .strafeToSplineHeading(new Vector2d(-49, 41), Math.toRadians(-230), new TranslationalVelConstraint(20))
//                                    .build());
//
//                arm.claw_servo("super open");
//                sleep(600);
//                arm.armPivot("Basket Back");
//
//                while (arm.LAR_motor.isBusy()) {
//                    arm.armVert("zero");
//                    sleep(300);
//                    arm.armPivot("rest");
//                }
//                sleep(700);
////                while (arm.LA_motor.isBusy()) {
////                    Actions.runBlocking(
////                            drive.actionBuilder(seventhPose)
////                                    .splineToConstantHeading(new Vector2d(-5, 30), Math.toRadians(270), new TranslationalVelConstraint(40))
////                                    .strafeToSplineHeading(new Vector2d(0, 20), Math.toRadians(90))
////                                    .build());
////                }
////                sleep(1500);
//            }
//
//
//        }
//
//    }
//
//
