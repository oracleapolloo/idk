package org.firstinspires.ftc.teamcode.SUBSYSTEMS;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/*
  ----------------------------------------------------------------
                        UNSUSED TEST CODE
  ----------------------------------------------------------------
 */

@TeleOp(name = "ServoDoorTest",group = "LinearOpMode")
public class ServoDoor extends LinearOpMode {
    public Servo leftServo;
    // Setting Variables
    @Override
    public void runOpMode(){
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        // Setting Servos
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("triggerval",gamepad2.left_trigger);
            telemetry.addData("servpos",leftServo.getPosition());
            telemetry.update();
            // Posisiton Testing
            while(gamepad2.left_bumper){
                leftServo.setPosition(1);

            }
            while(gamepad2.left_trigger > 0.0){

                leftServo.setPosition(0);


            }
        }
    }


}
