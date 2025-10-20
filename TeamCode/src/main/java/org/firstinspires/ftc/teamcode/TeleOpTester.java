package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class TeleOpTester extends LinearOpMode
{
    /*


   JACOB'S CODE - MEANT AS A REFERENCE, NOT AS WORKING DIRECTORY CODE


    */
    Drivetrain dt = new Drivetrain();
    Spindexer spin = new Spindexer();

    @Override
    public void runOpMode()
    {
        dt.init(hardwareMap);
        spin.init(hardwareMap);

        double leftStickX1 = gamepad1.left_stick_x;
        double leftStickY1 = gamepad1.left_stick_y;
        double rightStickX1 = gamepad1.right_stick_x;

        waitForStart();
        while (opModeIsActive())
        {
//            dt.FieldOrientedTranslate(leftStickX1,leftStickY1,rightStickX1,);
        }
    }
}