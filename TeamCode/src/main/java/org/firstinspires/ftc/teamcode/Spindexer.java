package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Spindexer
{
    // motor ref
    DcMotor spinMotor;

    // pid
    ElapsedTime dt = new ElapsedTime();
    double kp,ki,kd = 0;
    double currentPIDOutput = 0;
    double lastError = 0;

    // speed config
    double spindexerSpeed = 0.1;

    public void init(HardwareMap hwMap)
    {
        spinMotor = hwMap.get(DcMotor.class, "spinMotor");
        spinMotor.setDirection(DcMotor.Direction.FORWARD);
        spinMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    private double PID(int target, int setpoint)
    {
        double error = target - setpoint;
        double derivative = (error - lastError)/dt.milliseconds();

        dt.reset();

        lastError = error;
        double output = error * kp + derivative * kd;
        return output;
    }

    public void StopSpindexer()
    {
        currentPIDOutput = PID(spinMotor.getCurrentPosition(), spinMotor.getCurrentPosition());
    }

    public void RunSpindexer()
    {
        currentPIDOutput = PID(spinMotor.getCurrentPosition() + 100, spinMotor.getCurrentPosition());
    }

    private void SetTarget()
    {
        spinMotor.setPower(currentPIDOutput * spindexerSpeed);
    }

    public void SetSpindexerPower(double input)
    {
        spinMotor.setPower(input);
    }
}