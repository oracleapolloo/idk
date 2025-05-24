
package org.firstinspires.ftc.teamcode.SUBSYSTEMS;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DrivetrainKzh {
Telemetry telemetry;
    //variable declatration
    private DcMotor leftfrontdrive = null;
    private DcMotor rightfrontdrive = null;
    private DcMotor leftbackdrive = null;
    private DcMotor rightbackdrive = null;



    public DrivetrainKzh(HardwareMap hardwareMap) {
//Motor Configuration
        leftfrontdrive = hardwareMap.get(DcMotor.class, "lfd");
        rightfrontdrive = hardwareMap.get(DcMotor.class, "rfd");
        rightbackdrive = hardwareMap.get(DcMotor.class, "rbd");
        leftbackdrive = hardwareMap.get(DcMotor.class, "lbd");


        leftfrontdrive.setDirection(DcMotor.Direction.REVERSE);
        leftbackdrive.setDirection(DcMotor.Direction.REVERSE);
        rightfrontdrive.setDirection(DcMotor.Direction.FORWARD);
        rightbackdrive.setDirection(DcMotor.Direction.FORWARD);



    }

    public void drive(double leftstick, double rightstick) {

// Tank Drivesystem
        double drive = rightstick;
        double turn = leftstick*-1;

        leftfrontdrive.setPower(turn/1.5);
        leftbackdrive.setPower(turn/1.5);
        rightfrontdrive.setPower(drive/1.5);
        rightbackdrive.setPower(drive/1.5);


    }

}






