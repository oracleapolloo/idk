package org.firstinspires.ftc.teamcode.SUBSYSTEMS;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Door {
    // Setting Servo to Servo Mode
    // Variable declaration
    public Servo servomotor1;
    public Servo servomotor2;


    public Door(HardwareMap hardwareMap) {
// Servo configuration
        servomotor1 = hardwareMap.get(Servo.class, "door1");
        servomotor2 = hardwareMap.get(Servo.class, "door2");

        servomotor1.setDirection(Servo.Direction.REVERSE);




    }

    public void servo(boolean GP2lb, boolean GP2rb, double GP2lt, double GP2rt) {
// Using set positions for the Servos. We used custom positions instead of setting them on the
 // SRS because our range of motion is too small to set them via the SRS

        if (GP2lb) {
            servomotor1.setPosition(0.09);
        }
        else if(GP2lt !=0) {
            servomotor1.setPosition(0.42 );
        }
        if (GP2rb) {
            servomotor2.setPosition(0);
        }
        else if (GP2rt != 0) {
            servomotor2.setPosition(0.5);
        }


    }

}

