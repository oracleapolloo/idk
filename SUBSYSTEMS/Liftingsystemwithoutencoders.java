package org.firstinspires.ftc.teamcode.SUBSYSTEMS;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Liftingsystemwithoutencoders {
    // Declaring Variables
    private DcMotor leftlift;
    private DcMotor rightlift;


    public Liftingsystemwithoutencoders(HardwareMap hardwareMap) {

        // Configuring Motors
        leftlift = hardwareMap.get(DcMotor.class, "leftlift");
        rightlift = hardwareMap.get(DcMotor.class, "rightlift");

        leftlift.setDirection(DcMotor.Direction.FORWARD);
        rightlift.setDirection(DcMotor.Direction.FORWARD);

    }

    public void lift(double g2leftsick) {

        double leftpower;
        leftpower = -g2leftsick;
        // Setting Powers

        if (leftpower > 0) {

            leftlift.setPower(leftpower);
            rightlift.setPower(leftpower);

        }
        else if (leftpower < 0) {

            leftlift.setPower(leftpower);
            rightlift.setPower(leftpower);

        }

        else{
            leftlift.setPower(0);
            rightlift.setPower(0);
        }


    }

}