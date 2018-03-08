package io.github.cshadd.fetch_bot;
import io.github.cshadd.fetch_bot.util.Logger;
import io.github.cshadd.fetch_bot.util.Communication;

import com.bb8log.raspberrypi.adafruitmotorhat.AdafruitMotorHat;
import com.bb8log.raspberrypi.adafruitmotorhat.exception.MotorException;
import com.bb8log.raspberrypi.adafruitmotorhat.motor.MotorCommand;
import com.bb8log.raspberrypi.adafruitmotorhat.motor.stepper.StepStyle;
import com.bb8log.raspberrypi.adafruitmotorhat.motor.stepper.StepperMotor;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import java.io.IOException;

// Main
public class Core
implements FetchBot {
    // Private Static Instance/Property Fields
    private static Communication comm;
    private static Pathfinding path;

    // Entry Point
    public static void main(String[] args)
    throws IOException, MotorException, UnsupportedBusNumberException, InterruptedException {
        comm = new Communication();
        comm.resetToRobot();
        comm.resetToInterface();
        Logger.clear();
        Logger.info("Fetch Bot starting!");

        I2CBus i2CBus = I2CFactory.getInstance(1);
        AdafruitMotorHat hat = new AdafruitMotorHat(i2CBus);
        StepperMotor dcMotor = new StepperMotor(hat, 2, 200);
        dcMotor.setSpeed(30);
dcMotor.doSteps(100, MotorCommand.FORWARD, StepStyle.SINGLE);
//        while (comm.readToRobot("Stop").equals("0")) {
  //          delay(2000);
    //        Logger.info("Stepped");

      //  }
      try {
          Thread.sleep(2000); //1000 milliseconds is one second.
      } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
      }

        dcMotor.setSpeed(0);

        // loop...
        // import toRobot.json
        // store toRobot.json vars
        // if toRobot manualDrive...
        // driveControl

        // if not toRobot manualDrive...
        // pathfind and driveControl

        // send toInterface.json
        // clear toRobot.json accessed var
        // end loop...

        Logger.info("Fetch Bot terminating!");

        comm.resetToRobot();
        comm.resetToInterface();
    }
}
