package org.firstinspires.ftc.teamcode.SUBSYSTEMS;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw{
    DcMotor motor;
//    double ticks = 288;
    double newTarget;
    // Variable Declaration

    public Claw(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "claw");
        motor.setDirection(DcMotor.Direction.REVERSE);
        // Motor Configuration
//        telemetry.addData("Hardware: ", "Initialized");
//        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

//    public void clawclass(boolean g2a, boolean g2b, Telemetry telemetry) {
//        if (g2a) {
//            encoder(3);
//        }
//        telemetry.addData("Motor Ticks: ", motor.getCurrentPosition());
//        if (g2b) {
//            goback();
//        }
//
//    }

//    public void encoder(int turnage) {
//        newTarget = ticks / turnage;
//        motor.setTargetPosition((int) newTarget);
//        motor.setPower(0.3);
//        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }

//    public void goback() {
//        motor.setTargetPosition(0);
//        motor.setPower(0.3);
//        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }

    public void clawDownAndUp( double power){
        motor.setPower(power);
    }
    public void stop(){
        motor.setPower(0);
    }

    //Manual contorol for the claw

}