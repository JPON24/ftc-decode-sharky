package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DriverControlled extends LinearOpMode
{
    // script references
    Drivetrain drive = new Drivetrain();
    Spindexer spindexer = new Spindexer();

    // runtime changing values
    double driveSpeed = 1.0;

    @Override
    public void runOpMode()
    {
        drive.init(hardwareMap);
        spindexer.init(hardwareMap);

        waitForStart();
        while (opModeIsActive())
        {


        }
    }
}
