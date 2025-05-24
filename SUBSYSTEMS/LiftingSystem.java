package org.firstinspires.ftc.teamcode.SUBSYSTEMS;
import com.acmerobotics.dashboard.FtcDashboard;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.robotcore.external.Telemetry;
/*
    --------------------------------------

                  !WARNING!

           THIS CODE IS UNUSED IN
           ANY OF THE OTHER OPS
             AND MAY NOT WORK
    --------------------------------------
 */
public class LiftingSystem  {
    // variable declaration
    private PIDController controller;
    public static double p = 0, i = 0, d = 0;
    private DcMotor LiftLeft;
    private DcMotor LiftRight;
    private FtcDashboard dashboard;
    private Telemetry.Item LiftLeftPosition;
    private Telemetry.Item LiftRightPosition;

    public LiftingSystem(HardwareMap hardwareMap,Telemetry telemetry) {

        // Motor Configuration
        LiftLeft = hardwareMap.dcMotor.get("LiftLeft");
        LiftRight = hardwareMap.dcMotor.get("LiftRight");


        LiftRight.setDirection(DcMotor.Direction.REVERSE);
        LiftLeft.setDirection(DcMotor.Direction.REVERSE);

        LiftLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LiftRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LiftLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LiftRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        LiftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LiftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Setting PID controller via External Controler
        controller = new PIDController(p, i, d);


        // Telementry
        LiftLeftPosition = telemetry.addData("Left Lift Position", LiftLeft.getCurrentPosition());
        LiftRightPosition = telemetry.addData("Right Lift Position", LiftRight.getCurrentPosition());
        LiftLeftPosition.setValue(LiftLeft.getCurrentPosition());
        telemetry.update();

    }

    public void runOpMode(boolean G2a,boolean G2b,boolean G2x,boolean G2y,Telemetry telemetry) throws InterruptedException {
// Setting the target position for the lift

        int LiftTarget = 0;


        if (G2a) {
            LiftTarget = 100;
        } else if (G2b) {
            LiftTarget = 0;
        } else if (G2x) {
            LiftTarget = 200;
        } else if (G2y) {
            LiftTarget = 300;
        }

        // Calculating and Setting the Power for the Lifg
        double LiftLeftError = LiftTarget - LiftLeft.getCurrentPosition();
        double LiftRightError = LiftTarget - LiftRight.getCurrentPosition();

        double LiftLeftPower = controller.calculate(LiftLeftError);
        double LiftRightPower = controller.calculate(LiftRightError);

        LiftLeft.setPower(LiftLeftPower);
        LiftRight.setPower(LiftRightPower);

        // Updating the Positions
        LiftLeftPosition.setValue(LiftLeft.getCurrentPosition());
        LiftRightPosition.setValue(LiftRight.getCurrentPosition());

        telemetry.update();
        // more telementry
        TelemetryPacket packet = new TelemetryPacket();
        packet.put("Left Lift Position", LiftLeft.getCurrentPosition());
        packet.put("Right Lift Position", LiftRight.getCurrentPosition());
        packet.put("Target Position", LiftTarget);

        dashboard.sendTelemetryPacket(packet);


    }
}