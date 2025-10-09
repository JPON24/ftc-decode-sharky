package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class DriverControlled extends LinearOpMode
{
    // script references
//    Drivetrain drive = new Drivetrain();
//    Spindexer spindexer = new Spindexer();

    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;


    // runtime changing values
    double driveSpeed = 1.0;

    @Override
    public void runOpMode()
    {
//        drive.init(hardwareMap);
//        spindexer.init(hardwareMap);

        frontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        backLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        backRight = hardwareMap.get(DcMotor.class, "BackRight");

        waitForStart();
        while (opModeIsActive())
        {
            double leftStickX = gamepad1.left_stick_x;
            double leftStickY = -gamepad1.left_stick_y;
            double rightStickX = gamepad1.right_stick_x;
            double buddy = Math.max(Math.abs(leftStickX) + Math.abs(leftStickY) + Math.abs(rightStickX), 1);
            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            backLeft.setDirection(DcMotor.Direction.REVERSE);

            frontLeft.setPower((leftStickY + leftStickX + rightStickX)/buddy);
            frontRight.setPower((leftStickY - leftStickX - rightStickX)/buddy);
            backLeft.setPower((leftStickY - leftStickX + rightStickX)/buddy);
            backRight.setPower((leftStickY + leftStickX - rightStickX)/buddy);
        }
    }
}
