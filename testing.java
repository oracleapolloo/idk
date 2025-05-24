package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

//import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Claw;
import org.firstinspires.ftc.teamcode.SUBSYSTEMS.Door;
import org.firstinspires.ftc.teamcode.SUBSYSTEMS.LiftSystemGreece;


@TeleOp(name = "MainOpMode2", group = "Linear Opmode")
public class testing extends LinearOpMode {

    private  DcMotorEx liftMotor1;
    private DcMotorEx liftMotor2;


    @Override
    public void runOpMode() throws InterruptedException {
        liftMotor1 = hardwareMap.get(DcMotorEx.class, "ll");
        liftMotor2 = hardwareMap.get(DcMotorEx.class, "rl");

        liftMotor1.setDirection(DcMotorEx.Direction.FORWARD);
        liftMotor2.setDirection(DcMotorEx.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

                liftMotor1.setPower(gamepad2.left_stick_y/5);
                liftMotor2.setPower(gamepad2.left_stick_y/5);




        }
    }
}