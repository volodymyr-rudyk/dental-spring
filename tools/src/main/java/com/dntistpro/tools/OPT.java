package com.dntistpro.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vrudyk on 11/30/2016.
 */
public class OPT {

  private static Logger logger = LoggerFactory.getLogger(OPT.class);

  public static void start() {
    logger.info("INFO");
    logger.warn("WARN");
    logger.debug("DEBUG");
    logger.error("ERROR");
  }
}
