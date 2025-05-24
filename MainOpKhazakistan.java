//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Claw;
//import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Door;
//
//import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Drivetrain;import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Liftingsystemwithoutencoders;
//
//
//@TeleOp(name = "MainOpModeCA", group = "Linear Opmode")
//public class MainOpKhazakistan extends LinearOpMode {
//
//    private Drivetrain drivetrain;
//    private Liftingsystemwithoutencoders liftingsystem;
//    private Claw claw;
//
//    private Door door;
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//
//        drivetrain = new Drivetrain(hardwareMap);
//        liftingsystem = new Liftingsystemwithoutencoders(hardwareMap);
//        claw = new Claw(hardwareMap, telemetry);
//        door = new Door(hardwareMap, telemetry);
//
//        waitForStart();
//
//        while (opModeIsActive()) {
//            drivetrain.drive(-gamepad1.left_stick_y, gamepad1.right_stick_x);
//            liftingsystem.lift(gamepad2.left_stick_y);
//            claw.clawclass(gamepad2.a, gamepad2.b, telemetry);
//            door.door(gamepad2.y, gamepad2.x, telemetry);
//            telemetry.addData("Left Stick", gamepad1.left_stick_y);
//            telemetry.update();
//        }
//    }
//}