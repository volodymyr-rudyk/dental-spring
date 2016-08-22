package com.dental.controller;

import com.dental.view.ViewConfig;
import com.dental.view.ViewFolderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 26.05.2015.
 */
@Controller
@RequestMapping("/search")
public class SearchPageController extends AbstractBasePageController {

  private static final Logger LOG = LoggerFactory.getLogger(SearchPageController.class);

  @RequestMapping(method = RequestMethod.GET)
  public String search() {
    return this.renderView(ViewConfig.PAGE_SEARCH);
  }

  @Override
  protected String getViewFolder() {
    return ViewFolderConfig.FOLDER_SEARCH;
  }
}