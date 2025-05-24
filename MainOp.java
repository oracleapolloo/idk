package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Claw;
import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Door;
import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Drivetrain;
import org.firstinspires.ftc.teamcode.SUBSYSTEMS.LiftSystemGreece;

@TeleOp(name = "MainOpMode", group = "Linear Opmode")
public class  MainOp extends LinearOpMode {

    private Drivetrain drivetrain;
    private Claw clawclass;
    // Initialization of the Variables

    private LiftSystemGreece liftSystem;
    private Door dooor;
    private static final int POSITION0 = 0;
    private static final int POSITION1 = 5750;
    private static final int POSITION2 = 7215;
    private static final int POSITION3 = 8850;



    @Override
    public void runOpMode() throws InterruptedException {

        // Declaring Objects / SubSystems
        liftSystem = new LiftSystemGreece(hardwareMap);
        dooor = new Door(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
        clawclass = new Claw(hardwareMap);




        waitForStart();

        while (opModeIsActive()) {
// Setting up the Door and Their Controls with SDK funcitons
            dooor.servo(gamepad2.left_bumper,gamepad2.right_bumper,gamepad2.left_trigger,gamepad2.right_trigger);
            // Settingup Drivetrain and adding all the SDK function
            drivetrain.drive(gamepad1.left_stick_y, gamepad1.right_stick_y,gamepad1.left_bumper,gamepad1.right_bumper);

            if (gamepad2.a) {
                liftSystem.moveLiftToPosition(POSITION1, 0.95);
            }
            else if (gamepad2.b) {
                liftSystem.moveLiftToPosition(POSITION2, 0.95);
            } else if (gamepad2.y) {
                liftSystem.moveLiftToPosition(POSITION3, 0.95);
            }
            else if (gamepad2.x) {
                liftSystem.moveLiftToPosition(POSITION0,1);
            }
            else if (gamepad2.left_stick_y > 0.15 || gamepad2.left_stick_y < 0.15) {
                // Manual control using the left stick
                double liftPower = -gamepad2.left_stick_y; // Invert if necessary
                liftSystem.moveLift(liftPower);
            }  else {
                liftSystem.stop();
            }
            liftSystem.getCurrentPosition();
            // lifting system Controls
            if (gamepad2.dpad_left){
                clawclass.clawDownAndUp(0.5);
            } else if (gamepad2.dpad_right) {
                clawclass.clawDownAndUp(-0.5);
            }
            else {
                clawclass.stop();
            }

            telemetry.addData("left", liftSystem.getCurrentPosition());
            telemetry.addData("Left Stick", gamepad1.left_stick_y);
            telemetry.addData("triggertest", gamepad2.left_trigger);
            telemetry.addData("bumpper test", gamepad2.left_bumper);
            telemetry.update();
            // Telementry

//            dooor.door(gamepad2.right_bumper,gamepad2.left_bumper, telemetry);
//            telemetry.addData("TargetPos",liftSystem.targetPosition);
//            telemetry.update();


        }
    }
}