package org.firstinspires.ftc.teamcode.SUBSYSTEMS;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drivetrain {
    // Variable Declaration
    Telemetry telemetry;
    private DcMotor leftfrontdrive = null;
    private DcMotor rightfrontdrive = null;
    private DcMotor leftbackdrive = null;
    private DcMotor rightbackdrive = null;
    private double speedmodifier = 1;
    

    public Drivetrain(HardwareMap hardwareMap) {
        // Configuring the Motors
        leftfrontdrive = hardwareMap.get(DcMotor.class, "lfd");
        rightfrontdrive = hardwareMap.get(DcMotor.class, "rfd");
        rightbackdrive = hardwareMap.get(DcMotor.class, "rbd");
        leftbackdrive = hardwareMap.get(DcMotor.class, "lbd");

        leftfrontdrive.setDirection(DcMotor.Direction.FORWARD);
        leftbackdrive.setDirection(DcMotor.Direction.FORWARD);
        rightfrontdrive.setDirection(DcMotor.Direction.FORWARD);
        rightbackdrive.setDirection(DcMotor.Direction.FORWARD);


    }

    public void drive(double leftstick, double rightstick, boolean trigger1, boolean trigger2) {

        // Adding a SpeedModifier to contol the speed.
        // We made it so when you turn the robot it goes on full speed
        // The commented part is if the drivers want a faster 1 wheel turn

        if (trigger1) {
            if ((leftstick > 0.1 && rightstick < -0.1) || (leftstick < 0.1 && rightstick > -0.1)) {
                speedmodifier = 1.5;
//            } else if ((leftstick != 0 && rightstick == 0 )|| (leftstick == 0 && rightstick != 0)) {
//                speedmodifier = 1.5f;
            } else {
                speedmodifier = 2.5; // 60% speed decrease
            }
        } else if (trigger2) {
            if ((leftstick > 0.1 && rightstick < -0.1) || (leftstick < -0.1 && rightstick > 0.1)) {
                speedmodifier = 1;
//            } else if ((leftstick != 0 && rightstick == 0 )|| (leftstick == 0 && rightstick != 0)) {
//                speedmodifier = 1f;

            }else {
                speedmodifier = 1.7; // 45% speed decrease
            }

        } else {
            speedmodifier = 1.0;
        }

        double drive = rightstick;
        double turn = -leftstick;
        // Setting the motor powers.
        // This is a Tank Drivesystem
        leftfrontdrive.setPower(turn / speedmodifier);
        leftbackdrive.setPower(turn / speedmodifier);
        rightfrontdrive.setPower(drive / speedmodifier);
        rightbackdrive.setPower(drive / speedmodifier);
    }
}