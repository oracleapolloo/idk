package org.firstinspires.ftc.teamcode.SUBSYSTEMS;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class  LiftSystemGreece {
    // Declaring Varialbes
    private final DcMotorEx liftMotor1;
    private DcMotorEx liftMotor2;
    private static final double STOP_POWER = 0.0;


    private PIDFCoefficients pidf;
    public static double p=11,i=0,d=0,f=0;
    public double targetPosition = 0;


    public LiftSystemGreece(HardwareMap hardwareMap) {
// Configuring Motors and Enabling the encoders
        pidf = new PIDFCoefficients(p, i, d, f);

        liftMotor1 = hardwareMap.get(DcMotorEx.class, "ll");
        liftMotor2 = hardwareMap.get(DcMotorEx.class, "rl");

        liftMotor1.setDirection(DcMotorEx.Direction.REVERSE);
        liftMotor2.setDirection(DcMotorEx.Direction.FORWARD);

        liftMotor1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        liftMotor1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        liftMotor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        liftMotor1.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        liftMotor2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        liftMotor1.setPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, pidf);
        liftMotor2.setPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, pidf);


    }

    public void moveLiftToPosition(int targetPosition, double power) {
        // Uses Encoders for set positions
        liftMotor1.setTargetPosition(targetPosition);
        liftMotor2.setTargetPosition(targetPosition);

        liftMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        liftMotor1.setPower(power);
        liftMotor2.setPower(power);

    }
    // Manual Movement
    public void moveLift(double power){

        liftMotor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        liftMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        liftMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        liftMotor1.setPower(power);
        liftMotor2.setPower(power);

    }
    // Stopping motors
    public void stop() {
        liftMotor1.setPower(STOP_POWER);
        liftMotor2.setPower(STOP_POWER);

    }

    public int getCurrentPosition() {
        try {
            return (liftMotor1.getCurrentPosition() + liftMotor2.getCurrentPosition()) / 2;
        } catch (Exception e) {
            // Handle position retrieval errors
            e.printStackTrace();
            return 0;
        }
    }

//    public void moveLift(double power, Telemetry telemetry) {
//
////        liftMotor2.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
////        if (power > 0.1 || power < -0.1) {
////            targetPosition = targetPosition + power*3;
//            liftMotor1.setPower(0.9);
//            liftMotor2.setPower(0.9);
//            liftMotor1.setTargetPosition((int) targetPosition);
//            liftMotor2.setTargetPosition((int) targetPosition);
//            liftMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            liftMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            telemetry.addData("Ticks: ", liftMotor1.getCurrentPosition());
//            telemetry.addData("Ticks: ", liftMotor2.getCurrentPosition());
//
//            telemetry.update();
//
//
//
//
//
//    }
}